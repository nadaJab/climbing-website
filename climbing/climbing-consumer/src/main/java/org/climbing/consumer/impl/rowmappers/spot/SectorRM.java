package org.climbing.consumer.impl.rowmappers.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.spot.Sector;
import org.springframework.jdbc.core.RowMapper;

public class SectorRM implements RowMapper<Sector>{

	@Override
	public Sector mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sector sector = new Sector();
		
		sector.setIdSector(rs.getInt("id_sector"));
		sector.setSectorName(rs.getString("sector_name"));
		return sector;
	}

}
