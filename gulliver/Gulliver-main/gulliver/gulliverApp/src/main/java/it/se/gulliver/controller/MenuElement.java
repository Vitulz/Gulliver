package it.se.gulliver.controller;

public class MenuElement {
	
	private String nome;
	private String vista;
	
	public MenuElement(String nome, String vista) {
		super();
		this.nome = nome;
		this.vista = vista;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getVista() {
		return this.vista;
	}
	
	public void setVista(String vista) {
		this.vista = vista;
	}

}
