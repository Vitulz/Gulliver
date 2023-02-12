package it.se.gulliver.business;

import java.util.List;

import it.se.gulliver.domain.Ordine;

public interface OrdineService {

	public List<Ordine> findAllOrdini();
	
	public void aggiungiOrdine(Ordine ordine);
		
	
}
