package org.climbing.consumer.contract.dao.topo;

import java.util.ArrayList;

import org.climbing.model.beans.topo.BookingTopo;

public interface BookingTopoDao {

	ArrayList<BookingTopo> getBookingTopoInfoDao(int idTopo);
	void addBookingTopoDao( BookingTopo bookingTopo);
	boolean updateTopoReturnDao(int idTopo);
	ArrayList<BookingTopo> getBookingTopoListDao(int idUser);
	ArrayList<BookingTopo> getCommandeListDao(int idUser);

}
