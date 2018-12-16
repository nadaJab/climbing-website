package org.climbing.business.contract.manager.spot;

import java.util.ArrayList;

import org.climbing.model.beans.spot.Route;

public interface RouteManager {

	 Route addRoute(Route pRoute);
	 void addJoinSectorRoute(int idRoute, int idSector);
	 ArrayList<Route> getAllRoute(int idSector);
	 boolean deleteRoute(int idRoute);
}
