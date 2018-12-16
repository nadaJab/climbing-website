package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.SectorRM;

import java.sql.Types;
import java.util.ArrayList;

import org.climbing.consumer.contract.dao.spot.SectorDao;

import org.climbing.model.beans.spot.Sector;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("sectorDao") 
public class SectorDaoImpl extends AbstractDaoImpl implements SectorDao  {

	ArrayList<Sector> listSectorDao;

	public Sector addSectorDao(Sector sector) {
		String vSQL = "INSERT INTO sector (sector_name) VALUES (:sectorName)";

		//auto generated primary key by the database
		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("sectorName", sector.getSectorName(), Types.VARCHAR);

		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_sector" }); 
		sector.setIdSector(keyHolder.getKey().intValue());

		return sector;
	}

	@Override
	public ArrayList<Sector> getAllSectorsDao(int idSpot) {
		String vSQL = "SELECT sector.id_sector, sector.sector_name FROM sector INNER JOIN spot_sector ON sector.id_sector = spot_sector.id_sector "
				+ " INNER JOIN spot ON spot_sector.id_spot = spot.id_spot WHERE spot_sector.id_spot = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listSectorDao = (ArrayList<Sector>) vJdbcTemplate.query(vSQL, new Object[] { idSpot }, new SectorRM());

		return listSectorDao;
	}

	@Override
	public void addJoinSpotSectorDao(int idSpot, int idSector) {
		String vSQL ="INSERT INTO spot_sector (id_spot,id_sector ) VALUES (?,?)";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, new Object[] { idSpot, idSector });
	}

	@Override
	public boolean deleteSectorDao(int idSector) {
		boolean result = false;

		String vSQL = "DELETE FROM sector WHERE sector.id_sector = ?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, idSector);
		result = true;

		return result;
	}
}
