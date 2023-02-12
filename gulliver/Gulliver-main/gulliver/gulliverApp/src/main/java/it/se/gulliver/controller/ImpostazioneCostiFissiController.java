package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.business.CostiFissiService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ImpostazioneCostiFissiController implements Initializable, DataInitializable<Utente>{

	@FXML	
	private Label costiFissiLabel;
	
	@FXML
	private TextField impostaCostiFissiField;
	
	@FXML
	private Button salvaCostiFissiButton;
	
	private ViewDispatcher dispatcher;
	
	private Utente utente;
	
	private CostiFissiService costiFissiService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dispatcher = ViewDispatcher.getInstance();
		GulliverBusinessFactory factory = GulliverBusinessFactory.getInstance();
		costiFissiService = factory.getCostiFissiService();
		
	}
	
	public void initializeData(Utente utente) {
		this.utente = utente;
		StringBuilder testo = new StringBuilder();
		testo.append(costiFissiService.getCostiFissi());
		costiFissiLabel.setText(testo.toString());
		
	}

	@FXML
	public void salvaCostiFissiAction() {
		String text = impostaCostiFissiField.getText();
		costiFissiService.setCostiFissi(text);
		//costiFissiService.setCostiFissi(Double.parseDouble(text));
		dispatcher.renderView("impostazionecostifissi", utente);
	}
	
	
	
}
