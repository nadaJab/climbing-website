package org.climbing.business.contract.manager.user;

import org.climbing.model.beans.user.*;
import org.climbing.model.exception.AccountException;
import org.climbing.model.exception.UserException;

import java.util.ArrayList;

public interface UserManager {

	User createUser(User user) throws AccountException, UserException;	
	ArrayList<User> getListAllUser();
	void updateUser(User user);
	void deleteUser(User user);
	User searchUser(String uPseudo);
	User getUser(int idAccount);
}
