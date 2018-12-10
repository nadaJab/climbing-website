package org.climbing.consumer.impl.rowmappers.spot;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.climbing.model.beans.spot.Route;
import org.springframework.jdbc.core.RowMapper;

public class RouteRM implements RowMapper<Route>{

	@Override
	public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
		Route route = new Route();
		
		route.setIdRoute(rs.getInt("id_route"));
		route.setRouteName(rs.getString("route_name"));
		route.setCotation(rs.getString("cotation"));
		route.setHeight(rs.getInt("height"));
		route.setPointNumber(rs.getInt("point_number"));
		route.setRouteOpener(rs.getString("route_opener"));
		route.setOpeningYear(rs.getInt("opening_year"));
		
		return route;
	}

}
