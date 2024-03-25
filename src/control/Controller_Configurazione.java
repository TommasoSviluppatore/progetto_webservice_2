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

import view.Finestra_Configurazione;
import control.Controller_DatiApptxt;

public class Controller_Configurazione implements ActionListener{
	
	private Finestra_Configurazione finestra;
	private Controller_DatiApptxt datiFileLeggiScrivi;
	
	
	 /**impostazione del controller*/
	public Controller_Configurazione(	Finestra_Configurazione frame,
										Controller_DatiApptxt dati) {
		this.finestra=frame;
		//finestra.registraEvento(this);
        this.datiFileLeggiScrivi = dati;
	}
	
	
	/**	conferma con bottone, quindi salvataggio dei dati, chiusura della finestra e 
		apertura di quello principale
	*/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==finestra.getConfermaConf()) {
			/*
			 	chiudi la finestra e apri quella principale esportando i dati
			  	trasferisci i dati su un file txt e usa quello
			*/
			finestra.chiudiFinestra();
		}
	}
	
	
	
	

	/**
		configurazione dell'azienda da tenere sotto occhio e delle chiavi delle api
	*/
	public String 	getNomeAzienda()			{	return datiFileLeggiScrivi.getNomeAzienda();		}
	public String 	getChiaveApi()				{	return datiFileLeggiScrivi.getChiaveApi();				}
	public int		getIntervalloAzioniMinuto()	{	return datiFileLeggiScrivi.getIntervalloAzioniMinuto();	}
	public String	getNomeUtente()				{ 	return datiFileLeggiScrivi.getNomeUtente();				}
	
	public String 	getNomeAziendaDEFAULT() 				{ 	return datiFileLeggiScrivi.getNomeAziendaDEFAULT(); 		}
	public String 	getChiaveApiDEFAULT() 					{	return datiFileLeggiScrivi.getChiaveApiDEFAULT();				}
	public int	 	getIntervalloAzioniMinutoDEFAULT()		{	return datiFileLeggiScrivi.getIntervalloAzioniMinutoDEFAULT();	}
	public String 	getNomeUtenteDEFAULT()					{ 	return datiFileLeggiScrivi.getNomeUtenteDEFAULT();				}

	
	public String 	dato3TempRisposta()		{return (String) datiFileLeggiScrivi.dato3TempRisposta();}
	
	
	
	
	
	public String ottieniStringaDaSito() throws Exception{
		Controller_DatiApptxt commando=new Controller_DatiApptxt();
		return commando.getXMLdaJson();
	}
}
