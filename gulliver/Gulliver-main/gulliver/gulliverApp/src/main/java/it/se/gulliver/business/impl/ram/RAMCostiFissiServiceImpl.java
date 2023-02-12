package it.se.gulliver.business.impl.ram;

import it.se.gulliver.business.CostiFissiService;

public class RAMCostiFissiServiceImpl implements CostiFissiService{

	private String costiFissi = "0.0";
	
	@Override
	public String getCostiFissi() {
		return costiFissi;
	}

	@Override
	public void setCostiFissi(String costiFissiNuovi) {
		costiFissi = costiFissiNuovi;
	}

}
