package it.se.gulliver.business.impl.ram;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.UtenteNotFoundException;
import it.se.gulliver.business.UtenteService;
import it.se.gulliver.domain.Gestore;
import it.se.gulliver.domain.Operatore;
import it.se.gulliver.domain.Socio;
import it.se.gulliver.domain.Utente;

public class RAMUtenteServiceImpl implements UtenteService{
	
	@Override
	public Utente authenticate(String username, String password) throws BusinessException {
		if("operatore".equals(username) && "operatore".equals(password)) {
			Operatore operatore = new Operatore();
			operatore.setUsername(username);
			operatore.setPassword(password);
			operatore.setNome("Antonio");
			operatore.setCognome("Sbancatore");
			operatore.setIndirizzo("Via Lattea");
			operatore.setNumeroDiTelefono(1324342);
			return operatore;
		}
		
		if("socio".equals(username) && "socio".equals(password)) {
			Socio socio = new Socio();
			socio.setUsername(username);
			socio.setPassword(password);
			socio.setNome("Antonio");
			socio.setCognome("Sbancatore");
			socio.setTelefono(1234556);
			return socio;
		}
		
		if("gestore".equals(username) && "gestore".equals(password)) {
			Utente gestore = new Gestore();
			gestore.setUsername(username);
			gestore.setPassword(password);
			gestore.setNome("Antonio");
			gestore.setCognome("Sbancatore");
			return gestore;
		}
		
		throw new UtenteNotFoundException();
	}
}
