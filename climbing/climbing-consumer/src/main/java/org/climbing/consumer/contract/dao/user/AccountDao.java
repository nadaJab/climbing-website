package org.climbing.consumer.contract.dao.user;

import org.climbing.model.beans.user.Account;

public interface AccountDao {
	
	//Account connexion(Account account); getAccount() dans user
	
	Account addAccountDao(Account account);
	void updateAccountDao(Account account);
	void deleteAccountDao(Account account);
}
