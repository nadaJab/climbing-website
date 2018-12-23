package org.climbing.business.contract.manager.comment;

import org.climbing.model.beans.comment.*;

public interface CommentManager {

	Comment addComment(Comment comment);
	boolean deleteCommentSpot(int idComment);

}
