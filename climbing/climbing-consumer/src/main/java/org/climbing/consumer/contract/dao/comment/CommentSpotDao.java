package org.climbing.consumer.contract.dao.comment;

import java.util.ArrayList;

import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.comment.CommentSpot;

public interface CommentSpotDao {
	
	boolean addJoinCommentSpotDao(int idComment, int idSpot);
	ArrayList<Comment> getAllCommentDao(int idSpot);
	
}
