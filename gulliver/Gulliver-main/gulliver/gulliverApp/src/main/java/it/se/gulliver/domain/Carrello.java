package it.se.gulliver.domain;

import java.util.Set;

public class Carrello {

	private Integer id;
	private Set<ProdottoCarrello> prodotti;
	private int totale;
	public int getTotale() {
		return totale;
	}
	public void setTotale(int totale) {
		this.totale = totale;
	}
	public Integer getId() {
		return id;
	}
	
	
}