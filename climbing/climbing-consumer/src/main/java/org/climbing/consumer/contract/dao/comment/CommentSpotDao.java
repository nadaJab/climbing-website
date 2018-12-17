package org.climbing.consumer.contract.dao.comment;

import java.util.ArrayList;

import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.comment.CommentSpot;

public interface CommentSpotDao {
	
	boolean addJoinCommentSpotDao(int idComment, int idSpot);
	ArrayList<Comment> getAllCommentDao(int idSpot);
	boolean deleteCommentSpotDao(int idComment);
<<<<<<< HEAD
	
=======
	boolean deleteCommentSpotJoinDao(int idComment);

>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
}
