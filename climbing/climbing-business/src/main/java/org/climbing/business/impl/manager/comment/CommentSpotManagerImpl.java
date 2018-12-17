package org.climbing.business.impl.manager.comment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.comment.CommentSpotManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.comment.CommentSpot;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("commentSpotManager")
public class CommentSpotManagerImpl extends AbstractManagerImpl implements CommentSpotManager {
	@Inject
	@Named("PlatformTransactionManager")
	private PlatformTransactionManager platformTransactionManager;
	List<Comment> listComment;

	@Override
	public boolean addJoinCommentSpot(int idComment, int idSpot) {
		boolean result;
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
		
			getDaoFactory().getCommentSpotDao().addJoinCommentSpotDao(idComment, idSpot);
			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);
			result= true;
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
			result= false;
		}
		return result;
	}

	@Override
	public ArrayList<Comment> getAllComment(int idSpot) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			listComment = getDaoFactory().getCommentSpotDao().getAllCommentDao(idSpot);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return (ArrayList<Comment>) listComment;
	}

	@Override
	public boolean deleteCommentSpot(int idComment) {
		boolean result = false;
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
<<<<<<< HEAD
			
=======
			getDaoFactory().getCommentSpotDao().deleteCommentSpotJoinDao(idComment);
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
			getDaoFactory().getCommentSpotDao().deleteCommentSpotDao(idComment);
			result = true;
			
			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return result;
	}
}
