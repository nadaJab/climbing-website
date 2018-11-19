package org.climbing.business.contract.manager.spot;

import org.climbing.model.beans.spot.Spot;

public interface SpotManager {

	 Spot addSpot(Spot pSpot);
	 Spot getSpot(String nameSpot);
	 Spot getSpot(String spotName, int idCountry);
	 Spot getSpot(String nameSpot, String countryName);
}
