package control;

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
import view.Finestra_Configurazione;



public class Thread1_Configurazione implements Runnable{
	/*VerificaColorePulsante*/

	Finestra_Configurazione f;
	
	boolean continua = true;
	public Thread1_Configurazione(boolean continuaa) {
		continua=continuaa;
	}
	
	public void setContinua(boolean continuaa) {
		continua=continuaa;
	}
	
	public int contatore=0;
	public int contatorePrecedente=0;
	
	
	/**controlla se tutti i dati sono stati inseriti e dopodiché abilita il bottone,
	   non che lo colora:
	  						rosso 	(nessun dato)
							giallo 	(dati mancanti o errati)
							verde 	(dati	tutti immessi e tutti giusti)
	 */
	
	public void run() {
/*------------------------------------------------------------------*/
		while(continua) {
			/**controllo dei 3 box di provenienza, per se ogni box è pieno in cascata alla
			 * fine viene aggiunto 3 al contatore, e se il procedente contatore raggiunge 6,
			 * ovvero 3 box riempiti per più di 500 millisecondi allora va al passo successivo*/
			if(f.getDato1Risposta()!="") {
				if(f.getDato2Risposta()!="") {
					if(f.getDato3Risposta()!="") {
						if(contatore<1) {
							contatorePrecedente+=contatore;
						}else {
							contatore+=3;
						}
					}

					f.bottoneColoreStato("#eeee22");
				}
				f.bottoneColoreStato("#ff2222");
				contatore=0;
				contatorePrecedente=0;
				f.bottoneConfermaStato(false);
			}
			/**se per 2 volte viene rilevato che tutti i dati sono stati immessi
			 * il programma abilita il bottone, ferma questo
			 * ciclo e puoi proseguire*/
			if(contatorePrecedente>=6) {
				/**dati immessi tutti corretti, procedere*/
				f.bottoneColoreStato("#22ff22");
				f.bottoneConfermaStato(true);
				continua=false;
				break;
			}
			
			try {
				/**rilevamente movimenti ogni 250 millisecondi*/
				Thread.sleep(1*250);
				
			}catch(Exception e){ e.printStackTrace(); }
			
		}
	/*------------------------------------------------------------------*/
	}
}
