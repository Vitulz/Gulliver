package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Gestore;
import it.se.gulliver.domain.Operatore;
import it.se.gulliver.domain.Socio;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;





public class LayoutController implements Initializable, DataInitializable<Utente>{

	private static final MenuElement MENU_HOME = new MenuElement("Home", "home");
	
	private static final MenuElement[] MENU_OPERATORE = {new MenuElement("Crea ordine", "selezionetipospesa"), 
														new MenuElement("Lista di ordini", "listaDiOrdiniOperatore")};
	
	private static final MenuElement[] MENU_SOCIO = {new MenuElement("Crea ordine", "selezionetipospesa"), 
			new MenuElement("Lista di ordini", "listaDiOrdiniGlobali")};
	
	private static final MenuElement[] MENU_GESTORE = {new MenuElement("Crea ordine", "selezionetipospesa"), 
			new MenuElement("Lista di ordini", "listaDiOrdiniGlobali"),
			new MenuElement("CRUD utente", "crudUtente"), 
			new MenuElement("Gestione catalogo", "gestioneCatalogo")};
	
	private Utente utente;
	
	@FXML 
	private VBox menuBar;
	
	private ViewDispatcher dispatcher;
	
	public LayoutController() {
		dispatcher = ViewDispatcher.getInstance();
	}
	
	// il menu viene generato nel metodo di DataInitializable
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@Override 
	public void initializeData(Utente utente) {
		this.utente = utente;
		menuBar.getChildren().addAll(createButton(MENU_HOME));
		menuBar.getChildren().add(new Separator());
		if (utente instanceof Operatore) {
			for (MenuElement menu : MENU_OPERATORE) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
		if (utente instanceof Socio) {
			for (MenuElement menu : MENU_SOCIO) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
		if(utente instanceof Gestore) {
			for(MenuElement menu: MENU_GESTORE) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
		
	}
	
	@FXML
	public void esciAction (MouseEvent event) {
		dispatcher.logout();
	}
	
	@FXML
	public void easterAction(MouseEvent event) {
		dispatcher.renderView("rabbit", utente);
	}
	
	private Button createButton(MenuElement viewItem) {
		
		Button button = new Button(viewItem.getNome());
		button.setStyle("-fx-background-color: transparent; -fx-font-size: 14;");
		button.setTextFill(Paint.valueOf("white"));
		button.setPrefHeight(25);
		button.setPrefWidth(116);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dispatcher.renderView(viewItem.getVista(), utente);
			}
		});
		return button;
	}
	
	
	
}

	
	
	
	
	

