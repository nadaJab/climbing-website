package org.climbing.consumer.impl.rowmappers.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.spot.Country;
import org.springframework.jdbc.core.RowMapper;

public class CountryRM implements RowMapper<Country>{

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		
		country.setIdCityCountry(rs.getInt("id_city_country"));
		country.setCityName(rs.getString("city_name"));
		country.setCountryName(rs.getString("country_name"));
		
		return country;
	}

}
