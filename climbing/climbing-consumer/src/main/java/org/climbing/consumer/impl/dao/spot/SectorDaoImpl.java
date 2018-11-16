package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;

import java.sql.Types;

import org.climbing.consumer.contract.dao.spot.SectorDao;

import org.climbing.model.beans.spot.Sector;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("sectorDao") 
public class SectorDaoImpl extends AbstractDaoImpl implements SectorDao  {
	
	public Sector addSectorDao(Sector sector) {
		
		String vSQL = "INSERT INTO sector sector_name VALUES :sectorName";
		
		 //auto generated primary key by the database
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("sectorName", sector.getSectorName(), Types.VARCHAR);
		
		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_sector" }); 
		sector.setIdSector(keyHolder.getKey().intValue());
		
		return sector;
	}
}
