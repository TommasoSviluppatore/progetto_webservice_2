package view;

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

import javax.activation.CommandInfo;
import javax.swing.*;
import javax.xml.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.sql.*;

public class Finestra_GestioneDatabase extends JFrame{
	
	JPanel 			panelPrincipp, pannelloFunzioni,pannelloAzienda,pannelloProprietario,pannelloCommandiInPiccolo;
	JButton 		aggiungiBottone,eliminaBottone, aggiungiBottone_2;
	JTabbedPane 	pannelloMultipla;
	JRadioButton 	rdbtnNewRadioButton_4, rdbtnNewRadioButton_3,rdbtnNewRadioButton_2,rdbtnNewRadioButton_1;
	JTextArea 		testoHH;
	JLabel 			commandoFinestraTitolo;
	
	
	JTextPane 		inserimentoAziendaID, inserimentoAziendaNome,
					inserimentoAziendaValore,inserimentoAziendaProprietario,inserimentoAziendaTipo,inserimentoAziendaIDProprietario;
	
	JLabel 			scrittaAziendaID,scrittaAziendaNome,scrittaAziendaValore,scrittaAziendaProprietario, 
					scrittaAziendaSettore, scrittaAziendaTipo, scrittaAziendaIDProprietario;
	
	
	JTextPane		inserimentoProprietarioID,inserimentoProprietarioNome,inserimentoProprietarioPartitaIva,
					inserimentoProprietarioCodiceFiscale, inserimentoProprietarioTelefono;
	
	JLabel			scrittaProprietarioID,scrittaProprietarioNome,scrittaProprietarioPartitaIva, scrittaProprietarioCodiceFiscale,
					scrittaProprietarioTelefono;
	
	
	public Finestra_GestioneDatabase() {
		getContentPane().setLayout(null);
		
		panelPrincipp = new JPanel();
		panelPrincipp.setBounds(0, 0, 591, 423);
		getContentPane().add(panelPrincipp);
		panelPrincipp.setLayout(null);
		
		aggiungiBottone = new JButton("Aggiungi");
		aggiungiBottone.setBounds(459, 11, 122, 39);
		aggiungiBottone.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		panelPrincipp.add(aggiungiBottone);
		
		eliminaBottone = new JButton("Elimina");
		eliminaBottone.setBounds(459, 84, 122, 39);
		eliminaBottone.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		panelPrincipp.add(eliminaBottone);
		
		aggiungiBottone_2 = new JButton("New button");
		aggiungiBottone_2.setBounds(459, 163, 122, 39);
		aggiungiBottone_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		panelPrincipp.add(aggiungiBottone_2);
		
		pannelloFunzioni = new JPanel();
		pannelloFunzioni.setBounds(0, 0, 449, 423);
		panelPrincipp.add(pannelloFunzioni);
		pannelloFunzioni.setLayout(null);
		
		pannelloMultipla = new JTabbedPane(JTabbedPane.BOTTOM);
		pannelloMultipla.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		pannelloMultipla.setBounds(0, 0, 449, 423);
		pannelloFunzioni.add(pannelloMultipla);
		
		pannelloAzienda = new JPanel();
		pannelloMultipla.addTab("New tab", null, pannelloAzienda, null);
		pannelloAzienda.setLayout(null);
		
		inserimentoAziendaID = new JTextPane();
		inserimentoAziendaID.setBounds(10, 11, 133, 27);
		pannelloAzienda.add(inserimentoAziendaID);
		
		inserimentoAziendaNome = new JTextPane();
		inserimentoAziendaNome.setBounds(10, 49, 133, 27);
		pannelloAzienda.add(inserimentoAziendaNome);
		
		inserimentoAziendaValore = new JTextPane();
		inserimentoAziendaValore.setBounds(10, 89, 133, 27);
		pannelloAzienda.add(inserimentoAziendaValore);
		
		inserimentoAziendaProprietario = new JTextPane();
		inserimentoAziendaProprietario.setBounds(10, 129, 133, 27);
		pannelloAzienda.add(inserimentoAziendaProprietario);
		
		inserimentoAziendaTipo = new JTextPane();
		inserimentoAziendaTipo.setBounds(10, 210, 133, 27);
		pannelloAzienda.add(inserimentoAziendaTipo);
		
		inserimentoAziendaIDProprietario = new JTextPane();
		inserimentoAziendaIDProprietario.setBounds(10, 255, 133, 27);
		pannelloAzienda.add(inserimentoAziendaIDProprietario);
		
		scrittaAziendaID = new JLabel("ID azienda");
		scrittaAziendaID.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaAziendaID.setBounds(153, 11, 79, 27);
		pannelloAzienda.add(scrittaAziendaID);
		
		scrittaAziendaNome = new JLabel("Nome azienda");
		scrittaAziendaNome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaAziendaNome.setBounds(153, 49, 79, 27);
		pannelloAzienda.add(scrittaAziendaNome);
		
		scrittaAziendaValore = new JLabel("Valore azienda");
		scrittaAziendaValore.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaAziendaValore.setBounds(153, 89, 79, 27);
		pannelloAzienda.add(scrittaAziendaValore);
		
		scrittaAziendaProprietario = new JLabel("Proprietario azienda ");
		scrittaAziendaProprietario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaAziendaProprietario.setBounds(153, 129, 113, 27);
		pannelloAzienda.add(scrittaAziendaProprietario);
		
		scrittaAziendaSettore = new JLabel("Settore azienda");
		scrittaAziendaSettore.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaAziendaSettore.setBounds(303, 171, 91, 27);
		pannelloAzienda.add(scrittaAziendaSettore);
		
		scrittaAziendaTipo = new JLabel("Tipo  azienda");
		scrittaAziendaTipo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaAziendaTipo.setBounds(153, 210, 79, 27);
		pannelloAzienda.add(scrittaAziendaTipo);
		
		scrittaAziendaIDProprietario = new JLabel("id proprietario");
		scrittaAziendaIDProprietario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaAziendaIDProprietario.setBounds(153, 255, 79, 27);
		pannelloAzienda.add(scrittaAziendaIDProprietario);
		
		rdbtnNewRadioButton_1 = new JRadioButton("1");
		rdbtnNewRadioButton_1.setBounds(6, 174, 58, 23);
		pannelloAzienda.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("2");
		rdbtnNewRadioButton_2.setBounds(66, 174, 79, 23);
		pannelloAzienda.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("3");
		rdbtnNewRadioButton_3.setBounds(141, 174, 58, 23);
		pannelloAzienda.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("Alt.");
		rdbtnNewRadioButton_4.setBounds(208, 174, 58, 23);
		pannelloAzienda.add(rdbtnNewRadioButton_4);
		
		pannelloProprietario = new JPanel();
		pannelloMultipla.addTab("New tab", null, pannelloProprietario, null);
		pannelloProprietario.setLayout(null);
		
		inserimentoProprietarioID = new JTextPane();
		inserimentoProprietarioID.setBounds(10, 11, 133, 27);
		pannelloProprietario.add(inserimentoProprietarioID);
		
		scrittaProprietarioID = new JLabel("ID azienda");
		scrittaProprietarioID.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaProprietarioID.setBounds(153, 11, 79, 27);
		pannelloProprietario.add(scrittaProprietarioID);
		
		inserimentoProprietarioNome = new JTextPane();
		inserimentoProprietarioNome.setBounds(10, 52, 133, 27);
		pannelloProprietario.add(inserimentoProprietarioNome);
		
		inserimentoProprietarioCodiceFiscale = new JTextPane();
		inserimentoProprietarioCodiceFiscale.setBounds(10, 94, 133, 27);
		pannelloProprietario.add(inserimentoProprietarioCodiceFiscale);
		
		inserimentoProprietarioPartitaIva = new JTextPane();
		inserimentoProprietarioPartitaIva.setBounds(10, 141, 133, 27);
		pannelloProprietario.add(inserimentoProprietarioPartitaIva);
		
		inserimentoProprietarioTelefono = new JTextPane();
		inserimentoProprietarioTelefono.setBounds(10, 185, 133, 27);
		pannelloProprietario.add(inserimentoProprietarioTelefono);
		
		scrittaProprietarioNome = new JLabel("Nome proprietario");
		scrittaProprietarioNome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaProprietarioNome.setBounds(153, 52, 118, 27);
		pannelloProprietario.add(scrittaProprietarioNome);
		
		scrittaProprietarioCodiceFiscale = new JLabel("codice fiscale proprietario");
		scrittaProprietarioCodiceFiscale.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaProprietarioCodiceFiscale.setBounds(153, 94, 142, 27);
		pannelloProprietario.add(scrittaProprietarioCodiceFiscale);
		
		scrittaProprietarioPartitaIva = new JLabel("partita iva proprietario");
		scrittaProprietarioPartitaIva.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaProprietarioPartitaIva.setBounds(153, 141, 118, 27);
		pannelloProprietario.add(scrittaProprietarioPartitaIva);
		
		scrittaProprietarioTelefono = new JLabel("telefono proprietario");
		scrittaProprietarioTelefono.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		scrittaProprietarioTelefono.setBounds(153, 185, 118, 27);
		pannelloProprietario.add(scrittaProprietarioTelefono);
		
		pannelloCommandiInPiccolo = new JPanel();
		pannelloCommandiInPiccolo.setBounds(447, 213, 144, 210);
		panelPrincipp.add(pannelloCommandiInPiccolo);
		pannelloCommandiInPiccolo.setLayout(null);
		
		testoHH = new JTextArea();
		testoHH.setEditable(false);
		testoHH.setBounds(0, 11, 144, 199);
		pannelloCommandiInPiccolo.add(testoHH);
		
		commandoFinestraTitolo = new JLabel("Commandi");
		commandoFinestraTitolo.setFont(new Font("Tahoma", Font.PLAIN, 7));
		commandoFinestraTitolo.setBounds(0, 0, 144, 14);
		pannelloCommandiInPiccolo.add(commandoFinestraTitolo);
	}
	

	
	public String getInformazioniUtenteImmesse() {
		return ";"+inserimentoProprietarioID+","+inserimentoProprietarioNome+","+inserimentoProprietarioCodiceFiscale+","+
				inserimentoProprietarioPartitaIva+","+inserimentoProprietarioTelefono+"-\\;";
	}
	
	public String getInformazioniAzienda() {
		return ";"+inserimentoAziendaID+","+inserimentoAziendaNome+","+inserimentoAziendaValore+","+getSettoreImmesso()+"aa";
	}
	
	public String getSettoreImmesso() {
		if(rdbtnNewRadioButton_1.isSelected()) {
			return "primario";
		}else
		if(rdbtnNewRadioButton_2.isSelected()) {
			return "secondario";
		}else
		if(rdbtnNewRadioButton_3.isSelected()) {
			return "terziario";
		}else
		if(rdbtnNewRadioButton_4.isSelected()) {
			return "alternativo";
		}else
	  /**/{
			return "errore";
		}
	}
	
	
	public String getCommandi() {return testoHH.getText();}
	public void setCommandi(String a) {testoHH.setText(a);}
}
