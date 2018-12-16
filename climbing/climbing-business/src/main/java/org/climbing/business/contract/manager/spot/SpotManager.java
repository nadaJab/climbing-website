package org.climbing.business.contract.manager.spot;

import java.util.ArrayList;

import org.climbing.model.beans.spot.Spot;

public interface SpotManager {

	Spot addSpot(Spot pSpot);

	Spot getSpotId(int idSpot);

	ArrayList<Spot> getAllSpot();

	ArrayList<Spot> getSpot(String nameSpot);

	ArrayList<Spot> getSpot(int id);

	ArrayList<Spot> getSpotCountry(String countryName);

	Spot getSpot(String spotName, String cityName, String countryName); 

	boolean deleteSpot(int idSpot);

}
