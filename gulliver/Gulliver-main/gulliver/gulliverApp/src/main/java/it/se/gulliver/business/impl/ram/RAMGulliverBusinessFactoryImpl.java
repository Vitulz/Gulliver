package it.se.gulliver.business.impl.ram;

import it.se.gulliver.business.CatalogoService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.business.UtenteService;

public class RAMGulliverBusinessFactoryImpl extends GulliverBusinessFactory{

	private UtenteService utenteService;
	private CatalogoService catalogoService;
	
	public RAMGulliverBusinessFactoryImpl() {
		utenteService = new RAMUtenteServiceImpl();
		catalogoService = new RAMCatalogoServiceImpl();
	}
	
	@Override
	public UtenteService getUtenteService() {
		return utenteService;
	}
	
	@Override
	public CatalogoService getCatalogoService() {
		return catalogoService;
	}
	
}
