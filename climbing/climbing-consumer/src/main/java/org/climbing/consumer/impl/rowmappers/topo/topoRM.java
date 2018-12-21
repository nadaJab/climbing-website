package org.climbing.consumer.impl.rowmappers.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.topo.Topo;
import org.springframework.jdbc.core.RowMapper;

public class topoRM implements RowMapper<Topo>{

	@Override
	public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {

		Topo topo = new Topo();
		
		topo.setIdTopo(rs.getInt("id_topo"));
		topo.setTopoName(rs.getString("topo_name"));
		topo.setNbCopyMax(rs.getInt("nb_copy_max"));
		topo.setAuthor(rs.getString("author"));
		topo.setEditionYear(rs.getInt("edition_year"));
		topo.setPublished(rs.getDate("published"));
		topo.setImageURL(rs.getString("image_url"));

		return topo;
	}

}
