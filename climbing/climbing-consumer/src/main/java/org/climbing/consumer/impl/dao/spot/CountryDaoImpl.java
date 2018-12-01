package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.CountryRM;
import org.climbing.consumer.impl.rowmappers.spot.SpotRM;

import java.sql.Types;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.consumer.contract.dao.spot.CountryDao;

import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("countryDao") 
public class CountryDaoImpl extends AbstractDaoImpl implements CountryDao  {
	
	private static final Logger LOGGER = LogManager.getLogger(CountryDaoImpl.class);
	Country countryDao;
	CountryRM countryRm = new CountryRM();
	ArrayList<Spot> listSpotDao;

	@Override
	public Country addCountryDao(Country country) {
		String vSQL = "INSERT INTO country (city_name, country_name) VALUES (:cityName, :countryName)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		LOGGER.info("clè primaire:" + keyHolder);		
	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
	    
		vParams.addValue("cityName", country.getCityName(), Types.VARCHAR);
		vParams.addValue("countryName", country.getCountryName(), Types.VARCHAR);
	
		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_city_country" });
		country.setIdCityCountry(keyHolder.getKey().intValue());
	 
		return country;
	}
	
	public Country getCountryDao(int id) {
		String vSQL = "SELECT city_name, country_name FROM country WHERE id_city_country = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		countryDao = (Country) vJdbcTemplate.query(vSQL, new Object[] { id }, new CountryRM());

		return countryDao;	
	}
	
	public ArrayList<Spot> getCountryDao(String countryName, String cityName) {
		//String vSQL = "SELECT * FROM country WHERE country_name ILIKE ? AND  city_name ILIKE ?";
		
		String vSQL = "SELECT * FROM country INNER JOIN spot ON spot.id_city_country = country.id_city_country WHERE country_name ILIKE ? "
					+ "AND  city_name ILIKE ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listSpotDao = (ArrayList<Spot>) vJdbcTemplate.query(vSQL, new Object[] { countryName, cityName }, new SpotRM());
		
		LOGGER.debug(listSpotDao.toString() + "coucou!!!");
		
		return listSpotDao;
	}
	
}
