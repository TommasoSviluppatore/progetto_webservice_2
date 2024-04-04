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
import java.sql.*;

import control.Controller_MenuPrincipale;

/*		da fare in modo che ogni bottone cambi schermata e cambi informazioni sull'azienda che si è scelti
 * 		fare in modo che il bottone possa essere premibile e seleziona l'azienda 
*/

public class Finestra_MenuPrincipale extends JFrame {
	Controller_MenuPrincipale contrrrr = new Controller_MenuPrincipale();
	
	private JTextField campoRicerca;
	private JPanel pannelloINFO, txtpnJPanel,txtPanel, pannelloLista, listaBottoniAziende;
	private JTextPane infoTestoAzienda, infoTestoProprietario;
	private JButton BottoneRicerca;

	    public Finestra_MenuPrincipale() {
	        getContentPane().setLayout(null);

	        pannelloINFO = new JPanel();
	        pannelloINFO.setBounds(500, 404, 792, 170);
	        getContentPane().add(pannelloINFO);
	        pannelloINFO.setLayout(null);

	        infoTestoProprietario = new JTextPane();
	        infoTestoProprietario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
	        infoTestoProprietario.setText("Proprietario info:\r\n\t|->Nome: \t\t\t\tvignola matteo\t\t\t\t,\r\n\t|->codice\r\n\t\tfiscale:\t\t\t\t458538iojodijf90509\t\t\t\r\n\t|->partita iva:\t\t\tjgdroji50985409dgkjl\t\t\r\n\t|->telefono 1:\t\t\t+39 758 383 5858\t\t\t\r\n");
	        infoTestoProprietario.setBounds(0, 0, 792, 170);
	        pannelloINFO.add(infoTestoProprietario);

	        pannelloLista = new JPanel();
	        pannelloLista.setBounds(0, 0, 275, 404);
	        getContentPane().add(pannelloLista);
	        pannelloLista.setLayout(null);

	        campoRicerca = new JTextField();
	        campoRicerca.setBounds(81, 0, 194, 38);
	        pannelloLista.add(campoRicerca);
	        campoRicerca.setColumns(10);

	        // Creazione del pannello scrollabile
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(0, 35, 275, 369);
	        pannelloLista.add(scrollPane);

	        // Creazione del pannello contenente i bottoni
	        listaBottoniAziende = new JPanel();
	        listaBottoniAziende.setLayout(new BoxLayout(listaBottoniAziende, BoxLayout.Y_AXIS)); // Imposta il layout a BoxLayout verticale
	        scrollPane.setViewportView(listaBottoniAziende);

	        BottoneRicerca = new JButton("Ricerca");
	        BottoneRicerca.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
	        BottoneRicerca.setBounds(0, 0, 83, 38);
	        pannelloLista.add(BottoneRicerca);
	        
	        infoTestoAzienda = new JTextPane();
	        infoTestoAzienda.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	        infoTestoAzienda.setBounds(274, 0, 518, 404);
	        getContentPane().add(infoTestoAzienda);
	        infoTestoAzienda.setText("Nome azienda: \t\t\t\t\t\t$azienda_per_soldi\t\t\t\t\r\n\t|-> valore:\t\t\t\t\t\t$100€\t\t\t\t\t\t\t\r\n\t|-> proprietario:\t\t\t\t$vignola_matteo \t\t\t\t\r\n\t|-> settore:\t\t\t\t\t\t$agricoltura\t\t\t\t\t\r\n\t|-> tipo azienda:\t\t\t\t$pubblica_privata_statale");
	        
	        aggiungiAziendeBottoniInizio();
		
	}

	    
	    
	    
	
	public void aggiungiAziendeBottoniInizio() {
		/**
		 			query per nome azienda singola
		
					SELECT a.nome 
					FROM azienda_generica AS a 
					INNER JOIN persona_generica AS b 
					ON a.id_proprietario = b.id; 
		
		*/
		String[] aziendaNomeEstratto = new String[80];
		
		String 		url, username, password;
		
		/**cambiare contesto e scritte in base a quale azienda stai premendo,ottenendo in numero del bottone premuto*/
		url = "jdbc:mysql://localhost:3306/websrvjavaxml";
		username = "username";
		password = "password";
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT nome FROM azienda_generica;";
		
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
			    // Imposta il valore del parametro nella query
			    pstmt.setInt(1, 1);
			    
			    // Esegue la query e ottiene il risultato
			    try (ResultSet rs = pstmt.executeQuery()) {
			        // Itera sui risultati e stampa le informazioni
			    	int i=0;
			        while (rs.next() || i<79) {
			            int id = rs.getInt("id");
			            aziendaNomeEstratto[i] = rs.getString("nome");
			            i++;
			        }
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/**aggiungere stringa di sql ed eseguibile che prende i dati da sql e mostra le aziende*/
		for (int i = 0; i < 10 || aziendaNomeEstratto[i]!=""; i++) {
            JButton button = new JButton(aziendaNomeEstratto +" "+ i + ""); // Crea un nuovo JButton con il nome specificato
            listaBottoniAziende.add(button); // Aggiungi il pulsante al pannello
        }

        // Ridisegna il pannello
        listaBottoniAziende.revalidate();
        listaBottoniAziende.repaint();
	}
	
	
	public void infoTestoAzienda_testoimposta(String Stringa) {
		infoTestoAzienda.setText(Stringa);
	}
	
	public void infoTestoProprietario_testoimposta(String Stringa) {
		infoTestoProprietario.setText(Stringa);
	}
	
	

	
	/**alla pressione di questo pulsante fare partire questa funzione*/
	public void ricercaPulsante() {
		listaBottoniAziende.removeAll();
		listaBottoniAziende.revalidate();
		listaBottoniAziende.repaint();
		contrrrr.ricercaNomeAziendaDaTesto(
				"SELECT * FROM azienda_generica"
				+ "where nome ="+campoRicerca.getText().toString()+";"
		);
	}
	
	public void resetPanelDopoRicerca(){
		aggiungiAziendeBottoniInizio();
	}
}
