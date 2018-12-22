package org.climbing.consumer.contract.dao.user;

import java.util.ArrayList;
import org.climbing.model.beans.user.User;

public interface UserDao {

	ArrayList<User> ListAllUser();
	User createUserDao(User user);
	User updateUserDao(User user);
	void deleteUserDao(User user);
	User searchUserDao(int uId);
	User searchUserDao(String uPseudo);
	boolean updateRoleDao(int idUser, String role);
	ArrayList<User> getUserAccountDao(int idUser);
}
