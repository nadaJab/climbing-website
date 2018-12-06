package org.climbing.business.impl.manager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.manager.user.UserManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.AccountException;
import org.climbing.model.exception.UserException;

@Component("userManager")
public class UserManagerImpl extends AbstractManagerImpl implements UserManager {
	/*
	@Autowired
	@Qualifier("PlatformTransactionManager")*/
	
	@Inject
	@Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	
	private static final Logger LOGGER = LogManager.getLogger(UserManagerImpl.class);
	private User userImp;

	@Override
	public ArrayList<User> getListAllUser() {
		
		return getDaoFactory().getUserDao().ListAllUser();
	}
	
	public User createUser(User pUser) throws AccountException, UserException {
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		
		try {	
			
			getDaoFactory().getAccountDao().addAccountDao(pUser.getAccount());
			getDaoFactory().getUserDao().createUserDao(pUser);
			
			TransactionStatus vTScommit = vTransactionStatus;
	    	vTransactionStatus = null;
	    	platformTransactionManager.commit(vTScommit);		
		} finally {
	    if (vTransactionStatus != null) {
	        platformTransactionManager.rollback(vTransactionStatus);
	    }
		}
		return pUser;
	}
	
	public User getUser(int idAccount) {
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		try {	
		
			userImp = getDaoFactory().getUserDao().searchUserDao(idAccount);

		TransactionStatus vTScommit = vTransactionStatus;
	    vTransactionStatus = null;
	    platformTransactionManager.commit(vTScommit);		
		} finally {
	    if (vTransactionStatus != null) {
	    platformTransactionManager.rollback(vTransactionStatus);
	    	}
		}		
		return userImp;	
	}
	@Override
	public void updateUser(User user) {
		getDaoFactory().getUserDao().updateUserDao(user);
	}

	@Override
	public void deleteUser(User user) {
		getDaoFactory().getUserDao().deleteUserDao(user);		
	}

	@Override
	public User searchUser(String uPseudo) {
		// TODO Auto-generated method stub
		return null;
	}

}
