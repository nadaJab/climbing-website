package org.climbing.consumer.contract.dao.spot;
import java.util.ArrayList;

import org.climbing.model.beans.spot.Spot;

public interface SpotDao {

	Spot addSpotDao(Spot spot);
	Spot getSpotDao(String nameSpot);
	//Spot getSpotDao(String nameSpot, String countryName);
	
	ArrayList<Spot> getSpotDao(String nameSpot, String countryName);
	
	Spot getSpotDao(String spotName, int idCountry);
}
