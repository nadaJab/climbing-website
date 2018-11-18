package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.SpotRM;
import org.climbing.consumer.impl.rowmappers.user.UserRM;

import java.sql.Types;

import org.climbing.consumer.contract.dao.spot.SpotDao;

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
		
		return spotD;
		/*	
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("spotName", spot.getSpotName(), Types.VARCHAR);
		vParams.addValue("spotName", spot.getSpotName(), Types.VARCHAR);
		vParams.addValue("nbRoutesTotal", spot.getNbRoutesTotal(), Types.INTEGER);
		vParams.addValue("cotationMax", spot.getCotationMax(), Types.VARCHAR);
		vParams.addValue("cotationMin", spot.getCotationMin(), Types.VARCHAR);
		vParams.addValue("orientation", spot.getOrientation(), Types.VARCHAR);
		vParams.addValue("climbingType", spot.getClimbingType(), Types.VARCHAR);
		vParams.addValue("idCityCountry", spot.getCountry().getIdCityCountry(), Types.INTEGER);
		
		spot = vJdbcTemplate.queryForObject(vSQL, vParams, spotRow); */

	}
}
