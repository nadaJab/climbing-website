package org.climbing.consumer.contract.dao.spot;

import org.climbing.model.beans.spot.Country;

public interface CountryDao {
	
	Country addCountryDao(Country country);
	Country getCountryDao(int id);
	Country getCountryDao(String cityName, String countryName);
}
