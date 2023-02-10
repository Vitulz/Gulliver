package it.se.gulliver.business.impl.ram;

import java.util.ArrayList;
import java.util.List;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.CatalogoService;
import it.se.gulliver.domain.Prodotto;
import it.se.gulliver.domain.Utente;

public class RAMCatalogoServiceImpl implements CatalogoService {

	@Override
	public List<Prodotto> findAllProdotti(Utente utente) throws BusinessException {
		List<Prodotto> result = new ArrayList<Prodotto>();
		int id = 3;
		
		Prodotto latte = new Prodotto();
		latte.setId(id++);
		latte.setNome("Latte 1L");
		latte.setPrezzo(1.00);
		result.add(latte);
		
		Prodotto pane = new Prodotto();
		latte.setId(id++);
		latte.setNome("Pane 1KG");
		latte.setPrezzo(2.00);
		result.add(pane);
		
		Prodotto farina = new Prodotto();
		latte.setId(id++);
		latte.setNome("Farina 1KG");
		latte.setPrezzo(0.80);
		result.add(farina);
		
		Prodotto uova = new Prodotto();
		latte.setId(id++);
		latte.setNome("Uova 6");
		latte.setPrezzo(1.30);
		result.add(uova);
		
		
		
		
		return result;
		
	}

}
