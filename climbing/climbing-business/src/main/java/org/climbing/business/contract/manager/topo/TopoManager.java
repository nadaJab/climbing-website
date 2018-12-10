package org.climbing.business.contract.manager.topo;

import org.climbing.model.beans.topo.Topo;

public interface TopoManager {
	
	Topo addTopo(Topo topo);
	boolean addJoinTopoSpot(int idTopo, int idSpot);
	boolean addJoinTopoUser(int idTopo, int idUser);


}
