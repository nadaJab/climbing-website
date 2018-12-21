package org.climbing.consumer.impl.dao.topo;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.SpotRM;
import org.climbing.consumer.impl.rowmappers.topo.CommentRM;
import org.climbing.consumer.impl.rowmappers.topo.topoRM;

import java.sql.Types;
import java.util.ArrayList;

import org.climbing.consumer.contract.dao.topo.TopoDao;
import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.spot.Spot;
import org.climbing.model.beans.topo.Topo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("topoDao") 
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao  {
	
	ArrayList<Topo> listTopoDao;
	Topo topoDao;

	@Override
	public Topo addTopoDao(Topo topo) {
		String vSQL = "INSERT INTO topo (topo_name, author, nb_copy_max, edition_year, published, image_url)"
				+ " VALUES ( :topoName, :author, :nbCopyMax, :editionYear, :published, :imageURL)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("topoName", topo.getTopoName(), Types.VARCHAR);
		vParams.addValue("author", topo.getAuthor(), Types.VARCHAR);
		vParams.addValue("nbCopyMax", topo.getNbCopyMax(), Types.INTEGER);
		vParams.addValue("editionYear", topo.getEditionYear(), Types.INTEGER);
		vParams.addValue("editionYear", topo.getEditionYear(), Types.INTEGER);
		vParams.addValue("published", topo.getPublished(), Types.DATE);
		vParams.addValue("imageURL", topo.getImageURL(), Types.VARCHAR);

		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_topo" }); 
		topo.setIdTopo(keyHolder.getKey().intValue());

		return topo;
	}

	@Override
	public boolean addJoinTopoSpotDao(int idTopo, int idSpot) {
		boolean result = false;

		String vSQL ="INSERT INTO topo_spot (id_topo, id_spot) VALUES (?,?)";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		if(vSQL != null) {
			vJdbcTemplate.update(vSQL, new Object[] { idTopo, idSpot });	

			result = true;
		}

		return result;
	}

	@Override
	public boolean addJoinTopoUserDao(int idTopo, int idUser) {
		boolean result = false;

		String vSQL ="INSERT INTO list_topo (id_topo, id_user) VALUES (?,?)";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		if(vSQL != null) {
			vJdbcTemplate.update(vSQL, new Object[] { idTopo, idUser });	

			result = true;
		}

		return result;
	}

	@Override
	public ArrayList<Topo> getAllTopoDao(int idSpot) {
		
		String vSQL = "SELECT * FROM topo "
				+ "INNER JOIN list_topo ON topo.id_topo = list_topo.id_topo "
				+ "INNER JOIN topo_spot ON topo.id_topo = topo_spot.id_topo WHERE topo_spot.id_spot = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listTopoDao = (ArrayList<Topo>) vJdbcTemplate.query(vSQL, new Object[] { idSpot }, new topoRM());

		return listTopoDao;
	}

	@Override
	public Topo getTopoDao(int idTopo) {
		String vSQL = "SELECT * FROM topo WHERE id_topo = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		topoDao =  vJdbcTemplate.queryForObject(vSQL, new Object[] { idTopo }, new topoRM());
		
		return topoDao;
	}

	@Override
	public ArrayList<Topo> getTopoUserDao(int idUser) {
		String vSQL = "SELECT * FROM topo INNER JOIN list_topo ON topo.id_topo = list_topo.id_topo "
					+ "WHERE list_topo.id_user = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listTopoDao = (ArrayList<Topo>) vJdbcTemplate.query(vSQL, new Object[] { idUser }, new topoRM());
		
		return listTopoDao;
	}
}
