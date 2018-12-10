package org.climbing.consumer.impl.dao.comment;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.comment.CommentTopoDao;

import org.climbing.model.beans.comment.CommentTopo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("commentTopoDao") 
public class CommentTopoDaoImpl extends AbstractDaoImpl implements CommentTopoDao  {

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
}
