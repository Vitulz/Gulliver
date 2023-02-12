package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.business.CarrelloService;
import it.se.gulliver.business.CostiFissiService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CheckOutController implements Initializable, DataInitializable<Utente> {

	@FXML
	private TextField nomeAnziano;
	
	@FXML
	private TextField cognomeAnziano;
	
	@FXML
	private TextField indirizzoDiConsegna;
	
	@FXML
	private Label totaleArticoliLabel;
	
	@FXML
	private Label costiFissiLabel;
	
	@FXML
	private Label totaleOrdineLabel;
	
	@FXML 
	private Button confermaOrdineButton;
	
	private ViewDispatcher dispatcher;
	
	private Utente utente;
	
	private CarrelloService carrelloService;
	
	private CostiFissiService costiFissiService;
	
	public CheckOutController() {
		dispatcher = ViewDispatcher.getInstance();
		GulliverBusinessFactory factory = GulliverBusinessFactory.getInstance();
		carrelloService = factory.getCarrelloService();
		costiFissiService = factory.getCostiFissiService();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	public void initializeData(Utente utente) {
		this.utente = utente;
		StringBuilder testo = new StringBuilder();
		testo.append(carrelloService.getTotaleProvvisorio());
		totaleArticoliLabel.setText(testo.toString());
		testo = new StringBuilder();
		testo.append(costiFissiService.getCostiFissi());
		costiFissiLabel.setText(testo.toString());
		testo = new StringBuilder();
		Double totaleOrdine = Double.parseDouble(costiFissiService.getCostiFissi());
		totaleOrdine += carrelloService.getTotaleProvvisorio();
		totaleOrdineLabel.setText(totaleOrdine.toString());
		
		
		}
	
	@FXML
	public void goBackAction() {
		dispatcher.renderView("carrello", utente);
	}

	
	
}
