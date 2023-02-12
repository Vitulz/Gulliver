package it.se.gulliver.domain;

import java.util.Set;

public class Carrello {

	private Integer id;
	private Set<ProdottoCarrello> prodotti;
	private Double totale;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}

	public Set<ProdottoCarrello> getProdotti() {
		return prodotti;
	}

	public void setProdotti(Set<ProdottoCarrello> prodotti) {
		this.prodotti = prodotti;
	}

}
