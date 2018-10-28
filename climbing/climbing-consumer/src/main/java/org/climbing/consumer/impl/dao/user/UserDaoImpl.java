package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.contract.dao.user.UserDao;
import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.user.UserRM;
import org.climbing.model.beans.user.User;

import java.sql.Types;

import java.util.ArrayList;
/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	public User createUser(User user) {	
		String vSQL = "INSERT INTO user_1 (pseudo, first_name, last_name, climbing_type, birth_year, genre, role, id_account)"
					+ " VALUES ( :pseudo, :firstName, :lastName, :climbingType, :birthYear, :genre, :role, idAccount)";
		
		 //auto generated primary key by the database
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 user.setIdUser(user.getAccount().getIdAccount());;	
		 
	     NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		 MapSqlParameterSource vParams = new MapSqlParameterSource();
		 
	     vParams.addValue("pseudo", user.getPseudo(), Types.VARCHAR);
	     vParams.addValue("firstName", user.getFirstName(), Types.VARCHAR);
	     vParams.addValue("lastName", user.getLastName(), Types.VARCHAR);
	     vParams.addValue("climbingType", user.getClimbingType(), Types.VARCHAR);
	     vParams.addValue("birthYear", user.getBirthYear(), Types.DATE);
	     vParams.addValue("genre", user.getSexe(), Types.VARCHAR);
	     vParams.addValue("role", user.getRole(), Types.VARCHAR);
	     vParams.addValue("idAccount", user.getAccount().getIdAccount(), Types.VARCHAR);
	     
	     vJdbcTemplate.update(vSQL, vParams, keyHolder);    
	     user.setIdUser(keyHolder.getKey().intValue());
	     
		return user;
	}

	@Override
	public void updateUser(User user) {
		String vSQL = "UPDATE user_1 SET pseudo = :pseudo, first_name = :first_name, "
					+ "last_name = :last_name,climbing_type = :climbing_type, birth_year = :birth_year";
	    
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("pseudo", user.getPseudo(), Types.VARCHAR);
	    vParams.addValue("first_name", user.getFirstName(), Types.VARCHAR);
	    vParams.addValue("last_name", user.getLastName(), Types.VARCHAR);
	    vParams.addValue("climbing_type", user.getClimbingType(), Types.VARCHAR);
	    vParams.addValue("birth_year", user.getBirthYear(), Types.DATE);
	    
	    vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void deleteUser(User user) {
		String vSQL = "DELETE FROM user_1 WHERE id_user = :id_user";
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id_user", user.getIdUser(), Types.INTEGER);
		
	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	    vJdbcTemplate.update(vSQL, vParams);
		
	}

	@Override
	public User searchUser(int uId) {
		String vSQL = "SELECT FROM user_1 WHERE id_user = :id_user";
		User user;
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id_user", uId, Types.INTEGER);
		
	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());  
	    if(!vJdbcTemplate.query(vSQL, userRow).isEmpty()) {
	    	user = (User) vJdbcTemplate.query(vSQL, userRow);
	    }
	    else {
	    	user = null;
	    }

		return user;
	}

	@Override
	public User searchUser(String uPseudo) {
		String vSQL = "SELECT FROM user_1 WHERE pseudo = :pseudo";
		User user;
		
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("pseudo", uPseudo, Types.VARCHAR);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());  
	    if(!vJdbcTemplate.query(vSQL, userRow).isEmpty()) {
	    	user = (User) vJdbcTemplate.query(vSQL, userRow);
	    }
	    else {
	    	user = null;
	    }

		return user;
	}
}
