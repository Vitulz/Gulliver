package it.se.gulliver.domain;

import java.util.List;

public class Ordine {

	private Integer id;
	private List<ProdottoCarrello> prodotti;
	private Integer costiDiVariazione;
	private String nomeAnziano;
	private String cognomeAnziano;
	private String note;
	private String indirizzoDiConsegna;
	private String telefonoAnziano;
	private Double totale;
	private boolean valido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCostiDiVariazione() {
		return costiDiVariazione;
	}

	public void setCostiDiVariazione(Integer costiDiVariazione) {
		this.costiDiVariazione = costiDiVariazione;
	}

	public String getNomeAnziano() {
		return nomeAnziano;
	}

	public void setNomeAnziano(String nomeAnziano) {
		this.nomeAnziano = nomeAnziano;
	}

	public String getCognomeAnziano() {
		return cognomeAnziano;
	}

	public void setCognomeAnziano(String cognomeAnziano) {
		this.cognomeAnziano = cognomeAnziano;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIndirizzoDiConsegna() {
		return indirizzoDiConsegna;
	}

	public void setIndirizzoDiConsegna(String indirizzoDiConsegna) {
		this.indirizzoDiConsegna = indirizzoDiConsegna;
	}

	public String getTelefonoAnziano() {
		return telefonoAnziano;
	}

	public void setTelefonoAnziano(String telefonoAnziano) {
		this.telefonoAnziano = telefonoAnziano;
	}

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}

	public List<ProdottoCarrello> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<ProdottoCarrello> prodotti) {
		this.prodotti = prodotti;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

}
