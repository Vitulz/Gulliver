package it.se.gulliver.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.CarrelloService;
import it.se.gulliver.business.CatalogoService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.domain.Prodotto;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	
	private Utente utente;
	
	private CatalogoService catalogoService;
	
	private CarrelloService carrelloService;

	public CatalogoController() {
		this.dispatcher = ViewDispatcher.getInstance();
		GulliverBusinessFactory factory = GulliverBusinessFactory.getInstance();
		catalogoService = factory.getCatalogoService();
		carrelloService = factory.getCarrelloService();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		prezzoTableColumn.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		azioniTableColumn.setStyle("-fx-alignment: CENTER;");
		azioniTableColumn.setCellValueFactory((CellDataFeatures<Prodotto, Button> param) -> {
			final Button aggiungiCarrelloButton = new Button("Aggiungi al carrello");
			aggiungiCarrelloButton.setOnAction((ActionEvent event) -> {
				try {
					carrelloService.aggiungiProdottoCarrello(param.getValue());
				} catch (BusinessException e) {
					e.printStackTrace();
				}
			});
			return new SimpleObjectProperty<Button>(aggiungiCarrelloButton);
		});
	}
	
	@Override
	public void initializeData(Utente utente) {
		try {
			this.utente = utente;
			List<Prodotto> catalogo = catalogoService.findAllProdotti(utente);
			ObservableList<Prodotto> catalogoData = FXCollections.observableArrayList(catalogo);
			catalogoTable.setItems(catalogoData);
		} catch (BusinessException e) {
			dispatcher.renderError(e);
		}
	}
	
	@FXML
	public void carrelloOnAction() {
		dispatcher.renderView("carrello", utente);
	}
}
