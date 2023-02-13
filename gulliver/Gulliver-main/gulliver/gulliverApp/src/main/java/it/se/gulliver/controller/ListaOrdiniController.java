package it.se.gulliver.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.business.OrdineService;
import it.se.gulliver.domain.Ordine;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaOrdiniController implements Initializable, DataInitializable<Utente> {

	@FXML
	private TableView<Ordine> listaOrdiniTable;

	@FXML
	private TableColumn<Ordine, String> indirizzoTableColumn;

	@FXML
	private TableColumn<Ordine, String> nomeTableColumn;

	@FXML
	private TableColumn<Ordine, String> cognomeTableColumn;

	@FXML
	private TableColumn<Ordine, Double> totaleTableColumn;

	@FXML
	private TableColumn<Ordine, Button> azioniTableColumn;

	private ViewDispatcher dispatcher;

	private Utente utente;

	private OrdineService ordineService;

	public ListaOrdiniController() {
		dispatcher = ViewDispatcher.getInstance();
		GulliverBusinessFactory factory = GulliverBusinessFactory.getInstance();
		ordineService = factory.getOrdineService();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		indirizzoTableColumn.setCellValueFactory(new PropertyValueFactory<>("indirizzoDiConsegna"));
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<>("nomeAnziano"));
		cognomeTableColumn.setCellValueFactory(new PropertyValueFactory<>("cognomeAnziano"));
		totaleTableColumn.setCellValueFactory(new PropertyValueFactory<>("totale"));
		azioniTableColumn.setStyle("-fx-alignment: CENTER;");
		azioniTableColumn.setCellValueFactory((CellDataFeatures<Ordine, Button> param) -> {
			final Button dettagliButton = new Button("Dettagli");
			dettagliButton.setOnAction((ActionEvent event) -> {
				dispatcher.renderView("dettagliordine", param.getValue());
			});
			return new SimpleObjectProperty<Button>(dettagliButton);
		});

	}

	@Override
	public void initializeData(Utente utente) {
		this.utente = utente;
		List<Ordine> listaOrdini = ordineService.findAllOrdini();
		ObservableList<Ordine> listaData = FXCollections.observableArrayList(listaOrdini);
		listaOrdiniTable.setItems(listaData);
	}




}
