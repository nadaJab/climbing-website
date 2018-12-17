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
<<<<<<< HEAD
	boolean updateRoleDao(int idUser, String role);
=======
	boolean updateRoleDao(int idUser);
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
}
