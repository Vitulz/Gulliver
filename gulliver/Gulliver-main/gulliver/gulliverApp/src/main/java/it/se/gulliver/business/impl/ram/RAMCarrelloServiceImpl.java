package it.se.gulliver.business.impl.ram;

import java.util.ArrayList;
import java.util.List;

import it.se.gulliver.business.BusinessException;
import it.se.gulliver.business.CarrelloService;
import it.se.gulliver.business.CostiFissiService;
import it.se.gulliver.domain.Ordine;
import it.se.gulliver.domain.Prodotto;
import it.se.gulliver.domain.ProdottoCarrello;
import it.se.gulliver.domain.Utente;

public class RAMCarrelloServiceImpl implements CarrelloService{

	private List<ProdottoCarrello> result;
	private Double totaleProvvisorio = 0.0; 
	
	public RAMCarrelloServiceImpl() {
		result = new ArrayList<ProdottoCarrello>();
	}
	
	@Override
	public List<ProdottoCarrello> findAllProdottiCarrello(Utente utente) throws BusinessException {
		return result;
	}

	@Override
	public void aggiungiProdottoCarrello(Prodotto prodotto) throws BusinessException {
		
		for(ProdottoCarrello p : result) {
			if(p.getProdotto().equals(prodotto)) {
				p.setQuantità(p.getQuantità() + 1);
				p.setPrezzo(p.getPrezzo() + prodotto.getPrezzo());
				totaleProvvisorio += prodotto.getPrezzo();
				return;
			}
		}
		ProdottoCarrello prodottoCarrello = new ProdottoCarrello();
		prodottoCarrello.setProdotto(prodotto);
		prodottoCarrello.setQuantità(1);
		prodottoCarrello.setPrezzo(prodotto.getPrezzo());
		totaleProvvisorio += prodotto.getPrezzo();
		result.add(prodottoCarrello);

	}
	
	public Double getTotaleProvvisorio() {
		return totaleProvvisorio;
	}

	@Override
	public boolean confermaOrdine(Ordine ordine) {
		
		if (!ordine.getNomeAnziano().isBlank() && !ordine.getCognomeAnziano().isBlank() && !ordine.getIndirizzoDiConsegna().isBlank() && !ordine.getTelefonoAnziano().isBlank()) {
			ordine.setValido(true);
			return ordine.isValido();
		}
		return ordine.isValido();
		
	}
}
