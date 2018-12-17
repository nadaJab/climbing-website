package org.climbing.business.contract.manager.user;

import org.climbing.model.beans.user.*;
import org.climbing.model.exception.AccountException;
import org.climbing.model.exception.UserException;

import java.util.ArrayList;

public interface UserManager {

	User createUser(User user) throws AccountException, UserException;	
	ArrayList<User> getListAllUser();
	User updateUser(User user);
	void deleteUser(User user);
	User searchUser(String uPseudo);
	User getUser(int idAccount);
<<<<<<< HEAD
	boolean updateRole(int idUser, String role);
=======
	boolean updateRole(int idUser);
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
}
