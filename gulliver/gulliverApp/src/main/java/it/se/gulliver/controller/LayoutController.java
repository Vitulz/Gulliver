package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;





public class LayoutController implements Initializable, DataInitializable<Utente>{

	private static final MenuElement MENU_HOME = new MenuElement("Home", "home");
	
	private static final MenuElement[] MENU_OPERATORE = {new MenuElement("Crea ordine", "creaOrdine"), 
														new MenuElement("Lista di ordini", "listaDiOrdini")};
	
	@FXML 
	private VBox menuBar;
	
	private ViewDispatcher dispatcher;
	
	public LayoutController() {
		dispatcher = ViewDispatcher.getInstance();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		menuBar.getChildren().addAll(createButton(MENU_HOME));
		menuBar.getChildren().add(new Separator());
		for(MenuElement menu : MENU_OPERATORE) {
			menuBar.getChildren().add(createButton(menu));
		}
	}
	
	@FXML
	public void esciAction (MouseEvent event) {
		// TODO: dispatcher.logout();
	}
	
	private Button createButton(MenuElement viewItem) {
		
		Button button = new Button(viewItem.getNome());
		button.setStyle("-fx-background-color: transparent; -fx-font-size: 14;");
		button.setTextFill(Paint.valueOf("white"));
		button.setPrefHeight(10);
		button.setPrefWidth(180);
		button.setOnAction((ActionEvent event) -> {
			dispatcher.renderView(viewItem.getVista());
		});
		return button;
	}
	
}

	
	
	
	
	

