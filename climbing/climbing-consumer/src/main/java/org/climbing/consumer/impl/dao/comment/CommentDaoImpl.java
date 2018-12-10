package org.climbing.consumer.impl.dao.comment;

import org.climbing.consumer.impl.AbstractDaoImpl;

import java.sql.Types;

import org.climbing.consumer.contract.dao.comment.CommentDao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.climbing.model.beans.comment.*;
import org.springframework.stereotype.Component;

@Component("commentDao") 
public class CommentDaoImpl extends AbstractDaoImpl implements CommentDao  {

	public Comment addCommentDao(Comment comment) {
		String vSQL = "INSERT INTO comment (content, date_coment, id_user)"
					+ " VALUES ( :content, :dateComment, :idUser)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
			
	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		 
	    vParams.addValue("content", comment.getContent(), Types.VARCHAR);
	    vParams.addValue("dateComment", comment.getDateComment(), Types.DATE);
	    vParams.addValue("idUser", comment.getIdUser(), Types.INTEGER);
	    
	    vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_comment" });   
	    comment.setIdComment(keyHolder.getKey().intValue());
		return comment;
	}

}
