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

import control.Controller_MenuPrincipale;


public class Finestra_MenuPrincipale extends JFrame {
	
	/**prende la frase utente dal controller e dal file*/
	JLabel fraseIniziale;
	public String nome_utente="";
	public void setUtente(String a) {
		nome_utente=a;
		fraseIniziale.setText("Benvenuto"+nome_utente+",  Cosa vuoi fare?"); 
	}
	
	
	
	public JLabel Crediti;
	public JButton ricordareNomeAzienda, inserireNomeAzienda, mercatoPrecedente, mercatoAttuale, mercatoSuccessivo;

	public Finestra_MenuPrincipale() {
		
		/**
		 	Da fare ancora il controllo delle variabili con il relativo
		 	sorpasso e verifica
		*/
		/*if()
			*/

		setBounds(100, 100, 718, 417);
		
		setTitle("Borsa azioni osservatore di Poors&homeless people company");
		setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		setBackground(new Color(240, 240, 240));
		getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		getContentPane().setBackground(new Color(238, 238, 238));
		getContentPane().setLayout(null);
		
		fraseIniziale = new JLabel();
		fraseIniziale.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		fraseIniziale.setBounds(215, 11, 237, 28);
		getContentPane().add(fraseIniziale);
		
		mercatoPrecedente = new JButton("Com'era il mercato ieri?");
		mercatoPrecedente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		mercatoPrecedente.setBounds(10, 150, 183, 39);
		getContentPane().add(mercatoPrecedente);
		
		inserireNomeAzienda = new JButton("Inserisci azienda da tenere traccia");
		inserireNomeAzienda.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		inserireNomeAzienda.setBounds(10, 100, 345, 39);
		getContentPane().add(inserireNomeAzienda);
		
		mercatoSuccessivo = new JButton("Voglio una previsione...");
		mercatoSuccessivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mercatoSuccessivo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		mercatoSuccessivo.setBounds(510, 150, 189, 39);
		getContentPane().add(mercatoSuccessivo);
		
		mercatoAttuale = new JButton("Qual'è il valore attuale?");
		mercatoAttuale.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		mercatoAttuale.setBounds(263, 150, 189, 39);
		getContentPane().add(mercatoAttuale);
		
		ricordareNomeAzienda = new JButton("Ricordami il nome dell' azienda da tenere traccia");
		ricordareNomeAzienda.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		ricordareNomeAzienda.setBounds(365, 100, 339, 39);
		getContentPane().add(ricordareNomeAzienda);
		
		Crediti=new JLabel("Sviluppato da TommasoSviluppatore e MiAppendoAlPeroDallaPazienza [Tubia Tommaso, Perazzetta Davide]  ⓒ 2024");
		Crediti.setHorizontalAlignment(SwingConstants.CENTER);
		Crediti.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		Crediti.setBounds(-4, 433, 739, 28);
		getContentPane().add(Crediti);
	}

	
	public void registraEvento(Controller_MenuPrincipale controller) {
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
