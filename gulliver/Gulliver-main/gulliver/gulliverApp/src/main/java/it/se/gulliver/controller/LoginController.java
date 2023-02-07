package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.UtenteNotFoundException;
import it.se.gulliver.business.UtenteService;
import it.se.gulliver.business.impl.ram.RAMUtenteServiceImpl;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import it.se.gulliver.view.ViewException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Initializable, DataInitializable<Object> {
	
	private UtenteService utenteService;
	
	private ViewDispatcher dispatcher;
	
	@FXML
	private Label loginErrorLabel;
	
	@FXML
	private TextField username;
	
	@FXML 
	private TextField password;
	
	@FXML 
	private Button loginButton;
	
	public LoginController() {
		dispatcher = ViewDispatcher.getInstance(); 
		utenteService = new RAMUtenteServiceImpl();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loginButton.disableProperty().bind(username.textProperty().isEmpty()
				.or(password.textProperty().isEmpty()));
		
	}
	
	@FXML 
	private void loginAction(ActionEvent event) throws BusinessException, ViewException {
		try {
			Utente utente = utenteService.authenticate(username.getText(), password.getText());
			dispatcher.loggedIn(utente);
		} catch(UtenteNotFoundException e) {
			loginErrorLabel.setText("Username e/o password errati");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
