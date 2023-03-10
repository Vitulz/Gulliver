package it.se.gulliver.view;

import java.io.IOException;

import it.se.gulliver.controller.DataInitializable;
import it.se.gulliver.domain.Utente;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;;

public class ViewDispatcher {

	private static ViewDispatcher instance = new ViewDispatcher();
	private Stage stage;
	private BorderPane layout;
	private static final String FXML_SUFFIX = ".fxml";
	private static final String RESOURCE_BASE = "/viste/";
	
	private ViewDispatcher() {
		
	}
	
	public static ViewDispatcher getInstance() {
		return instance; 
	}
	
	public void loginView(Stage stage) throws ViewException {
		this.stage = stage;
		Parent loginView = loadView("login").getView();
		Scene scene = new Scene(loginView);
		stage.getIcons().add(new Image("/viste/gulliver-logo.png"));
		stage.setScene(scene);
		stage.show();
	}
	
	public void loggedIn(Utente utente) {
		try {
			View<Utente> layoutView = loadView("layout");
			DataInitializable<Utente> layoutController = layoutView.getController();
			layoutController.initializeData(utente);
			layout = (BorderPane) layoutView.getView();
			renderView("home", utente);
			Scene scene = new Scene(layout);
			stage.setScene(scene);
		} catch (ViewException e) {
			renderError(e);
		}
	}
	
	public void logout() {
		try {
			Parent loginView = loadView("login").getView();
			Scene scene = new Scene(loginView);
			stage.setScene(scene);
		} catch (ViewException e) {
			renderError(e);
		}
	}
	
	
	public <T> void renderView(String viewName, T data) {
		try {
			View<T> view = loadView(viewName);
			DataInitializable<T> controller = view.getController();
			controller.initializeData(data);
			layout.setCenter(view.getView());
		} catch (ViewException e) {
			renderError(e);
		}
	}
	
	public void renderError(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}
	
	private <T> View<T> loadView(String view) throws ViewException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(RESOURCE_BASE +
					view + FXML_SUFFIX));
			Parent parent = (Parent) loader.load();
			return new View<>(parent, loader.getController()); 
		} catch (IOException e) {
			e.printStackTrace();
			throw new ViewException(e);
		}
	}
	
	
	
	
	
	
}
