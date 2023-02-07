package it.se.gulliver.domain;

public class Operatore extends Utente {
	
	private String indirizzo; 
	private int numeroDiTelefono;
	
	public Operatore(String indirizzo, int numero) {
		this.indirizzo = indirizzo;
		this.numeroDiTelefono = numero;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getNumeroDiTelefono() {
		return numeroDiTelefono;
	}

	public void setNumeroDiTelefono(int numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}
	
	
}
