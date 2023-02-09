package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Prodotto;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;

public class CatalogoController implements Initializable, DataInitializable<Utente> {

	@FXML
	private TableView<Prodotto> catalogoTable;

	@FXML
	private TableColumn<Prodotto, Image> immagineTableColumn;
	
	@FXML
	private TableColumn<Prodotto, String> nomeTableColumn;
	
	@FXML
	private TableColumn<Prodotto, Double> prezzoTableColumn;
	
	@FXML
	private TableColumn<Prodotto, Button> azioniTableColumn;

	private ViewDispatcher dispatcher;

	public CatalogoController() {
		this.dispatcher = ViewDispatcher.getInstance();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
