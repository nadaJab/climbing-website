package org.climbing.consumer.contract.dao.user;

import java.util.ArrayList;

import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;

public interface UserDao {

	ArrayList<User> ListAllUser();
	User getUser(Account account);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	
}
