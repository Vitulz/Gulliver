package it.se.gulliver.controller;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomeController implements Initializable {

	@FXML
	private Label benvenutoLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		benvenutoLabel.setText("Benvenuto operatore!");
		
	}

	
	
}
