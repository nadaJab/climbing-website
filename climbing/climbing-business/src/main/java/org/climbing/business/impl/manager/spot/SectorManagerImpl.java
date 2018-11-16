package org.climbing.business.impl.manager.spot;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.spot.SectorManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.spot.Sector;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Named("sectorManager")
public class SectorManagerImpl extends AbstractManagerImpl implements SectorManager {

	@Inject
	@Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	
	public Sector addSector(Sector pSector) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		
		try {
			getDaoFactory().getSectorDao().addSectorDao(pSector);
			
			TransactionStatus vTScommit = vTransactionStatus;
	    	vTransactionStatus = null;
	    	platformTransactionManager.commit(vTScommit);		
		} finally {
	    if (vTransactionStatus != null) {
	        platformTransactionManager.rollback(vTransactionStatus);
	    }
		}
		return pSector;	
	}

}
