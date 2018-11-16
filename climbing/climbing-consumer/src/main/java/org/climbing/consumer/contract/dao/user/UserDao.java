package org.climbing.consumer.contract.dao.user;

import java.util.ArrayList;
import org.climbing.model.beans.user.User;

public interface UserDao {

	ArrayList<User> ListAllUser();
	User createUserDao(User user);
	void updateUserDao(User user);
	void deleteUserDao(User user);
	User searchUserDao(int uId);
	User searchUserDao(String uPseudo);
}
