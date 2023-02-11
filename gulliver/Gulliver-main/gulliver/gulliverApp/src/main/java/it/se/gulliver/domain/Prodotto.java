package it.se.gulliver.domain;

import javafx.scene.image.Image;

public class Prodotto {

	private Integer id;
	private String nome;
	private Double prezzo;
	private Image immagine;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Image getImmagine() {
		return immagine;
	}

	public void setImmagine(Image immagine) {
		this.immagine = immagine;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Prodotto)) return false;
		Prodotto p = (Prodotto) obj;
		return (this.nome.equals(p.nome) && this.prezzo.equals(p.prezzo));
	}

}
