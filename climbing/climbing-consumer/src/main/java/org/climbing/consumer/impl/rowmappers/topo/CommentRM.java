package org.climbing.consumer.impl.rowmappers.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.comment.CommentSpot;
import org.climbing.model.beans.user.User;
import org.springframework.jdbc.core.RowMapper;

public class CommentRM implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		//Comment comment = new Comment();
		
		CommentSpot commentSpot = new CommentSpot();
		User user = new User();
		
		commentSpot.setContent(rs.getString("content"));
		commentSpot.setDateComment(rs.getDate("date_coment"));
	
		commentSpot.setUser(user);
		user.setPseudo(rs.getString("pseudo"));

		return commentSpot;
	}

}
