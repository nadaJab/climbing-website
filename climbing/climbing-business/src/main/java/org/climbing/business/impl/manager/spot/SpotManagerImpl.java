package org.climbing.business.impl.manager.spot;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.spot.SpotManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.spot.Spot;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Named("spotManager")
public class SpotManagerImpl extends AbstractManagerImpl implements SpotManager {

	@Inject
	@Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	private Spot spotImp;
	
	public Spot addSpot(Spot pSpot) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		
		try {
			
			getDaoFactory().getCountryDao().addCountryDao(pSpot.getCountry());
			getDaoFactory().getSpotDao().addSpotDao(pSpot);
			
			TransactionStatus vTScommit = vTransactionStatus;
	    	vTransactionStatus = null;
	    	platformTransactionManager.commit(vTScommit);		
		} finally {
	    if (vTransactionStatus != null) {
	        platformTransactionManager.rollback(vTransactionStatus);
	    }
		}
		return pSpot;	
	}
	
	public Spot getSpot(String nameSpot) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		try {	
			
			spotImp = getDaoFactory().getSpotDao().getSpotDao(nameSpot);
					
		TransactionStatus vTScommit = vTransactionStatus;
		vTransactionStatus = null;
		platformTransactionManager.commit(vTScommit);		
		} finally {
		if (vTransactionStatus != null) {
		platformTransactionManager.rollback(vTransactionStatus);
		   }
		}		
		return spotImp;
		
	}
	
	public Spot getSpot(String nameSpot, String countryName) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		try {	
			
			//spotImp = getDaoFactory().getSpotDao().getSpotDao(nameSpot, countryName);
					
		TransactionStatus vTScommit = vTransactionStatus;
		vTransactionStatus = null;
		platformTransactionManager.commit(vTScommit);		
		} finally {
		if (vTransactionStatus != null) {
		platformTransactionManager.rollback(vTransactionStatus);
		   }
		}		
		return spotImp;
		
	}
	
	public Spot getSpot(String spotName, int idCountry) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		try {	
			
			spotImp = getDaoFactory().getSpotDao().getSpotDao(spotName, idCountry);;
					
		TransactionStatus vTScommit = vTransactionStatus;
		vTransactionStatus = null;
		platformTransactionManager.commit(vTScommit);		
		} finally {
		if (vTransactionStatus != null) {
		platformTransactionManager.rollback(vTransactionStatus);
		   }
		}		
		return spotImp;
	}

}
