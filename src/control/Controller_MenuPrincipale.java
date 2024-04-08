package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import java.net.URL;
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

import view.Finestra_MenuPrincipale;


public class Controller_MenuPrincipale {
	Finestra_MenuPrincipale finestraMain;

	
	String 		aziendaNomeEstratto; 		float aziendaValoreEstratto; 	String aziendaProprietarioEstratto,
				aziendaSettoreEstratto,		aziendaTipoEstratto;

	String 		proprietarioNomeEstratto,	proprietarioCodFiscEstratto,	proprietarioPIVAestratto,
				proprietarioTelefonoEstratto;

	String 		url, 	username, 	password;

	
	
	public void CambiaInfoAzienda(String query) {
		
		
		/**cambiare contesto e scritte in base a quale azienda stai premendo,ottenendo in numero del bottone premuto*/
		
		
		/*commandi sql per estrare le informazioni dell'azienda*/
		url = "localhost:3306/websrvjavaxml";
        username = "username";
        password = "password";
        ResultSet rs2 = null;
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Imposta il valore del parametro nella query
                pstmt.setInt(1, 1);
                
                // Esegue la query e ottiene il risultato
                try (ResultSet rs = pstmt.executeQuery(query)) {
                	rs2=rs;
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
        
		/*----------------------------------------*/
        String verifica1=rs2.toString();
        if(verifica1!="Empty set (0.000 sec)") {
        	finestraMain.infoTestoAzienda_testoimposta("Nome azienda: \t\t\t"	+aziendaNomeEstratto+			"\r\n\t|-> "
					+ "valore:\t\t\t"		+aziendaValoreEstratto+			"\r\n\t|-> "
					+ "proprietario:\t"		+aziendaProprietarioEstratto+	"\r\n\t|-> "
					+ "settore:\t\t\t"		+aziendaSettoreEstratto+		"\r\n\t|-> tipo "
					+ "azienda:\t$"			+aziendaTipoEstratto+			"");
        	
        }else 
        	
        	
        if(verifica1=="Empty set (0.000 sec)"){
        	finestraMain.infoTestoAzienda_testoimposta("azienda non esistente");
        	
        }else
        	
        	
        	
        {
        	finestraMain.infoTestoAzienda_testoimposta("errore generico (0x00000000)");
        	
        }
        
       
		
		/*commandi sql per estrare le informazioni dell'azienda*/
	}
	
	
	
	public void CambiaInfoProprietario(String query) {
		ResultSet rs2=null;
		
        /*commandi sql per estrare le informazioni del proprietario*/
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Imposta il valore del parametro nella query
                pstmt.setInt(1, 1);
                
                // Esegue la query e ottiene il risultato
                try (ResultSet rs = pstmt.executeQuery(query)) {
                	rs2=rs;
                    // Itera sui risultati e stampa le informazioni
                	
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        proprietarioNomeEstratto = rs.getString("nome");
                        proprietarioCodFiscEstratto = rs.getString("codice_fiscale");
                        proprietarioPIVAestratto= rs.getString("partita_iva");
                        proprietarioTelefonoEstratto=rs.getString("telefono");
                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        /*commandi sql per estrare le informazioni del proprietario*/
        
        String verifica1=rs2.toString();
        if(verifica1!="Empty set (0.000 sec)") {
        	finestraMain.infoTestoProprietario_testoimposta("Proprietario info:\r\n\t|->"
					+ "Nome: \t\t\t"					+proprietarioNomeEstratto+				"\r\n\t|->"
					+ "codice\r\n\t|\tfiscale:\t\t\t"	+proprietarioCodFiscEstratto+			"\r\n\t|->"
					+ "partita iva:\t\t"				+proprietarioPIVAestratto+				"\r\n\t|->"
					+ "telefono 1:\t\t"					+proprietarioTelefonoEstratto+			"\r\n"		
        			);
        	
        }else 
        	
        	
        if(verifica1=="Empty set (0.000 sec)"){
        	finestraMain.infoTestoProprietario_testoimposta("azienda non esistente");
        	
        }else
        	
        	
        	
        {
        	finestraMain.infoTestoProprietario_testoimposta("errore generico (0x00000000)");
        	
        }
		
		
	}
	
	
	
	
	
	
	
	
	public void ricercaNomeAziendaDaTesto(String query) {
		
        /*commandi sql per estrare le informazioni del proprietario*/
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                // Imposta il valore del parametro nella query
                pstmt.setInt(1, 1);
                
                // Esegue la query e ottiene il risultato
                try (ResultSet rs = pstmt.executeQuery(query)) {
                    // Itera sui risultati e stampa le informazioni
                	
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        proprietarioNomeEstratto = rs.getString("nome");
                        proprietarioCodFiscEstratto = rs.getString("codice_fiscale");
                        proprietarioPIVAestratto= rs.getString("partita_iva");
                        proprietarioTelefonoEstratto=rs.getString("telefono");
                    }
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        /*commandi sql per estrare le informazioni del proprietario*/
		
		finestraMain.infoTestoProprietario_testoimposta("Proprietario info:\r\n\t|->"
								+ "Nome: \t\t\t"					+proprietarioNomeEstratto+				"\r\n\t|->"
								+ "codice\r\n\t|\tfiscale:\t\t\t"	+proprietarioCodFiscEstratto+			"\r\n\t|->"
								+ "partita iva:\t\t"				+proprietarioPIVAestratto+				"\r\n\t|->"
								+ "telefono 1:\t\t"					+proprietarioTelefonoEstratto+			"\r\n"		
		);
	}
	
	
	public void RicercaPulsante() {
		Thread mioThread = new Thread(new Runnable() {
            @Override
            public void run() {
            	//finestraMain.???
            }
        });
        mioThread.start();
	}
}
