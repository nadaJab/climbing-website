package org.climbing.business.contract.manager.comment;

import java.util.ArrayList;

import org.climbing.model.beans.comment.Comment;

public interface CommentSpotManager {

	//CommentSpot addCommentSpot(CommentSpot commentSpot);
	boolean addJoinCommentSpot(int idComment, int idSpot);
	ArrayList<Comment> getAllComment(int idSpot);

}
