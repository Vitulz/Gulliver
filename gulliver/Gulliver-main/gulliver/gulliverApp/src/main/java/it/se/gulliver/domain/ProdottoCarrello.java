package it.se.gulliver.domain;

public class ProdottoCarrello {

	private Integer id;
	private int quantità;
	private double prezzo;
	private boolean spunta;

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isSpunta() {
		return spunta;
	}

	public void setSpunta(boolean spunta) {
		this.spunta = spunta;
	}

}
