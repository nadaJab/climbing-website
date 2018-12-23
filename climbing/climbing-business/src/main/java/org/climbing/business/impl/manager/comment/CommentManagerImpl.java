package org.climbing.business.impl.manager.comment;

import org.climbing.business.impl.AbstractManagerImpl;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.comment.CommentManager;

import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.comment.CommentSpot;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("commentManager")
public class CommentManagerImpl extends AbstractManagerImpl implements CommentManager {
	
	@Inject
	@Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	Comment commentImp;
	
	@Override
	public Comment addComment(Comment comment) {
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		
		try {	
			
			comment = getDaoFactory().getCommentDao().addCommentDao(comment);
			
			TransactionStatus vTScommit = vTransactionStatus;
	    	vTransactionStatus = null;
	    	platformTransactionManager.commit(vTScommit);		
		} finally {
	    if (vTransactionStatus != null) {
	        platformTransactionManager.rollback(vTransactionStatus);
	    }
		}
		return comment;
	}

	@Override
	public boolean deleteCommentSpot(int idComment) {
		boolean result = false;
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			
			getDaoFactory().getCommentDao().deleteCommentDao(idComment);
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
