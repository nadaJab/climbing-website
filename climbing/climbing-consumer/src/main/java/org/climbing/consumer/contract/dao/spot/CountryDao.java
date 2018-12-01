package org.climbing.consumer.contract.dao.spot;

import java.util.ArrayList;

import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;

public interface CountryDao {
	
	Country addCountryDao(Country country);
	Country getCountryDao(int id);
	ArrayList<Spot> getCountryDao(String countryName, String cityName);
	
}
