package org.climbing.business.impl.manager.user;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.user.UserManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;

public class UserManagerImpl extends AbstractManagerImpl implements UserManager {
	
	@Inject
    @Named("PlatformTransactionManager")
    private PlatformTransactionManager platformTransactionManager;
	
	@Override
	public ArrayList<User> getListAllUser() {
		
		return getDaoFactory().getUserDao().ListAllUser();
	}
	
	@Override
	public User createUser(User user, Account account) {
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 
		
		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);
		try {
	  
	    TransactionStatus vTScommit = vTransactionStatus;
	    vTransactionStatus = null;
	    platformTransactionManager.commit(vTScommit);
	    
		getDaoFactory().getUserDao().createUser(user);
		getDaoFactory().getAccountDao().addAccount(account);
		
		} finally {
	    if (vTransactionStatus != null) {
	        platformTransactionManager.rollback(vTransactionStatus);
	    }
		}
		return user;	
	}
	
	@Override
	public void updateUser(User user) {
		getDaoFactory().getUserDao().updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		getDaoFactory().getUserDao().deleteUser(user);		
	}

	@Override
	public User searchUser(String uPseudo) {
		// TODO Auto-generated method stub
		return null;
	}

}
