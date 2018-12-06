package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.RouteRM;

import java.sql.Types;
import java.util.ArrayList;

import org.climbing.consumer.contract.dao.spot.RouteDao;

import org.climbing.model.beans.spot.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("routeDao") 
public class RouteDaoImpl extends AbstractDaoImpl implements RouteDao  {
	ArrayList<Route> listRouteDao;
	
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

	public void addJoinSectorRouteDao(int idRoute, int idSector) {
		String vSQL ="INSERT INTO sector_route (id_route, id_sector ) VALUES (?,?)";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, new Object[] { idRoute, idSector });
	}

	@Override
	public ArrayList<Route> getAllRouteDao(int idSector) {
	String vSQL = "SELECT route.* FROM route INNER JOIN sector_route ON route.id_route = sector_route.id_route "
				+ " INNER JOIN sector ON sector_route.id_sector = sector.id_sector WHERE sector_route.id_sector = ?";
	
	 JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	 listRouteDao = (ArrayList<Route>) vJdbcTemplate.query(vSQL, new Object[] { idSector }, new RouteRM());
	 
	return listRouteDao;
	}
}
