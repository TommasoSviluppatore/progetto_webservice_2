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
	private JTextField textField;
	
	public Finestra_MenuPrincipale() {
		getContentPane().setLayout(null);
		
		JPanel pannello2 = new JPanel();
		pannello2.setBounds(248, 0, 544, 404);
		getContentPane().add(pannello2);
		pannello2.setLayout(null);
		
		JTextPane txtpnNomeAzienda = new JTextPane();
		txtpnNomeAzienda.setText("Nome azienda: \t\t\t$azienda_per_soldi\r\n\t|"
				+ "-> valore:\t\t\t$100€\r\n\t|-> proprietario:\t$vignola_matteo"
				+ "\r\n\t|-> settore:\t\t\t$agricoltura\r\n\t|-> tipo "
				+ "azienda:\t$pubblica_privata_statale");
		txtpnNomeAzienda.setBounds(0, 0, 544, 404);
		pannello2.add(txtpnNomeAzienda);
		
		JPanel pannelloINFO = new JPanel();
		pannelloINFO.setBounds(0, 404, 792, 170);
		getContentPane().add(pannelloINFO);
		pannelloINFO.setLayout(null);
		
		JTextPane txtpnProprietarioInfonome = new JTextPane();
		txtpnProprietarioInfonome.setText("Proprietario info:\r\n\t|->Nome: \t\t\tvignola matteo,\r\n\t|->codice\r\n\t|\tfiscale:\t\t\t458538iojodijf90509\r\n\t|->partita iva:\t\tjgdroji50985409dgkjl\r\n\t|->telefono 1:\t\t+39 758 383 5858\r\n");
		txtpnProprietarioInfonome.setBounds(0, 0, 792, 170);
		pannelloINFO.add(txtpnProprietarioInfonome);
		
		JPanel pannelloLista = new JPanel();
		pannelloLista.setBounds(0, 0, 247, 404);
		getContentPane().add(pannelloLista);
		pannelloLista.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(69, 0, 178, 38);
		pannelloLista.add(textField);
		textField.setColumns(10);
		
		JLabel testoRicerca1 = new JLabel("Ricerca:");
		testoRicerca1.setBounds(0, 3, 69, 35);
		testoRicerca1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		pannelloLista.add(testoRicerca1);
		
		JPanel listaBottoniAziende = new JPanel();
		listaBottoniAziende.setBounds(0, 36, 247, 368);
		pannelloLista.add(listaBottoniAziende);
		listaBottoniAziende.setLayout(null);
		
		JButton BottoneGenerato1 = new JButton("Viva-gnor-ultura");
		BottoneGenerato1.setBounds(10, 11, 227, 53);
		listaBottoniAziende.add(BottoneGenerato1);
		
	}

	
	public void registraEvento(Controller_MenuPrincipale controller) {
		
	}
}
