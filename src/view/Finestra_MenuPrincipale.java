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
	        infoTestoProprietario.setText("Proprietario info:\r\n\t|->"
	        							+ "Nome: \t\t\t						vignola matteo				,\r\n\t|->"
	        							+ "codice\r\n\t|\tfiscale:\t\t\t	458538iojodijf90509			\r\n\t|->"
	        							+ "partita iva:\t\t					jgdroji50985409dgkjl		\r\n\t|->"
	        							+ "telefono 1:\t\t					+39 758 383 5858			\r\n");
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
	        infoTestoAzienda.setText("Nome azienda: \t\t\t			$azienda_per_soldi				\r\n\t|-> "
	        							+ "valore:\t\t\t			$100€							\r\n\t|-> "
	        							+ "proprietario:\t			$vignola_matteo 				\r\n\t|-> "
	        							+ "settore:\t\t\t			$agricoltura					\r\n\t|-> tipo "
	        							+ "azienda:\t				$pubblica_privata_statale");
	        
	        aggiungiAziende();
		
	}

	
	public void aggiungiAziendeBottoni() {
		String[] aziendaNomeEstratto = new String[80];
		
		String 		url, username, password;
		
		/**cambiare contesto e scritte in base a quale azienda stai premendo,ottenendo in numero del bottone premuto*/
		url = "jdbc:mysql://localhost:3306/websrvjavaxml";
		username = "username";
		password = "password";
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String query_old = "SELECT * FROM azienda_generica WHERE id_proprietario = ?";
		
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
	
	
	
	public void CambiaInfo_Azienda_e_proprietario_SuiBox(String query) {
		
		String 		aziendaNomeEstratto; float aziendaValoreEstratto; String aziendaProprietarioEstratto,
					aziendaSettoreEstratto,aziendaTipoEstratto;
		
		String 		proprietarioNomeEstratto,proprietarioCodFiscEstratto,proprietarioPIVAestratto,
					proprietarioTelefonoEstratto;
		
		String 		url, username, password;
		
		/**cambiare contesto e scritte in base a quale azienda stai premendo,ottenendo in numero del bottone premuto*/
		url = "jdbc:mysql://localhost:3306/websrvjavaxml";
        username = "username";
        password = "password";
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query_old = "SELECT * FROM azienda_generica WHERE id_proprietario = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Imposta il valore del parametro nella query
                pstmt.setInt(1, 1);
                
                // Esegue la query e ottiene il risultato
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Itera sui risultati e stampa le informazioni
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        aziendaNomeEstratto = rs.getString("nome");
                        aziendaValoreEstratto = rs.getFloat("valore");
                        aziendaProprietarioEstratto = rs.getString("proprietario");
                        aziendaSettoreEstratto= rs.getString("settore");
                        aziendaTipoEstratto= rs.getString("tipo_azienda");
                                            }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		/*commandi sql per estrare le informazioni*/
		
		
		
		
		/*----------------------------------------*/
		infoTestoAzienda.setText("Nome azienda: \t\t\t"	+aziendaNomeEstratto+			"\r\n\t|-> "
        						+ "valore:\t\t\t"		+aziendaValoreEstratto+			"\r\n\t|-> "
        						+ "proprietario:\t"		+aziendaProprietarioEstratto+	"\r\n\t|-> "
        						+ "settore:\t\t\t"		+aziendaSettoreEstratto+		"\r\n\t|-> tipo "
        						+ "azienda:\t$"			+aziendaTipoEstratto+			"");
		
		infoTestoProprietario.setText("Proprietario info:\r\n\t|->"
								+ "Nome: \t\t\t"					+proprietarioNomeEstratto+				"\r\n\t|->"
								+ "codice\r\n\t|\tfiscale:\t\t\t"	+proprietarioCodFiscEstratto+			"\r\n\t|->"
								+ "partita iva:\t\t"				+proprietarioPIVAestratto+				"\r\n\t|->"
								+ "telefono 1:\t\t"					+proprietarioTelefonoEstratto+			"\r\n");
	}
}
