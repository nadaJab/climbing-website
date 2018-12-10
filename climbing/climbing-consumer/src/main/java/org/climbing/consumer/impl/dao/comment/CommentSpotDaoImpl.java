package org.climbing.consumer.impl.dao.comment;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.spot.RouteRM;
import org.climbing.consumer.impl.rowmappers.topo.CommentRM;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.climbing.consumer.contract.dao.comment.CommentSpotDao;
import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.comment.CommentSpot;
import org.climbing.model.beans.spot.Route;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("commentSpotDao") 
public class CommentSpotDaoImpl extends AbstractDaoImpl implements 	CommentSpotDao {
	
	List<Comment> listCommentDao;

	@Override
	public boolean addJoinCommentSpotDao(int idComment, int idSpot) {
		boolean result = false;
		String vSQL ="INSERT INTO comment_spot (id_comment, id_spot) VALUES (?,?)";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		if(vSQL != null) {
			vJdbcTemplate.update(vSQL, new Object[] { idComment, idSpot });	
			result = true;
		}
		return result;
	}

	@Override
	public ArrayList<Comment> getAllCommentDao(int idSpot) {
		/*
		String vSQL = "SELECT * FROM comment "
					+ " INNER JOIN comment_spot ON comment.id_comment = comment_spot.id_comment WHERE comment_spot.id_spot = ?"; */

		String vSQL = "SELECT content, date_coment, pseudo FROM comment "
					+ "INNER JOIN user_web ON comment.id_user = user_web.id_user "
					+ "INNER JOIN comment_spot ON comment.id_comment = comment_spot.id_comment WHERE comment_spot.id_spot = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listCommentDao = vJdbcTemplate.query(vSQL, new Object[] { idSpot }, new CommentRM());

		return (ArrayList<Comment>) listCommentDao;
	}
}
