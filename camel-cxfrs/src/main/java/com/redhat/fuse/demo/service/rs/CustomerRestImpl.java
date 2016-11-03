package com.redhat.fuse.demo.service.rs;

import com.redhat.fuse.demo.model.Account;
import com.redhat.fuse.demo.model.Company;

public class CustomerRestImpl implements CustomerRest {

	private static final String NA_REGION = "NORTH_AMERICA";
	private static final String SA_REGION = "SOUTH_AMERICA";
	private static final String WE_REGION = "WEST_AMERICA";
	private static final String EAST_REGION = "EAST_AMERICA";
	private static final String UNKNOW_REGION = "UNKNOW";

	@Override
	public Account enrich(Account account) {
		Company company = account.getCompany();
		String region = company.getGeo();

		// Enrich
		if (Region.NA.toString().equals(region)) {
			company.setGeo(NA_REGION);
		} else if (Region.SA.toString().equals(region)) {
			company.setGeo(SA_REGION);
		} else if (Region.EA.toString().equals(region)) {
			company.setGeo(EAST_REGION);
		} else if (Region.WA.toString().equals(region)) {
			company.setGeo(WE_REGION);
		} else {
			company.setGeo(UNKNOW_REGION);
		}

		return account;
	}

	@Override
	public String show(String message, String message2) {
		return "[RESPONSE] message=" + message + "-message2=" + message2;
	}
	
}
