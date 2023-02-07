package it.se.gulliver.business;

import it.se.gulliver.domain.Utente;

public interface UtenteService {
	
	Utente authenticate(String username, String password) throws UtenteNotFoundException, BusinessException;
}
