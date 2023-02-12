package it.se.gulliver.business.impl.ram;

import java.util.ArrayList;
import java.util.List;

import it.se.gulliver.business.OrdineService;
import it.se.gulliver.domain.Ordine;

public class RAMOrdineServiceImpl implements OrdineService {

	
	private List<Ordine> lista = new ArrayList<Ordine>();
	
	@Override
	public List<Ordine> findAllOrdini() {
		return lista;
	}

	@Override
	public void aggiungiOrdine(Ordine ordine) {
		lista.add(ordine);
		
	}

	
}
