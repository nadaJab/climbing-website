package org.climbing.business.contract.manager.user;

import org.climbing.model.beans.user.Account;
import org.climbing.model.exception.AccountException;

public interface AccountManager {
	
	Account addAccount(Account pAccount) throws AccountException;
	Account getAccount(Account pAccount);
	Integer getAccountOk(String email);
	boolean deleteAccountDao(int idAccount);
}
