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


import control.Controller_Borsa;
import view.Finestra_Borsa;



public class Thread1_borsa 
					/*testolampeggiante*/ implements Runnable{

	Finestra_Borsa f;
	
	boolean continua = true;
	public Thread1_borsa(boolean continuaa) {
		continua=continuaa;
	}
	
	public void setContinua(boolean continuaa) {
		continua=continuaa;
	}
	
	public int contatore=0;
	public int contatorePrecedente=0;
	
	
	public void run() {
/*------------------------------------------------------------------*/
		while(continua) {
			f.fraseIniz1.hide();
			f.parolaDaModificare.hide();
			
			try {
				/**lampeggiare testo ogni 1000*/
				Thread.sleep(1*1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			f.fraseIniz1.show();
			f.parolaDaModificare.show();
			
		}
	/*------------------------------------------------------------------*/
	}
}
