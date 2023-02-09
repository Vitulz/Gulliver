package it.se.gulliver.controller;

import java.net.URL;	
import java.util.ResourceBundle;

import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.fxml.Initializable;

public class RabbitController implements Initializable, DataInitializable<Utente>{

	private ViewDispatcher dispatcher;
	
	public RabbitController() {
		dispatcher = ViewDispatcher.getInstance();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void initializeData(Utente utente) {
		
	}
}
