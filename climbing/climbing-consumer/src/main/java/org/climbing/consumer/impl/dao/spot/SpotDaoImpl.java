package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.SpotRM;

import java.sql.Types;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.consumer.contract.dao.spot.SpotDao;
import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("spotDao") 
public class SpotDaoImpl extends AbstractDaoImpl implements SpotDao  {

	SpotRM spotRow = new SpotRM();
	Spot spotDao;
	ArrayList<Spot> listSpotDao;
	Country countryDao;

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

	public ArrayList<Spot> getAllSpot(){

		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country ";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		listSpotDao = (ArrayList<Spot>) vJdbcTemplate.query(vSQL, spotRow);

		return listSpotDao;
	}

	public ArrayList<Spot> getSpotDao(String nameSpot) {
		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country WHERE spot.spot_name ILIKE ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listSpotDao = (ArrayList<Spot>) vJdbcTemplate.query(vSQL, new Object[] { nameSpot }, new SpotRM());

		return listSpotDao;

	}

	//****
	public ArrayList<Spot> getSpotDao(String nameSpot, String countryName) {
		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country"
				+ " WHERE country_name = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		spotDao = (Spot) vJdbcTemplate.queryForObject(vSQL, new Object[] { nameSpot, countryName}, new SpotRM());
		return spotDaoArray;	
	}


	public Spot getSpotIdDao(int idSpot) {
		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country"
				+ " WHERE id_spot = ? ";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		spotDao = (Spot) vJdbcTemplate.queryForObject(vSQL, new Object[] { idSpot}, new SpotRM());

		LOGGER.debug(spotDao.toString() + "!!!");
		return spotDao;	
	} 

	public ArrayList<Spot> getSpotDao(int id){
		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country WHERE spot.id_city_country = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listSpotDao = ( ArrayList<Spot>) vJdbcTemplate.query(vSQL, new Object[] { id }, new SpotRM());

		return listSpotDao;
	}

	public ArrayList<Spot> getSpotCountryDao(String countryName){
		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country WHERE "
				+ "country.country_name ILIKE ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listSpotDao = ( ArrayList<Spot>) vJdbcTemplate.query(vSQL, new Object[] { countryName }, new SpotRM());

		return listSpotDao;	
	}

	public Spot getSpotDao(String spotName, String cityName, String countryName) {
		String vSQL = "SELECT * FROM spot INNER JOIN country ON spot.id_city_country = country.id_city_country "
				+ " WHERE spot.spot_name ILIKE ? AND country.city_name ILIKE ? AND country.country_name ILIKE ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		spotDao = (Spot) vJdbcTemplate.queryForObject(vSQL, new Object[] { spotName, cityName, countryName}, new SpotRM());

		return spotDao;	
	}

	@Override
	public boolean deleteSpotDao(int idSpot) {
		boolean result = false;

		String vSQL = "DELETE FROM spot WHERE spot.id_spot = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

			vJdbcTemplate.update(vSQL, idSpot);
			result = true;
			
		return result;
	}
}
