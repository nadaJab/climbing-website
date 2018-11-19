package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.CountryRM;

import java.sql.Types;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.consumer.contract.dao.spot.CountryDao;

import org.climbing.model.beans.spot.Country;
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
		countryDao = vJdbcTemplate.queryForObject(vSQL, new Object[] { id }, new CountryRM());

		return countryDao;	
	}
	
	public Country getCountryDao(String cityName, String countryName) {
		String vSQL = "SELECT * FROM country WHERE city_name = ? AND country_name = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		countryDao = vJdbcTemplate.queryForObject(vSQL, new Object[] { cityName, countryName}, new CountryRM());

		return countryDao;
	}
	
}
