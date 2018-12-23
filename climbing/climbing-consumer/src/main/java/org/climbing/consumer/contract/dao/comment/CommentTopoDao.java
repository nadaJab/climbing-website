package org.climbing.consumer.contract.dao.comment;

import java.util.ArrayList;

import org.climbing.model.beans.comment.Comment;

public interface CommentTopoDao {
	
	boolean addJoinCommentTopoDao(int idComment, int idTopo);
	ArrayList<Comment> getAllCommentDao(int idTopo);

}
