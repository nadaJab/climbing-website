package org.climbing.consumer.contract.dao.user;

import org.climbing.model.beans.user.Account;
import org.climbing.model.exception.AccountException;

public interface AccountDao {
	
	//Account connexion(Account account); getAccount() dans user
	
	Account addAccountDao(Account account) throws AccountException;
	Account updateAccountDao(Account account);
	void deleteAccountDao(Account account);
	Account getAccountDao(Account account);
}
