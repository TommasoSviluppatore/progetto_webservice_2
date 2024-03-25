package client;

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
import view.Finestra_Borsa;
import view.Finestra_Configurazione;
import view.Finestra_MenuPrincipale;
import control.Controller_DatiApptxt;

public class Avviatore {
	/**
	 	Avvio del programma
	*/
	public static void main (String args[]) {

		/**acaso*/
		Finestra_MenuPrincipale schermataPrincipale=new Finestra_MenuPrincipale();
		Finestra_Borsa schermataBorsa = new Finestra_Borsa();
		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
				
					/**avvio instanza in sottofondo passandogli il controller*/
					Finestra_Configurazione schermataConfigurazione= new Finestra_Configurazione();
					schermataConfigurazione.setVisible(true);
					Controller_DatiApptxt c1=new Controller_DatiApptxt();
					Controller_Configurazione c=new Controller_Configurazione(schermataConfigurazione, c1);
					
					
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
		
		
		
	}
	
	
	
}
