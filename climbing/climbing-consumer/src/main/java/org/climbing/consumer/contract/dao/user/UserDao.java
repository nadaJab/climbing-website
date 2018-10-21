package org.climbing.consumer.contract.dao.user;

import java.util.ArrayList;
import org.climbing.model.beans.user.User;

public interface UserDao {

	ArrayList<User> ListAllUser();
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	User searchUser(int uId);
	User searchUser(String uPseudo);

}
