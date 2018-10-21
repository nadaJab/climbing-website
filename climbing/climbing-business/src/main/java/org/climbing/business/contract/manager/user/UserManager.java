package org.climbing.business.contract.manager.user;

import org.climbing.model.beans.user.*;

import java.util.ArrayList;

public interface UserManager {

	void createUser(User user, Account account);
	ArrayList<User> getListAllUser();
	void updateUser(User user);
	void deleteUser(User user);
	User searchUser(String uPseudo);

}
