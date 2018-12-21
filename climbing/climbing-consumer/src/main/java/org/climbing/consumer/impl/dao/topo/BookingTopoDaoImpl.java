package org.climbing.consumer.impl.dao.topo;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.topo.BookingTopoRM;
import org.climbing.consumer.impl.rowmappers.topo.topoRM;

import java.sql.Types;
import java.util.ArrayList;

import org.climbing.consumer.contract.dao.topo.BookingTopoDao;

import org.climbing.model.beans.topo.BookingTopo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("bookingTopoDao") 
public class BookingTopoDaoImpl extends AbstractDaoImpl implements BookingTopoDao  {
	
	 ArrayList<BookingTopo> bookingTopo;
	 
	@Override
	public ArrayList<BookingTopo> getBookingTopoInfoDao(int idTopo) {
		String vSQL = "SELECT * FROM booking_topo WHERE id_topo = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		bookingTopo = (ArrayList<BookingTopo>) vJdbcTemplate.query(vSQL, new Object[] { idTopo }, new BookingTopoRM());
		
		return bookingTopo;
	}

	@Override
	public void addBookingTopoDao(BookingTopo bookingTopo) {
		String vSQL = "INSERT INTO booking_topo (borrowing_date, return_date, id_topo, id_user) VALUES ( :borrowingDate, :returnDate, :idTopo, :idUser)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("borrowingDate", bookingTopo.getBorrowingDate(), Types.DATE);
		vParams.addValue("returnDate", bookingTopo.getReturnDate(), Types.DATE);
		vParams.addValue("idTopo", bookingTopo.getIdTopo(), Types.INTEGER);
		vParams.addValue("idUser", bookingTopo.getIdUser(), Types.INTEGER);
		
		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_bookingtopo" }); 
		bookingTopo.setIdBookingTopo(keyHolder.getKey().intValue());

	}
	
}
