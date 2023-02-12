package it.se.gulliver.business;

import it.se.gulliver.business.impl.ram.RAMGulliverBusinessFactoryImpl;

public abstract class GulliverBusinessFactory {

	private static GulliverBusinessFactory factory = new RAMGulliverBusinessFactoryImpl();
	
	public static GulliverBusinessFactory getInstance() {
		return factory;
	}
	
	public abstract UtenteService getUtenteService();
	public abstract CatalogoService getCatalogoService();
	public abstract CarrelloService getCarrelloService();
	public abstract CostiFissiService getCostiFissiService();
	public abstract OrdineService getOrdineService();
}
