package org.climbing.business.impl.manager.spot;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.spot.RouteManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.comment.CommentSpot;
import org.climbing.model.beans.spot.Route;
import org.climbing.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Named("routeManager")
public class RouteManagerImpl extends AbstractManagerImpl implements RouteManager {
	
	@Inject
	@Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	
	public Route addRoute(Route pRoute) {
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		
		try {
			
			getDaoFactory().getRouteDao().addRouteDao(pRoute);
			
			TransactionStatus vTScommit = vTransactionStatus;
	    	vTransactionStatus = null;
	    	platformTransactionManager.commit(vTScommit);		
		} finally {
	    if (vTransactionStatus != null) {
	        platformTransactionManager.rollback(vTransactionStatus);
	    }
		}
		return pRoute;
	}
}
