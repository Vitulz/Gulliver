package it.se.gulliver;

import it.se.gulliver.view.ViewDispatcher;
import it.se.gulliver.view.ViewException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class gulliverApplication extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ViewDispatcher viewDispatcher= ViewDispatcher.getInstance();
			viewDispatcher.loginView(primaryStage);
		} catch (ViewException e) {
			e.printStackTrace();
		}
		
	}

}
