package org.climbing.consumer.contract.dao.spot;
import org.climbing.model.beans.spot.Spot;

public interface SpotDao {

	Spot addSpotDao(Spot spot);
	Spot getSpotDao(String nameSpot);
}
