package org.climbing.consumer.impl.dao.topo;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.topo.BookingTopoRM;
import org.climbing.consumer.impl.rowmappers.topo.BookingTopoUserRM;

import java.sql.Types;
import java.util.ArrayList;

import org.climbing.consumer.contract.dao.topo.BookingTopoDao;

import org.climbing.model.beans.topo.BookingTopo;
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
		String vSQL = "SELECT * FROM booking_topo WHERE id_topo = ? AND return_confirmation = 'false'";

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

	@Override
	public boolean updateTopoReturnDao(int idTopo) {
		boolean result=false;
		String vSQL = "UPDATE booking_topo SET return_confirmation = 'true' WHERE id_topo = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		if(vSQL != null) {
			vJdbcTemplate.update(vSQL, idTopo);
			result=true;
		}

		return result;

	}

	@Override
	public ArrayList<BookingTopo> getBookingTopoListDao(int idUser) {
		String vSQL = "SELECT * FROM booking_topo INNER JOIN topo ON booking_topo.id_topo = topo.id_topo "
				+ "INNER JOIN user_web ON booking_topo.id_user = user_web.id_user "
				+ "INNER JOIN account ON user_web.id_compte = account.id_compte "
				+ "INNER JOIN list_topo ON booking_topo.id_topo = list_topo.id_topo "
				+ "WHERE list_topo.id_user = ? AND booking_topo.return_confirmation = 'false' ";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		ArrayList<BookingTopo> listCommande = (ArrayList<BookingTopo>) vJdbcTemplate.query(vSQL, new Object[] { idUser }, new BookingTopoUserRM());
		return listCommande;
	}

	@Override
	public ArrayList<BookingTopo> getCommandeListDao(int idUser) {
		String vSQL = "SELECT * FROM booking_topo INNER JOIN topo ON booking_topo.id_topo = topo.id_topo "
				+ "WHERE booking_topo.id_user = ? AND booking_topo.return_confirmation = 'true'";		

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		bookingTopo = (ArrayList<BookingTopo>) vJdbcTemplate.query(vSQL, new Object[] { idUser }, new BookingTopoRM());

		return bookingTopo;


	}

}
