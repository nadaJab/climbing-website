package org.climbing.business.contract.manager.spot;

import java.util.ArrayList;

import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;

public interface CountryManager {
	
	Country getCountry(int id);
	ArrayList<Spot> getCountry(String countryName, String cityName);
}
