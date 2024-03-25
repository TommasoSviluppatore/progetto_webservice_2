package view;

import java.net.URL;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import control.Controller_Configurazione;
import control.Thread1_Configurazione;
import control.Controller_DatiApptxt;
import control.Controller_MenuPrincipale;
import control.Controller_database1;


public class Finestra_Configurazione extends JFrame {
	
	//Controller_Configurazione controllerGenerale;
	
	public JLabel frasePrimaConfigurazione, dato1Etichetta, dato2Etichetta, dato3Etichetta;
	public JTextPane dato1Risposta, dato2Risposta, dato3Risposta;
	public JButton bottoneConfermaConfigurazione;
	
	/**acaso*/
	Finestra_MenuPrincipale schermataPrincipale=new Finestra_MenuPrincipale();
	Finestra_Borsa schermataBorsa = new Finestra_Borsa();	
	Controller_DatiApptxt controllerDati = new Controller_DatiApptxt();
	Controller_Configurazione controllerConfig = new Controller_Configurazione(this, controllerDati);
	Controller_database1 controllerDatab = new Controller_database1();
	
	
	
	
	public Finestra_Configurazione() {
		
		//this.controllerGenerale=controllerGenerale;
		/*	
			importa controller generale e falli fare il bypass della
		 	configurazione in caso di configurazione già presente
		*/
		/**	controllo di verifica dati, se il porgramma
		 	è già configurato: salta questa sezione e avvia l'interfaccia principale
		 */
		if(controllerDati.verificaConfigGiàFatta()=="SORPASSA_CONFIGURAZIONE") {

			EventQueue.invokeLater(new Runnable() {
				
				public void run() {
					try {
						
						
						chiudiFinestra();
				        schermataPrincipale = new Finestra_MenuPrincipale();
						schermataPrincipale.setVisible(true);
						Controller_MenuPrincipale c1=new Controller_MenuPrincipale(schermataPrincipale);
						
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("\n qualcosa è andato storto...");
						try {
							Thread.sleep((2*1000));
						} catch (InterruptedException e1) {
							System.out.println("\n qualcosa è andato molto storto...");
							e1.printStackTrace();
						}
					}
				}
			});
			this.hide();
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 417);
		
		setTitle("Borsa azioni osservatore di Poors&homeless people company");
		setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		setBackground(new Color(240, 240, 240));
		getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		getContentPane().setBackground(new Color(238, 238, 238));
		getContentPane().setLayout(null);
		
		
		frasePrimaConfigurazione = new JLabel("Benvenuto utente. Questa è la prima volta che sei qui? Configurami, quindi...");
		frasePrimaConfigurazione.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		frasePrimaConfigurazione.setBounds(117, 11, 487, 28);
		getContentPane().add(frasePrimaConfigurazione);
		

		
		dato1Etichetta = new JLabel("Come vuoi essere chiamato :");
		dato1Etichetta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		dato1Etichetta.setBounds(10, 91, 189, 20);
		getContentPane().add(dato1Etichetta);
		
		dato1Risposta = new JTextPane();
        dato1Risposta.setText(controllerConfig.getNomeUtenteDEFAULT());
		dato1Risposta.setBounds(20, 119, 146, 28);
		getContentPane().add(dato1Risposta);
		
		
		
		dato2Etichetta = new JLabel("Collegamento API di alphavantage");
		dato2Etichetta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		dato2Etichetta.setBounds(239, 91, 222, 20);
		getContentPane().add(dato2Etichetta);
		
		dato2Risposta = new JTextPane();
		dato2Risposta.setText(controllerConfig.getChiaveApiDEFAULT());
		dato2Risposta.setBounds(270, 119, 160, 28);
		getContentPane().add(dato2Risposta);

		
		
		dato3Etichetta = new JLabel("???");
		dato3Etichetta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		dato3Etichetta.setBounds(540, 91, 153, 20);
		dato2Risposta.setText(controllerConfig.dato3TempRisposta());
		getContentPane().add(dato3Etichetta);
		
		dato3Risposta = new JTextPane();
		dato3Risposta.setBounds(540, 119, 149, 36);
		getContentPane().add(dato3Risposta);
	
		
		
		
		bottoneConfermaConfigurazione = new JButton("Configurazione effettuata!");
		bottoneConfermaConfigurazione.setForeground(new Color(0, 0, 0));
		bottoneConfermaConfigurazione.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		bottoneConfermaConfigurazione.setBounds(151, 338, 413, 36);
		getContentPane().add(bottoneConfermaConfigurazione);
		
		Thread1_Configurazione bottoneDivertente=new Thread1_Configurazione(true);
		new Thread(bottoneDivertente, "true").start();
	}
	

	/**restitusce i dati delle 3 scatole di testo*/
	public String getDato1Risposta() { return getDato1Risposta().toString(); }
	public String getDato2Risposta() { return getDato2Risposta().toString(); }
	public String getDato3Risposta() { return getDato3Risposta().toString(); }
	
	
	
	/**collegamento con il controller*/
	public void registraEvento(Controller_Configurazione controllerGenerale) {
		bottoneConfermaConfigurazione.addActionListener(controllerGenerale);
	}
	
	public JButton getConfermaConf() { return bottoneConfermaConfigurazione; }
	
	public void chiudiFinestra() {
	    schermataPrincipale = new Finestra_MenuPrincipale();
	    Container contentPane = getContentPane();
	    contentPane.add(schermataPrincipale);
	    setVisible(false);
	    schermataPrincipale.setVisible(true);
	    Controller_MenuPrincipale c1 = new Controller_MenuPrincipale(schermataPrincipale);
		this.dispose(); 
		System.out.println("funziona");
	}
	
	public void bottoneConfermaStato(boolean attivazione) {
		bottoneConfermaConfigurazione.setEnabled(attivazione);
	}
	/**colora il pulsante di un colore personalizzato*/
	public void bottoneColoreStato(String data) {
		bottoneConfermaConfigurazione.setBackground(Color.decode(data));
	}
	

	public void initCMDSQLmetodo1() {
		controllerDatab.connessioneConCMD_CLASSICO("mysql -h localhost -u root -p");
		controllerDatab.connessioneConCMD_CLASSICO("use  websrvJavaXML;");
		controllerDatab.connessioneConCMD_CLASSICO("\\T _log_generico.txt");
	}

	
	
	
	/*private void initializationBtn() {
		this.btnStart.setEnabled(true);
		this.btnAddCar.setEnabled(false);
		this.btnRemoveCar.setEnabled(false);
		this.btnPause.setEnabled(false);
		this.btnResume.setEnabled(false);
		this.btnRestart.setEnabled(false);
		this.btnStop.setEnabled(false);
	}*/
}
