package it.se.gulliver.domain;

import java.util.Set;
import java.util.TreeSet;

public class Catalogo {
	
	private Integer id;
	private Set<Prodotto> prodotti;
	private String puntoVendita;
	private TipologiaSpesa tipologiaSpesa;
	
	public Set<Prodotto> getProdotti() {
		return prodotti;
	}
	public void setProdotti(Set<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	public String getPuntoVendita() {
		return puntoVendita;
	}
	public void setPuntoVendita(String puntoVendita) {
		this.puntoVendita = puntoVendita;
	}
	public TipologiaSpesa getTipologiaSpesa() {
		return tipologiaSpesa;
	}
	public void setTipologiaSpesa(TipologiaSpesa tipologiaSpesa) {
		this.tipologiaSpesa = tipologiaSpesa;
	}
	public Integer getId() {
		return id;
	}
	
	
	
}
