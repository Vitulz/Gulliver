package it.se.gulliver.business.impl.ram;

import it.se.gulliver.business.CarrelloService;
import it.se.gulliver.business.CatalogoService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.business.UtenteService;

public class RAMGulliverBusinessFactoryImpl extends GulliverBusinessFactory{

	private UtenteService utenteService;
	private CatalogoService catalogoService;
	private CarrelloService carrelloService;
	
	public RAMGulliverBusinessFactoryImpl() {
		utenteService = new RAMUtenteServiceImpl();
		catalogoService = new RAMCatalogoServiceImpl();
		carrelloService = new RAMCarrelloServiceImpl();
	}
	
	@Override
	public UtenteService getUtenteService() {
		return utenteService;
	}
	
	@Override
	public CatalogoService getCatalogoService() {
		return catalogoService;
	}
	
	@Override 
	public CarrelloService getCarrelloService() {
		return carrelloService;
	}
	
}
