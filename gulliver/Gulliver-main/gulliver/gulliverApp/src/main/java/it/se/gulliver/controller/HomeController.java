package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Operatore;
import it.se.gulliver.domain.Socio;
import it.se.gulliver.domain.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HomeController implements Initializable, DataInitializable<Utente> {

	@FXML
	private Label benvenutoLabel;
	
	@FXML
	private Label indirizzoLabel;
	
	@FXML
	private Label telefonoLabel;
	
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
		benvenutoLabel.setText(testo.toString());
		if (utente instanceof Operatore) {
			Operatore operatore = (Operatore) utente;
			testo = new StringBuilder();
			testo.append("Telefono: ");
			testo.append(operatore.getTelefono());
			telefonoLabel.setText(testo.toString());
			testo = new StringBuilder();
			testo.append("Indirizzo: ");
			testo.append(operatore.getIndirizzo());
			indirizzoLabel.setText(testo.toString());
		}
		if (utente instanceof Socio) {
			Socio socio = (Socio) utente;
			testo = new StringBuilder();
			testo.append("Telefono: ");
			testo.append(socio.getTelefono());
			telefonoLabel.setText(testo.toString());
		}
		
	}	
	
}
