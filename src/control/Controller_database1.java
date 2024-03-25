package control;

import java.sql.*;
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


public class Controller_database1 {
	public Connection connessioneConJAVA_SQL() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/nomedeldatabase";
        String username = "username";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
	}

			// Thread per leggere l'input da tastiera e inviarlo al processo
            /*Thread inputReader = new Thread(() -> {
                try {
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                    String line;
                    while ((line = consoleReader.readLine()) != null) {
                        writer.write(line + "\n");
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            inputReader.start();*/
	
	/*questo commando avvia un terminale invisibile con avviato mysql
	 * nella cartella rotto di sql,e  da li viene interagisce con il terminale
	 * restituendo le stringhe in uscita*/
	public String connessioneConCMD_CLASSICO(String commandoPersonale) {
	    String dir = "C:\\xampp\\";
	    try {
	        // Avvia un processo cmd
	        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "dir");
	        Process process = processBuilder.start();

	        // Ottiene l'input e l'output streams del processo
	        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

	        // Thread per leggere l'output del processo
	        Thread outputReader = new Thread(() -> {
	            try {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    System.out.println(line);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        });
	        outputReader.start();

	        // Invia un comando al prompt dei comandi
	        writer.write(commandoPersonale + "\n");
	        writer.flush();

	        // Attendere che il processo termini
	        int exitCode = process.waitFor();
	        System.out.println("Il processo ha restituito il codice di uscita: " + exitCode);

	        // Attendere che i thread terminino
	        outputReader.join();

	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}