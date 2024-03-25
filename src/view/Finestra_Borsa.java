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

import control.Controller_Borsa;
import control.Thread1_borsa;

public class Finestra_Borsa extends JFrame {
	
	public JLabel fraseIniz1, parolaDaModificare, valoreDellaBorsaNumerico;
	public JPanel tabellaAzioniGrafico, graficoDisegnoFinestra;
	Thread1_borsa erroreEffetto=new Thread1_borsa(false);
	
	public Finestra_Borsa() {
		
		setBounds(100, 100, 860, 600);
		
		getContentPane().setLayout(null);
		
		fraseIniz1 = new JLabel("Il valore delle azioni");
		fraseIniz1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		fraseIniz1.setBounds(182, 11, 171, 43);
		getContentPane().add(fraseIniz1);
		
		/**aumentato o diminuito in base alla valore della borsa*/
		parolaDaModificare = new JLabel("(da modificare // aumentato, diminuito)");
		parolaDaModificare.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		parolaDaModificare.setBounds(342, 11, 188, 43);
		getContentPane().add(parolaDaModificare);
		
		/**disegnare un grafico lineare con il valore della borsa*/
		graficoDisegnoFinestra = new JPanel();
		graficoDisegnoFinestra.setBackground(new Color(204, 255, 206));
		graficoDisegnoFinestra.setBounds(10, 65, 357, 412);
		getContentPane().add(graficoDisegnoFinestra);
		
		valoreDellaBorsaNumerico = new JLabel("(Da modificacare // valore numerico della borsa)");
		valoreDellaBorsaNumerico.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 39));
		valoreDellaBorsaNumerico.setBounds(422, 79, 253, 53);
		getContentPane().add(valoreDellaBorsaNumerico);
		
		/**tabella 2x6 con tutti i valori della borsa*/
		tabellaAzioniGrafico = new JPanel();
		tabellaAzioniGrafico.setBackground(new Color(244, 244, 244));
		tabellaAzioniGrafico.setBounds(400, 143, 336, 334);
		getContentPane().add(tabellaAzioniGrafico);
	}
	
	public void registraEvento(Controller_Borsa controller) {
	}
	
	/*da fare le scritte rosse, gialle o verdi in base se il valore
	 * è aumentato, diminuito e invariato*/
	
	public void setColoreGraficoLineare() {
		double valoreDellaBorsa=0/*leggere il valore della borsa attuale*/;
		double valoreDellaBorsaPREC=(-1.5895489)/*leggere il valore della borsa precedente */;
		if(valoreDellaBorsa>valoreDellaBorsaPREC) {
			this.tabellaAzioniGrafico.setBackground(Color.decode("#22ff22"));
			this.parolaDaModificare.setText("aumentato");
			this.fraseIniz1.setForeground(Color.decode("#22ff22"));
		}
		
		else if(valoreDellaBorsa==valoreDellaBorsaPREC) {
			this.tabellaAzioniGrafico.setBackground(Color.decode("#666600"));
			this.parolaDaModificare.setText("invariato");
			this.fraseIniz1.setForeground(Color.decode("#666600"));
		}
		
		else if(valoreDellaBorsa<valoreDellaBorsaPREC) {
			this.tabellaAzioniGrafico.setBackground(Color.decode("#dd0000"));
			this.parolaDaModificare.setText("diminuito");
			this.fraseIniz1.setForeground(Color.decode("#dd0000"));
		}
		
		else {
			this.tabellaAzioniGrafico.setBackground(Color.decode("#00000"));
			this.parolaDaModificare.setText("errore");
			this.fraseIniz1.setForeground(Color.decode("#000000"));
			this.fraseIniz1.setText("ERRORE");
			new Thread1_borsa(true);
		}
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
	
	public void estraiValoreGraficoDellaBorsa() {
		/**da fare una tabella con tutti i valori della borsa sul grafico */
	}
}
