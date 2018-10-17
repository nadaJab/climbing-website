package org.climbing.business.impl.manager.user;

import java.util.ArrayList;

import org.climbing.business.contract.manager.user.UserManager;
import org.climbing.business.impl.AbstractManagerImpl;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.NotFoundException;

public class UserManagerImpl extends AbstractManagerImpl implements UserManager {

	@Override
	public ArrayList<User> getListAllUser() {
		
		return getDaoFactory().getUserDao().ListAllUser();
	}

	@Override
	public void updateUser(User user) {
		getDaoFactory().getUserDao().updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		getDaoFactory().getUserDao().deleteUser(user);		
	}

	@Override
	public void createUser(User user) {
		getDaoFactory().getUserDao().createUser(user);
		
	}
}
