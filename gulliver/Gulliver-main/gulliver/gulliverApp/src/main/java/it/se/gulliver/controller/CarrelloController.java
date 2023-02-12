package it.se.gulliver.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.CarrelloService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.domain.ProdottoCarrello;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class CarrelloController implements Initializable, DataInitializable<Utente> {
	
	@FXML
	private Button checkOutButton;
	
	@FXML
	private Label totaleLabel;
	
	@FXML
	private TableView<ProdottoCarrello> carrelloTable;
	
	@FXML
	private TableColumn<ProdottoCarrello, Image> immagineTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, String> nomeTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, Double> prezzoTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, Integer> quantitàTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, Button> azioniTableColumn;
	
	private ViewDispatcher dispatcher;
	
	private CarrelloService carrelloService;
	
	private Utente utente;
	
	public CarrelloController() {
		dispatcher = ViewDispatcher.getInstance();
		GulliverBusinessFactory factory = GulliverBusinessFactory.getInstance();
		carrelloService = factory.getCarrelloService();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nomeTableColumn.setCellValueFactory((CellDataFeatures<ProdottoCarrello, String> param) -> {
			return new SimpleStringProperty(param.getValue().getProdotto().getNome());
		});
		prezzoTableColumn.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		quantitàTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantità"));
		azioniTableColumn.setStyle("-fx-alignment: CENTER;");
		azioniTableColumn.setCellValueFactory((CellDataFeatures<ProdottoCarrello, Button> param) -> {
			final Button modificaCarrelloButton = new Button("Modifica");
			modificaCarrelloButton.setOnAction((ActionEvent event) -> {
				
			});
			return new SimpleObjectProperty<Button>(modificaCarrelloButton);
		});
		
	}
	
	public void initializeData(Utente utente) {
		try {
			this.utente = utente;
			List<ProdottoCarrello> carrello = carrelloService.findAllProdottiCarrello(utente);
			ObservableList<ProdottoCarrello> carrelloData = FXCollections.observableArrayList(carrello);
			carrelloTable.setItems(carrelloData);
			StringBuilder testo = new StringBuilder();
			testo.append("TOTALE PROVVISORIO: ");
			testo.append(carrelloService.getTotale());
			totaleLabel.setText(testo.toString());
		} catch (BusinessException e) {
			dispatcher.renderError(e);
		}
		
	}
	
	@FXML
	public void goBackAction() {
		dispatcher.renderView("catalogo", utente);
	}
	
	@FXML
	public void checkOutAction() {
		dispatcher.renderView("checkout", utente);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
