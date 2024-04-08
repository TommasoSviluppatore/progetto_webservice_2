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


import view.Finestra_MenuPrincipale;

public class Avviatore {
	/**
	 	Avvio del programma
	*/
	public static void main (String args[]) {

		/**acaso*/
		Finestra_MenuPrincipale schermataPrincipale=new Finestra_MenuPrincipale();
		schermataPrincipale.setVisible(true);
		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
				
					/**avvio instanza in sottofondo passandogli il controller*/
					
					
					
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
