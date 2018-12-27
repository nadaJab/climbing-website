package org.climbing.business.contract.manager.user;

import org.climbing.model.beans.user.*;
import org.climbing.model.exception.AccountException;
import org.climbing.model.exception.UserException;

import java.util.ArrayList;

public interface UserManager {

	User createUser(User user) throws AccountException, UserException;	
	ArrayList<User> getListAllUser();
	User updateUser(User user);
	User getUser(int idAccount);
	boolean updateRole(int idUser, String role);
	ArrayList<User> getUserAccount(int idUser);

}
