package org.climbing.business.impl.manager.topo;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.topo.TopoManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.topo.Topo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("topoManager")
public class TopoManagerImpl extends AbstractManagerImpl implements TopoManager {

	@Inject
	@Named("PlatformTransactionManager")
	private PlatformTransactionManager platformTransactionManager;
	ArrayList<Topo> listTopo;
	Topo topo;
	
	@Override
	public Topo addTopo(Topo topo) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {

			topo = getDaoFactory().getTopoDao().addTopoDao(topo);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);		
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}		
		return topo;
	}

	@Override
	public boolean addJoinTopoSpot(int idTopo, int idSpot) {
		boolean result;

		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {

			getDaoFactory().getTopoDao().addJoinTopoSpotDao(idTopo, idSpot);
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
	public boolean addJoinTopoUser(int idTopo, int idUser) {
		boolean result;

		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {

			getDaoFactory().getTopoDao().addJoinTopoUserDao(idTopo, idUser);
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
	public ArrayList<Topo> getAllTopo(int idSpot) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			listTopo = getDaoFactory().getTopoDao().getAllTopoDao(idSpot);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return listTopo;
	}

	@Override
	public Topo getTopo(int idTopo) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {

			topo = getDaoFactory().getTopoDao().getTopoDao(idTopo);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);		
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return topo;		
	}
}
