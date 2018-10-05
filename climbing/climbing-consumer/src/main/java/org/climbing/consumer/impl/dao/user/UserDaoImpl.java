package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.user.UserRM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.climbing.consumer.contract.dao.user.UserDao;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("userDao") 
public class UserDaoImpl extends AbstractDaoImpl implements UserDao  {
	
    UserRM userRow = new UserRM();

	@Override
	public ArrayList<User> ListAllUser() {

		String vSQL = "SELECT * FROM user_1";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        
        ArrayList<User> ListAllUser = (ArrayList<User>) vJdbcTemplate.query(vSQL, userRow);
                
		return ListAllUser;
	}

	@Override
	public User getUser(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
