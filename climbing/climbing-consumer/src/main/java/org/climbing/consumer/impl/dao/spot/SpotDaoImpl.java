package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.CountryRM;
import org.climbing.consumer.impl.rowmappers.spot.SpotRM;
import org.climbing.consumer.impl.rowmappers.user.UserRM;

import java.sql.Types;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.consumer.contract.dao.spot.SpotDao;
import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("spotDao") 
public class SpotDaoImpl extends AbstractDaoImpl implements SpotDao  {
	
	SpotRM spotRow = new SpotRM();
	Spot spotD;
	Country countryD;
	
	ArrayList<Spot> spotDaoArray;
	private static final Logger LOGGER = LogManager.getLogger(SpotDaoImpl.class);

	@Override
	public Spot addSpotDao(Spot spot) {
		String vSQL = "INSERT INTO spot (spot_name, total_routes_nb, cotation_max, cotation_min, orientation, climbing_type, id_city_country)"
					+ " VALUES ( :spotName, :nbRoutesTotal, :cotationMax, :cotationMin, :orientation, :climbingType, :idCityCountry)";
		
		 //auto generated primary key by the database
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("spotName", spot.getSpotName(), Types.VARCHAR);
		vParams.addValue("nbRoutesTotal", spot.getNbRoutesTotal(), Types.INTEGER);
		vParams.addValue("cotationMax", spot.getCotationMax(), Types.VARCHAR);
		vParams.addValue("cotationMin", spot.getCotationMin(), Types.VARCHAR);
		vParams.addValue("orientation", spot.getOrientation(), Types.VARCHAR);
		vParams.addValue("climbingType", spot.getClimbingType(), Types.VARCHAR);
		vParams.addValue("idCityCountry", spot.getCountry().getIdCityCountry(), Types.INTEGER);
		
		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_spot" }); 
		spot.setIdSpot(keyHolder.getKey().intValue());
		
		return spot;
	}
	
	public Spot getSpotDao(String nameSpot) {
		String vSQL = "SELECT * FROM spot WHERE spot_name = ?";
		
		 JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		 spotD = (Spot) vJdbcTemplate.queryForObject(vSQL, new Object[] { nameSpot }, new SpotRM());
		 
		 LOGGER.debug("methode getSpotDao $$$$$$$$$" + spotD.toString());
		return spotD;
		
	}
	
	public ArrayList<Spot> getSpotDao(String nameSpot, String countryName) {
		
		String vSQL = "SELECT * FROM spot INNER JOIN country "
					+ " WHERE country_name = ?";
		
		 JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		 spotD = (Spot) vJdbcTemplate.queryForObject(vSQL, new Object[] { nameSpot, countryName}, new SpotRM());
		return spotDaoArray;
		
		
		/*
		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country"
					+ " WHERE spot.spot_name = :spotName AND city_name = :countryName";
				
		 NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		 MapSqlParameterSource vParams = new MapSqlParameterSource();
		 
	     vParams.addValue("spotName", nameSpot, Types.VARCHAR);
	     vParams.addValue("countryName", countryName, Types.VARCHAR);

		 spotD = (Spot) vJdbcTemplate.query(vSQL, vParams, new SpotRM());
		 
		 //spotD.setCountry(countryD);
		return spotD;
		*/
	}
	
	public Spot getSpotDao(String spotName, int idCountry) {
		String vSQL = "SELECT * FROM spot WHERE spot_name = ? AND id_city_country = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		spotD = (Spot) vJdbcTemplate.queryForObject(vSQL, new Object[] { spotName, idCountry}, new SpotRM());
		
		return spotD;	
	}
}
