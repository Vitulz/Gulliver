package it.se.gulliver.business;

import java.util.List;

import it.se.gulliver.domain.Prodotto;
import it.se.gulliver.domain.ProdottoCarrello;
import it.se.gulliver.domain.Utente;

public interface CarrelloService {
	
	public List<ProdottoCarrello> findAllProdottiCarrello(Utente utente) throws BusinessException;
	
	public void aggiungiProdottoCarrello(Prodotto prodotto) throws BusinessException;
}
