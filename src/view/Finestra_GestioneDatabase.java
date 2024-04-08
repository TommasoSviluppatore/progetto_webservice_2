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
import javax.swing.*;
import javax.xml.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.sql.*;

public class Finestra_GestioneDatabase extends JFrame{
	public Finestra_GestioneDatabase() {
		getContentPane().setLayout(null);
		
		JPanel panelPrincipp = new JPanel();
		panelPrincipp.setBounds(0, 0, 591, 423);
		getContentPane().add(panelPrincipp);
		panelPrincipp.setLayout(null);
		
		JButton aggiungiBottone = new JButton("Aggiungi");
		aggiungiBottone.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		aggiungiBottone.setBounds(459, 11, 122, 39);
		panelPrincipp.add(aggiungiBottone);
		
		JButton eliminaBottone = new JButton("Elimina");
		eliminaBottone.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		eliminaBottone.setBounds(459, 84, 122, 39);
		panelPrincipp.add(eliminaBottone);
		
		JButton aggiungiBottone_2 = new JButton("New button");
		aggiungiBottone_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		aggiungiBottone_2.setBounds(459, 163, 122, 39);
		panelPrincipp.add(aggiungiBottone_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 439, 401);
		panelPrincipp.add(panel);
	}
}
