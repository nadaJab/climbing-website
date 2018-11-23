package org.climbing.business.contract.manager.spot;

import java.util.ArrayList;

import org.climbing.model.beans.spot.Spot;

public interface SpotManager {

	 Spot addSpot(Spot pSpot);
	 
	 ArrayList<Spot> getAllSpot();
	 
	 ArrayList<Spot> getSpot(String nameSpot);
	 
	 ArrayList<Spot> getSpot(int id);
	 
	 ArrayList<Spot> getSpotCountry(String countryName);
	 
	 //ArrayList<Spot> getSpot(String nameSpot,String cityName, String countryName);
	 
	 Spot getSpot(String spotName, int idCountry);
	 
	 //Spot getSpot(String nameSpot);
	 
}
