package org.climbing.consumer.contract.dao.spot;
import java.util.ArrayList;

import org.climbing.model.beans.spot.Spot;

public interface SpotDao {

	Spot addSpotDao(Spot spot);
	
	Spot getSpotIdDao(int idSpot);
	 
	ArrayList<Spot> getAllSpot();

	ArrayList<Spot> getSpotDao(String nameSpot);

	ArrayList<Spot> getSpotDao(String nameSpot, String countryName);
	
	ArrayList<Spot> getSpotDao(int id);
	
	ArrayList<Spot> getSpotCountryDao(String countryName);
	
	Spot getSpotDao(String spotName, String cityName, String countryName);
	
	boolean deleteSpotDao(int idSpot);
	
}
