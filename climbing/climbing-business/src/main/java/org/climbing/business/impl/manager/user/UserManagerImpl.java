package org.climbing.business.impl.manager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
/*
import javax.inject.Inject;
import javax.inject.Named; */

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.manager.user.UserManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.consumer.impl.dao.user.AccountDaoImpl;
import org.climbing.consumer.impl.dao.user.UserDaoImpl;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;

@Component("userManager")
public class UserManagerImpl extends AbstractManagerImpl implements UserManager {
	/*
	@Autowired
	@Qualifier("PlatformTransactionManager")*/
	
	@Inject
	@Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	
	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public ArrayList<User> getListAllUser() {
		
		return getDaoFactory().getUserDao().ListAllUser();
	}
	
	public User createUser(User pUser) {
		User userImp;
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		
		try {			
			
			userImp = getDaoFactory().getUserDao().createUserDao(pUser);
			
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
