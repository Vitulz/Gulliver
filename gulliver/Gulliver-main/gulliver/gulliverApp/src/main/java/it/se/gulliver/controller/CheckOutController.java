package it.se.gulliver.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.CarrelloService;
import it.se.gulliver.business.CostiFissiService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.business.OrdineService;
import it.se.gulliver.domain.Ordine;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CheckOutController implements Initializable, DataInitializable<Utente> {

	@FXML
	private TextField nomeAnzianoField;
	
	@FXML
	private TextField cognomeAnzianoField;
	
	@FXML
	private TextField indirizzoDiConsegnaField;
	
	@FXML
	private TextField numeroDiTelefonoField;
	
	@FXML
	private TextArea noteAnzianoArea;
	
	@FXML
	private Label totaleArticoliLabel;
	
	@FXML
	private Label costiFissiLabel;
	
	@FXML
	private Label totaleOrdineLabel;
	
	@FXML 
	private Button confermaOrdineButton;
	
	@FXML 
	private Label erroreLabel;
	
	private ViewDispatcher dispatcher;
	
	private Utente utente;
	
	private CarrelloService carrelloService;
	
	private CostiFissiService costiFissiService;
	
	private OrdineService ordineService;
	
	public CheckOutController() {
		dispatcher = ViewDispatcher.getInstance();
		GulliverBusinessFactory factory = GulliverBusinessFactory.getInstance();
		carrelloService = factory.getCarrelloService();
		costiFissiService = factory.getCostiFissiService();
		ordineService = factory.getOrdineService();
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
		Double totaleOrdine = Double.parseDouble(costiFissiService.getCostiFissi());
		totaleOrdine += carrelloService.getTotaleProvvisorio();
		totaleOrdineLabel.setText(totaleOrdine.toString());
	}
	
	@FXML
	public void confermaOrdineAction() {
		Ordine ordine = new Ordine();
		ordine.setNomeAnziano(nomeAnzianoField.getText());
		ordine.setCognomeAnziano(cognomeAnzianoField.getText());
		ordine.setIndirizzoDiConsegna(indirizzoDiConsegnaField.getText());
		ordine.setTelefonoAnziano(numeroDiTelefonoField.getText());
		ordine.setNote(noteAnzianoArea.getText());
		Double totaleOrdine = Double.parseDouble(costiFissiService.getCostiFissi());
		totaleOrdine += carrelloService.getTotaleProvvisorio();
		ordine.setTotale(totaleOrdine);
		try {
			ordine.setProdotti(carrelloService.findAllProdottiCarrello(utente));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (carrelloService.confermaOrdine(ordine)) {
			ordineService.aggiungiOrdine(ordine);
			dispatcher.renderView("home", utente);
		} else {
			erroreLabel.setText("dati non corretti");
		}
		
	}
	
	@FXML
	public void goBackAction() {
		dispatcher.renderView("carrello", utente);
	}

	
	
}
