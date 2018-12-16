package org.climbing.consumer.contract.dao.spot;
import java.util.ArrayList;

import org.climbing.model.beans.spot.Sector;

public interface SectorDao {
	
	Sector addSectorDao(Sector sector);
	ArrayList<Sector> getAllSectorsDao(int idSpot);
	void addJoinSpotSectorDao(int idSpot, int idSector);
	boolean deleteSectorDao(int idSector);
}
