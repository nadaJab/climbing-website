package org.climbing.consumer.impl.rowmappers.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.topo.BookingTopo;
import org.springframework.jdbc.core.RowMapper;

public class BookingTopoRM implements RowMapper<BookingTopo>{

	@Override
	public BookingTopo mapRow(ResultSet rs, int rowNum) throws SQLException {

		BookingTopo bookingTopo = new BookingTopo();
		
		bookingTopo.setIdBookingTopo(rs.getInt("id_bookingtopo"));
		bookingTopo.setBorrowingDate(rs.getDate("borrowing_date"));
		bookingTopo.setReturnDate(rs.getDate("return_date"));
		bookingTopo.setIdTopo(rs.getInt("id_topo"));
		bookingTopo.setIdUser(rs.getInt("id_user"));
		bookingTopo.setReturnConfirmation(rs.getBoolean("return_confirmation"));
		
		return bookingTopo;
	}

}
