package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.contract.dao.user.UserDao;
import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.user.UserRM;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;

import java.sql.Types;

import java.util.ArrayList;
/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("userDao") 
public class UserDaoImpl extends AbstractDaoImpl implements UserDao  {
	
	//static final Logger logger = LogManager.getLogger();
    UserRM userRow = new UserRM();

	@Override
	public ArrayList<User> ListAllUser() {
		

		String vSQL = "SELECT * FROM user_1";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        
        ArrayList<User> ListAllUser = (ArrayList<User>) vJdbcTemplate.query(vSQL, userRow);
                
		return ListAllUser;
	}

	@Override
	public void createUser(User user) {	
		String vSQL = "INSERT INTO public.user_1 (pseudo, first_name, last_name, climbing_type, birth_year, genre)"
					+ " VALUES ( :pseudo, :first_name, :last_name, :climbing_type, :birth_year, :genre)";
		
		 MapSqlParameterSource vParams = new MapSqlParameterSource();
		 
	     vParams.addValue("pseudo", user.getPseudo(), Types.VARCHAR);
	     vParams.addValue("first_name", user.getFirstName(), Types.VARCHAR);
	     vParams.addValue("last_name", user.getLastName(), Types.VARCHAR);
	     vParams.addValue("climbing_type", user.getClimbingType(), Types.VARCHAR);
	     vParams.addValue("birth_year", user.getBirthYear(), Types.DATE);
	     vParams.addValue("genre", user.getSexe(), Types.VARCHAR);
	     
	     NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

	     vJdbcTemplate.update(vSQL, vParams);
	     
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
