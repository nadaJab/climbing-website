package org.climbing.consumer.contract.dao.comment;

import org.climbing.model.beans.comment.*;

public interface CommentDao {

	Comment addCommentDao(Comment comment);
	boolean deleteCommentDao(int idComment);

}
