package org.climbing.consumer.contract.dao.user;

import org.climbing.model.beans.user.Account;
import org.climbing.model.exception.AccountException;

public interface AccountDao {
	
	Account addAccountDao(Account account) throws AccountException;
	Account updateAccountDao(Account account);
	boolean deleteAccountDao(int idAccount);
	Account getAccountDao(Account account);
	Integer getAccountOk(String email);
}
