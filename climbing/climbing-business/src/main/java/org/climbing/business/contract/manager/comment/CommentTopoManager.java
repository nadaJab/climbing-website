package org.climbing.business.contract.manager.comment;

import java.util.ArrayList;

import org.climbing.model.beans.comment.Comment;

public interface CommentTopoManager {

	 boolean addJoinCommentTopo(int idComment, int idTopo);
	 ArrayList<Comment> getAllComment(int idTopo);
}
