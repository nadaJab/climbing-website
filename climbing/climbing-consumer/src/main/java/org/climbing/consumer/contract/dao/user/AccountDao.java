package org.climbing.consumer.contract.dao.user;

import org.climbing.model.beans.user.Account;

public interface AccountDao {
	
	//Account connexion(Account account); getAccount() dans user
	
	void addAccount(Account account);
	void updateAccount(Account account);
	void deleteAccount(Account account);
}
