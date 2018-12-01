package org.climbing.business.contract.manager.spot;

import java.util.ArrayList;

import org.climbing.model.beans.spot.Sector;

public interface SectorManager {

	 Sector addSector(Sector pSector);
	 ArrayList<Sector> getAllSectors(int idSpot);
	 void addJoinSpotSector(int idSpot, int idSector);
}
