package org.climbing.consumer.contract.dao.topo;

import org.climbing.model.beans.topo.Topo;

public interface TopoDao {

	Topo addTopoDao(Topo topo);
	boolean addJoinTopoSpotDao(int idTopo, int idSpot);
	boolean addJoinTopoUserDao(int idTopo, int idUser);
}
