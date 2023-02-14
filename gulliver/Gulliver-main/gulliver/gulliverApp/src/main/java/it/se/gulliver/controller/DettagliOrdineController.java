package it.se.gulliver.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.se.gulliver.domain.Ordine;
import it.se.gulliver.domain.ProdottoCarrello;
import it.se.gulliver.domain.Utente;
import it.se.gulliver.view.ViewDispatcher;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class DettagliOrdineController implements Initializable, DataInitializable<Ordine>{

	@FXML
	private TableView<ProdottoCarrello> dettagliOrdineTable;
	
	@FXML
	private TableColumn<ProdottoCarrello, Image> immagineTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, String> nomeTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, Double> prezzoTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, Integer> quantitàTableColumn;
	
	@FXML
	private TableColumn<ProdottoCarrello, CheckBox> azioniTableColumn;
	
	@FXML
	private Label totaleOrdineLabel;
	
	@FXML
	private Label telefonoLabel;
	
	@FXML
	private Label indirizzoLabel;
	
	@FXML
	private Label nomeLabel;
	
	@FXML
	private Label cognomeLabel;
	
	@FXML
	private Label noteLabel;
	
	private ViewDispatcher dispatcher;
	
	private Ordine ordine;
	
	
	public DettagliOrdineController() {
		dispatcher = ViewDispatcher.getInstance();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nomeTableColumn.setCellValueFactory((CellDataFeatures<ProdottoCarrello, String> param) -> {
			return new SimpleStringProperty(param.getValue().getProdotto().getNome());
		});
		prezzoTableColumn.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		quantitàTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantità"));
		azioniTableColumn.setStyle("-fx-alignment: CENTER;");
		azioniTableColumn.setCellValueFactory((CellDataFeatures<ProdottoCarrello, CheckBox> param) -> {
			final CheckBox spuntaCheckBox= new CheckBox();
			return new SimpleObjectProperty<CheckBox>(spuntaCheckBox);
		});
		
	}
	
	public void initializeData(Ordine ordine) {
		this.ordine = ordine;
		List<ProdottoCarrello> prodotti = ordine.getProdotti(); 
		ObservableList<ProdottoCarrello> prodottiData = FXCollections.observableArrayList(prodotti);
		dettagliOrdineTable.setItems(prodottiData);
		totaleOrdineLabel.setText(ordine.getTotale().toString());
		telefonoLabel.setText(ordine.getTelefonoAnziano());
		indirizzoLabel.setText(ordine.getIndirizzoDiConsegna());
		nomeLabel.setText(ordine.getNomeAnziano());
		cognomeLabel.setText(ordine.getCognomeAnziano());
		noteLabel.setText(ordine.getNote());
	}
	
	@FXML
	public void goBackAction() {
		dispatcher.renderView("listaordini", new Utente());
	}
	

}
