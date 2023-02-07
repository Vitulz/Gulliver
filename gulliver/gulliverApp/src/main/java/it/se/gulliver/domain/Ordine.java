package it.se.gulliver.domain;

import java.util.Set;

public class Ordine {

	private Integer id;
	private Set<ProdottoCarrello> prodotti;
	private int costiDiVariazione;
	private String nomeAnziano;
	private String cognomeAnziano;
	private String note;
	private String indirizzoDiConsegna;
	private int telefonoAnziano;
	private double totale;

	// valido?
	public int getCostiDiVariazione() {
		return costiDiVariazione;
	}

	public void setCostiDiVariazione(int costiDiVariazione) {
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

	public int getTelefonoAnziano() {
		return telefonoAnziano;
	}

	public void setTelefonoAnziano(int telefonoAnziano) {
		this.telefonoAnziano = telefonoAnziano;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public Integer getId() {
		return id;
	}

	public Set<ProdottoCarrello> getProdotti() {
		return prodotti;
	}

	public void setProdotti(Set<ProdottoCarrello> prodotti) {
		this.prodotti = prodotti;
	}

}
