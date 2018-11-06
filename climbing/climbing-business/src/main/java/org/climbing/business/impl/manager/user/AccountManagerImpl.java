package org.climbing.business.impl.manager.user;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.manager.user.AccountManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.consumer.impl.dao.user.AccountDaoImpl;
import org.climbing.model.beans.user.Account;
import org.climbing.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("accountManager")
public class AccountManagerImpl extends AbstractManagerImpl implements AccountManager {
	/*
	 @Autowired
	 @Qualifier("PlatformTransactionManager")*/
	
	@Inject
	@Named("PlatformTransactionManager")
	private PlatformTransactionManager platformTransactionManager;
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	private Account accountMn;
	
	public AccountManagerImpl() {
		LOGGER.debug("AccountManagerImpl @@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	@Override
	public Account addAccount(Account pAccount) {
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		
		try {
			
			accountMn = getDaoFactory().getAccountDao().addAccountDao(pAccount);
	    	
	    	TransactionStatus vTScommit = vTransactionStatus;
		    vTransactionStatus = null;
		    platformTransactionManager.commit(vTScommit);
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			
		} finally {
	    if (vTransactionStatus != null) {
	        platformTransactionManager.rollback(vTransactionStatus);
	    }
		}
		return accountMn;
	}
	
}
