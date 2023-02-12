package it.se.gulliver.business.impl.ram;

import it.se.gulliver.business.CarrelloService;
import it.se.gulliver.business.CatalogoService;
import it.se.gulliver.business.CostiFissiService;
import it.se.gulliver.business.GulliverBusinessFactory;
import it.se.gulliver.business.OrdineService;
import it.se.gulliver.business.UtenteService;

public class RAMGulliverBusinessFactoryImpl extends GulliverBusinessFactory{

	private UtenteService utenteService;
	private CatalogoService catalogoService;
	private CarrelloService carrelloService;
	private CostiFissiService costiFissiService;
	private OrdineService ordineService;
	
	public RAMGulliverBusinessFactoryImpl() {
		utenteService = new RAMUtenteServiceImpl();
		catalogoService = new RAMCatalogoServiceImpl();
		carrelloService = new RAMCarrelloServiceImpl();
		costiFissiService = new RAMCostiFissiServiceImpl();
		ordineService = new RAMOrdineServiceImpl();
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

	@Override
	public CostiFissiService getCostiFissiService() {
		return costiFissiService;
	}

	@Override
	public OrdineService getOrdineService() {
		return ordineService;
	}
	
}
