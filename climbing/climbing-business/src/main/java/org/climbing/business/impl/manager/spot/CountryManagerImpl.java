package org.climbing.business.impl.manager.spot;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.spot.CountryManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.spot.Country;
import org.climbing.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Named("countryManager")
public class CountryManagerImpl extends AbstractManagerImpl implements CountryManager {

	@Inject
	@Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	private Country countryImp;
	
	public Country getCountry(int id) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		try {	
			countryImp = getDaoFactory().getCountryDao().getCountryDao(id); 
			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);		
			} finally {
			if (vTransactionStatus != null) {
			platformTransactionManager.rollback(vTransactionStatus);
			   }
			}	
		return countryImp;
	}
	
	public Country getCountry(String countryName, String cityName) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		try {	
			countryImp = getDaoFactory().getCountryDao().getCountryDao( countryName,cityName); 
			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);		
			} finally {
			if (vTransactionStatus != null) {
			platformTransactionManager.rollback(vTransactionStatus);
			   }
			}	
		return countryImp;
	}
}
