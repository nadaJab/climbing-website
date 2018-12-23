package org.climbing.consumer.impl.dao.comment;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.topo.CommentRM;

import java.util.ArrayList;

import org.climbing.consumer.contract.dao.comment.CommentTopoDao;
import org.climbing.model.beans.comment.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("commentTopoDao") 
public class CommentTopoDaoImpl extends AbstractDaoImpl implements CommentTopoDao  {
	ArrayList<Comment> listCommentDao;
	
	@Override
	public boolean addJoinCommentTopoDao(int idComment, int idTopo) {
		boolean result = false;
		String vSQL ="INSERT INTO comment_topo (id_comment, id_topo) VALUES (?,?)";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		if(vSQL != null) {
			vJdbcTemplate.update(vSQL, new Object[] { idComment, idTopo });	
			result = true;
		}
		return result;
	}

	@Override
	public ArrayList<Comment> getAllCommentDao(int idTopo) {
		String vSQL = "SELECT * FROM comment "
				+ "INNER JOIN user_web ON comment.id_user = user_web.id_user "
				+ "INNER JOIN comment_topo ON comment.id_comment = comment_topo.id_comment WHERE comment_topo.id_topo = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		listCommentDao = (ArrayList<Comment>) vJdbcTemplate.query(vSQL, new Object[] { idTopo }, new CommentRM());

		return listCommentDao;
	}
}
