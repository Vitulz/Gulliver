package it.se.gulliver.controller;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Operatore;
import it.se.gulliver.domain.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomeController implements Initializable, DataInitializable<Utente> {

	@FXML
	private Label benvenutoLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@Override
	public void initializeData(Utente utente) {
		
		StringBuilder testo = new StringBuilder();
		testo.append("Benvenuto ");
		testo.append(utente.getNome());
		testo.append(" ");
		testo.append(utente.getCognome());
		if (utente instanceof Operatore) {
			Operatore operatore = (Operatore) utente;
			testo.append(" in ");
			testo.append(operatore.getIndirizzo());
		}
		benvenutoLabel.setText(testo.toString());
	}	
	
}
