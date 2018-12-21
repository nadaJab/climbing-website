package org.climbing.business.contract.manager.topo;

import java.util.ArrayList;

import org.climbing.model.beans.topo.BookingTopo;

public interface BookingTopoManager {
	
	ArrayList<BookingTopo> getBookingTopoInfo(int idTopo);
	void addBookingTopo( BookingTopo bookingTopo);

}
