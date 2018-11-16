package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;

import java.sql.Types;

import org.climbing.consumer.contract.dao.spot.RouteDao;

import org.climbing.model.beans.spot.Route;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("routeDao") 
public class RouteDaoImpl extends AbstractDaoImpl implements RouteDao  {
	
	public Route addRouteDao(Route route) {
		String vSQL = "INSERT INTO route (route_name, cotation, height, point_number, route_opener, opening_year) VALUES (:routeName, :cotation,"
					+ " :height, :pointNumber, :routeOpener, :openingYear)";
		
		 //auto generated primary key by the database
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("routeName", route.getRouteName(), Types.VARCHAR);
		vParams.addValue("cotation", route.getCotation(), Types.VARCHAR);
		vParams.addValue("height", route.getHeight(), Types.INTEGER);
		vParams.addValue("pointNumber", route.getPointNumber(), Types.INTEGER);
		vParams.addValue("routeOpener", route.getRouteOpener(), Types.VARCHAR);
		vParams.addValue("openingYear", route.getOpeningYear(), Types.INTEGER);

		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_route" }); 
		route.setIdRoute(keyHolder.getKey().intValue());
		
		return route;
	}
}
