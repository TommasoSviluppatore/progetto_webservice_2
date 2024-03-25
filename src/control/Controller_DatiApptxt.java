package control;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import model.TimeSeriesData;

public class Controller_DatiApptxt {
	
	public Controller_DatiApptxt() {}
	//usare un file txt per tutte le impostazioni e trasferire tutti i dati su di esso
	
	/**
		configurazione dell'azienda da tenere sotto occhio e delle chiavi delle api
	*/
	String nomeAziendaInBorsa="";						String nomeAziendaInBorsa_DEFAULT="IBM";
	String chiaveApi="";								String chiaveApi_DEFAULT="BOERKFC7M8LZ48XG";
	int intervalloOgniAzione=60;						int intervalloOgniAzione_DEFAULT=60;
	String nomeUtente="";								String nomeUtente_DEFAULT="UTENTE";
	
	/**
		configurazione dell'azienda da tenere sotto occhio e delle chiavi delle api
	*/

	public String 	getNomeAzienda()			{	return nomeAziendaInBorsa;		}
	public String 	getChiaveApi()				{	return chiaveApi;				}
	public int		getIntervalloAzioniMinuto()	{	return intervalloOgniAzione;	}
	public String	getNomeUtente()				{ 	return nomeUtente;				}

	public String 	getNomeAziendaDEFAULT() 				{ 	return nomeAziendaInBorsa_DEFAULT; 		}
	public String 	getChiaveApiDEFAULT() 					{	return chiaveApi_DEFAULT;				}
	public int	 	getIntervalloAzioniMinutoDEFAULT()		{	return intervalloOgniAzione_DEFAULT;	}
	public String 	getNomeUtenteDEFAULT()					{ 	return nomeUtente_DEFAULT;				}
	
	public String 	dato3TempRisposta()		{return "prova1234";}
	
	

	String collegamentoPiùApi;
	
	
	String nomeFileDestinazione=	"config.txt";
	String limitatoreInizioDATI=	"--DATI\\n";
	String limitatoreInizioCONFIG=	"--CONFIG\\n";
	String limitatoreInizioALTRO=	"--ALTRO\\n";
	String configInizSORPASSO=		"++configurazione_fatta=si;";
	String criterioApiTrova=		"++api_valtage";
	
	
	
	
	/**sezione di salvataggio dati su file confi.txt*/
	public void scriviFileDatiConfig(	boolean configEffettuata,
										String nomeUtente, String apiChiave, String altro
			) {
		
		
		
		try{
			
			FileWriter filewriter=new FileWriter(nomeFileDestinazione,true);
			
			
			String datiString=limitatoreInizioCONFIG;
			
			datiString.concat("++configurazione_fatta=");
			datiString.concat((configEffettuata) ? "si\\n." : "no\\n");
			
			
			datiString.concat(limitatoreInizioDATI);

			datiString.concat("++nome_utente="+getNomeUtente()+";\\n");
			datiString.concat("++api_valtage="+getChiaveApi()+";\\n");
			datiString.concat("++dato2="+"xxx"+";\\n");
			datiString.concat(datiString+"\n");
			datiString.concat(limitatoreInizioALTRO);
			datiString.concat(altro);
			
			filewriter.write(datiString);
			
			System.out.println("dati salvati con successo");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n qualcosa è andato storto...");
		}
		
	}
	
	
	/**controlla se la configurazione è già stata fatta*/
	public String verificaConfigGiàFatta() {

		String lineaLetta=""; boolean fermati=false;
		
		try{
			/**cerca la linea di testo e il valore si o no
			 * per sapere se la configurazione è giù stata fatta*/
			BufferedReader filereader=new BufferedReader(new FileReader(nomeFileDestinazione));
			while((lineaLetta=filereader.readLine())!=null && !fermati) {
				if(lineaLetta.trim().equals(limitatoreInizioCONFIG)) {
					fermati=true;
					break;
				}
			}
			
			if(lineaLetta==null) {
				return "no";
			}
			
			String[] divisioneRighe = lineaLetta.split(";");
			
			/**verifica se la riga si trova sulla posizione corretta*/
			if(lineaLetta.contains(configInizSORPASSO)) {
		        for (int i = 0; i < divisioneRighe.length; i++) {
		            if (divisioneRighe[i].contains(configInizSORPASSO)) {
		            	if(i==2) {
		            		return "SORPASSA_CONFIGURAZIONE";
		            	}
		            }
		        }
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("\n qualcosa è andato storto...");
		}
		
		
		return "no";
	}
	
	
	
	
	/**legge i dati della chiave api
	 **/
	public String leggiChiaveApi() throws FileNotFoundException{
		
		BufferedReader reader = new BufferedReader(new FileReader(nomeFileDestinazione));
		String temporaneo;

        try{
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea++;
                if (linea.contains(criterioApiTrova)) {
                	break;
                }
            }
            
            // Trova l'indice del carattere "="
            int indiceUguale = linea.indexOf('=');
            // Trova l'indice del carattere ";"
            int indicePuntoEVirgola = linea.indexOf(';');
            
            return linea.substring(indiceUguale + 1, indicePuntoEVirgola);
            
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }

        return "errore";
	}
	
	
	
	
	public String getXMLdaJson() throws JAXBException {

		collegamentoPiùApi=
				
							"https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY"	+
							/** nome azienda da chiedere al sito*/
							"&symbol="		+nomeAziendaInBorsa_DEFAULT  						+  
							/**intervallo ogni quanto dirci quanto valeva l'azienda*/
							"&interval="	+intervalloOgniAzione_DEFAULT						+"min"+
							/**chiave api per interrogazione*/
							"&apikey="		+chiaveApi_DEFAULT									+"";
		
		
		
		
		
		/**la richiesta che arriva in formato JSON*/
		String rispostaTempJSON="";
		
		/**prova a scaricare dal collegamento il json*/
		try{
			/**creazione dell'url*/
			URL url = new URL(collegamentoPiùApi);
			/**invio della richiesta*/
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            /**ricezione e scrittura del testo su un file*/
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((rispostaTempJSON = reader.readLine()) != null) {
                response.append(rispostaTempJSON);
            }
            reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}



		
        /** Inizializzazione dell'interfaccia JAXB*/
		TimeSeriesData datijsonaxml = new TimeSeriesData();
        JAXBContext context = JAXBContext.newInstance(model.TimeSeriesData.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        
        
        /** Conversione della stringa XML in un oggetto Java*/
        String XMLfinale="";
		try {
			XMLfinale= (String) context.createUnmarshaller().unmarshal(new StringReader(rispostaTempJSON));
			
		} catch (JAXBException e) { e.printStackTrace(); }

		
		
        /**Salvataggio dell'oggetto Java in un file XML*/
        File XMLFile = new File("borsa.xml");
        marshaller.marshal(XMLfinale, XMLFile);

        System.out.println("File XML creato con successo: " + XMLFile.getAbsolutePath());
        
        return XMLFile.toString();
	}
	
	
}
