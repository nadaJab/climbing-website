package org.climbing.business.contract.manager.spot;

import org.climbing.model.beans.spot.Country;

public interface CountryManager {
	
	Country getCountry(int id);
	Country getCountry(String cityName, String countryName);
}
