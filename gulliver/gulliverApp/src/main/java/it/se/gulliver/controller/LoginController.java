package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	
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
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loginButton.disableProperty().bind(username.textProperty().isEmpty()
				.or(password.textProperty().isEmpty()));
		
	}
	
	@FXML 
	private void loginAction(ActionEvent event) {
		if(!("proprietario".equals(username.getText())) && ("proprietario".equals(password.getText()))) {
			loginErrorLabel.setText("Username e/o password errati!");
		} else {
			dispatcher.loggedIn();
		}
	}

	
}
