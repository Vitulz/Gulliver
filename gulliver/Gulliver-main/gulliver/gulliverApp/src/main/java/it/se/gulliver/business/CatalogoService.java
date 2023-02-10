package it.se.gulliver.business;

import java.util.List;

import it.se.gulliver.domain.Prodotto;
import it.se.gulliver.domain.Utente;

public interface CatalogoService {
	
	public List<Prodotto> findAllProdotti(Utente utente) throws BusinessException;

}
