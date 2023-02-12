package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CheckOutController implements Initializable, DataInitializable<Utente> {

	@FXML
	private TextField nomeAnziano;
	
	@FXML
	private TextField cognomeAnziano;
	
	@FXML
	private TextField indirizzoDiConsegna;
	
	@FXML
	private Label totaleArticoliLabel;
	
	@FXML
	private Label costiFissiLabel;
	
	@FXML
	private Label totaleOrdinesocio;
	
	@FXML 
	private Button confermaOrdineButton;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	
}
