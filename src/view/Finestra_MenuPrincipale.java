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
	private JTextField campoRicerca;
	private JPanel pannelloINFO, txtpnJPanel,txtPanel, pannelloLista, listaBottoniAziende;
	private JTextPane infoTestoAzienda, infoTestoProprietario;
	private JButton BottoneRicerca;

	    public Finestra_MenuPrincipale() {
	        getContentPane().setLayout(null);

	        pannelloINFO = new JPanel();
	        pannelloINFO.setBounds(0, 404, 792, 170);
	        getContentPane().add(pannelloINFO);
	        pannelloINFO.setLayout(null);

	        infoTestoProprietario = new JTextPane();
	        infoTestoProprietario.setText("Proprietario info:\r\n\t|->Nome: \t\t\tvignola matteo,\r\n\t|->codice\r\n\t|\tfiscale:\t\t\t458538iojodijf90509\r\n\t|->partita iva:\t\tjgdroji50985409dgkjl\r\n\t|->telefono 1:\t\t+39 758 383 5858\r\n");
	        infoTestoProprietario.setBounds(0, 0, 792, 170);
	        pannelloINFO.add(infoTestoProprietario);

	        pannelloLista = new JPanel();
	        pannelloLista.setBounds(0, 0, 247, 404);
	        getContentPane().add(pannelloLista);
	        pannelloLista.setLayout(null);

	        campoRicerca = new JTextField();
	        campoRicerca.setBounds(69, 0, 178, 38);
	        pannelloLista.add(campoRicerca);
	        campoRicerca.setColumns(10);

	        // Creazione del pannello scrollabile
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(0, 36, 247, 368);
	        pannelloLista.add(scrollPane);

	        // Creazione del pannello contenente i bottoni
	        listaBottoniAziende = new JPanel();
	        listaBottoniAziende.setLayout(new BoxLayout(listaBottoniAziende, BoxLayout.Y_AXIS)); // Imposta il layout a BoxLayout verticale
	        scrollPane.setViewportView(listaBottoniAziende);

	        BottoneRicerca = new JButton("Ricerca");
	        BottoneRicerca.setBounds(0, 0, 72, 38);
	        pannelloLista.add(BottoneRicerca);
	        
	        infoTestoAzienda = new JTextPane();
	        infoTestoAzienda.setBounds(248, 0, 544, 404);
	        getContentPane().add(infoTestoAzienda);
	        infoTestoAzienda.setText("Nome azienda: \t\t\t$azienda_per_soldi\r\n\t|"
	        		+ "-> valore:\t\t\t$100€\r\n\t|-> proprietario:\t$vignola_matteo"
	        		+ "\r\n\t|-> settore:\t\t\t$agricoltura\r\n\t|-> tipo "
	        		+ "azienda:\t$pubblica_privata_statale");
	        
	        aggiungiAziende();
		
	}

	
	public void aggiungiAziende() {
		/**aggiungere stringa di sql ed eseguibile che prende i dati da sql e mostra le aziende*/
		for (int i = 0; i < 10; i++) {
            JButton button = new JButton("vignola" + i + ""); // Crea un nuovo JButton con il nome specificato
            listaBottoniAziende.add(button); // Aggiungi il pulsante al pannello
        }

        // Ridisegna il pannello
        listaBottoniAziende.revalidate();
        listaBottoniAziende.repaint();
	}
	
	public void visualizzaInfoAzienda() {
		/**cambiare contesto e scritte in base a quale azienda stai premendo*/
		
		/*commandi sql per estrare le informazioni*/
		
		/*----------------------------------------*/
		infoTestoAzienda.setText("Nome azienda: \t\t\t"+aziendaNomeEstratto+"\r\n\t|"
        		+ "-> valore:\t\t\t"+aziendaValoreEstratto+"\r\n\t|-> proprietario:\t"+aziendaProprietarioEstratto+
        		"\r\n\t|-> settore:\t\t\t"+aziendaSettoreEstratto+"\r\n\t|-> tipo "
        		+ "azienda:\t$"+aziendaTipoEstratto+"");
		
		infoTestoProprietario.setText("");
	}
}
