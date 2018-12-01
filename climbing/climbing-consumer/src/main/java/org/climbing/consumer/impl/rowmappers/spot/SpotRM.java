package org.climbing.consumer.impl.rowmappers.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;
import org.springframework.jdbc.core.RowMapper;

public class SpotRM implements RowMapper<Spot>{

	@Override
	public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {
		Spot spot = new Spot();
		Country country = new Country();
		country.setIdCityCountry(rs.getInt("id_city_country"));

		spot.setIdSpot(rs.getInt("id_spot"));
		spot.setSpotName(rs.getString("spot_name"));
		spot.setNbRoutesTotal(rs.getInt("total_routes_nb"));
		spot.setCotationMax(rs.getString("cotation_max"));
		spot.setCotationMin(rs.getString("cotation_min"));
		spot.setOrientation(rs.getString("orientation"));
		spot.setClimbingType(rs.getString("climbing_type"));
		
		spot.setCountry(country);
		
		country.setCityName(rs.getString("city_name"));
		country.setCountryName(rs.getString("country_name"));
			
		return spot;
	}

}
