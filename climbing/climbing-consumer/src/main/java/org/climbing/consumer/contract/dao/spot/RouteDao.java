package org.climbing.consumer.contract.dao.spot;

import java.util.ArrayList;
import org.climbing.model.beans.spot.Route;

public interface RouteDao {
	
	Route addRouteDao(Route route);
	void addJoinSectorRouteDao(int idRoute, int idSector);
	ArrayList<Route> getAllRouteDao(int idSector);
	boolean deleteRouteDao(int idRoute);
}
