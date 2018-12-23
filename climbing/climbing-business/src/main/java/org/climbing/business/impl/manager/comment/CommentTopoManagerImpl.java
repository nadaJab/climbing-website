package org.climbing.business.impl.manager.comment;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.comment.CommentTopoManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.comment.CommentTopo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("commentTopoManager")
public class CommentTopoManagerImpl extends AbstractManagerImpl implements CommentTopoManager {
	@Inject
	@Named("PlatformTransactionManager")
	private PlatformTransactionManager platformTransactionManager;
	ArrayList<Comment> listComment;
	
	@Override
	public boolean addJoinCommentTopo(int idComment, int idTopo) {
		boolean result;
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			getDaoFactory().getCommentTopoDao().addJoinCommentTopoDao(idComment, idTopo);

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
	public ArrayList<Comment> getAllComment(int idTopo) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			listComment = getDaoFactory().getCommentTopoDao().getAllCommentDao(idTopo);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return listComment;
	}
}
