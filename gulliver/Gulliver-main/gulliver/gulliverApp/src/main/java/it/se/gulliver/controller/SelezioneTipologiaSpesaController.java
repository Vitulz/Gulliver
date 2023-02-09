package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Utente;
import it.se.gulliver.domain.TipologiaSpesa;
import it.se.gulliver.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class SelezioneTipologiaSpesaController implements Initializable, DataInitializable<Utente> {

	@FXML
	private Button farmaciButton;

	@FXML
	private Button alimentariButton;
	
	private ViewDispatcher dispatcher;
	private Utente utente;

	public SelezioneTipologiaSpesaController() {
		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void initializeData(Utente utente) {
		this.utente = utente;
	}

	public void farmaciOnAction() {
		dispatcher.renderView("catalogo", utente);
	}

	public void alimentariOnAction() {
		dispatcher.renderView("catalogo", utente);
	}

}
