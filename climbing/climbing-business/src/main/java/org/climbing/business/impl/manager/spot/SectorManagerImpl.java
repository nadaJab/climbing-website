package org.climbing.business.impl.manager.spot;

import java.util.ArrayList;

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

	ArrayList<Sector> sectorList;

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

	@Override
	public ArrayList<Sector> getAllSectors(int idSpot) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			sectorList = getDaoFactory().getSectorDao().getAllSectorsDao(idSpot);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);		
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return sectorList;
	}

	@Override
	public void addJoinSpotSector(int idSpot, int idSector) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			getDaoFactory().getSectorDao().addJoinSpotSectorDao(idSpot, idSector);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
	}

	@Override
	public boolean deleteSector(int idSector) {
		boolean result = false;
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			getDaoFactory().getSectorDao().deleteSectorDao(idSector);
		
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
