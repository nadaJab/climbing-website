package org.climbing.consumer.impl.rowmappers.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.topo.BookingTopo;
import org.climbing.model.beans.topo.Topo;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.springframework.jdbc.core.RowMapper;

public class BookingTopoUserRM implements RowMapper<BookingTopo>{

	@Override
	public BookingTopo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BookingTopo bookingTopo = new BookingTopo();
		Topo topo = new Topo();
		User user = new User();
		Account account = new Account();
		
		bookingTopo.setIdBookingTopo(rs.getInt("id_bookingtopo"));
		bookingTopo.setBorrowingDate(rs.getDate("borrowing_date"));
		bookingTopo.setReturnDate(rs.getDate("return_date"));
		bookingTopo.setIdTopo(rs.getInt("id_topo"));
		bookingTopo.setIdUser(rs.getInt("id_user"));
		bookingTopo.setReturnConfirmation(rs.getBoolean("return_confirmation"));
		
		topo.setIdTopo(rs.getInt("id_topo"));
		topo.setTopoName(rs.getString("topo_name"));
		bookingTopo.setTopoBean(topo);
		
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		account.setEmail(rs.getString("email"));
		user.setAccount(account);
		
		bookingTopo.setUserBean(user);
		return bookingTopo;
	}

}
