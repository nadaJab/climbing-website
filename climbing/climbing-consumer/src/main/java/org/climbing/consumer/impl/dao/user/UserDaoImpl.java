package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.contract.dao.user.UserDao;
import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.user.UserAccountRM;
import org.climbing.consumer.impl.rowmappers.user.UserRM;
import org.climbing.model.beans.user.User;

import java.sql.Types;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("userDao") 
public class UserDaoImpl extends AbstractDaoImpl implements UserDao  {
	
	static final Logger logger = LogManager.getLogger();
    UserRM userRow = new UserRM();
    User userD;
	@Override
	public ArrayList<User> ListAllUser() {
		
		String vSQL = "SELECT * FROM user_Web";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        
        ArrayList<User> ListAllUser = (ArrayList<User>) vJdbcTemplate.query(vSQL, userRow);
                
		return ListAllUser;
	}
	
	public User createUserDao(User user) {	
		String vSQL = "INSERT INTO user_Web (pseudo, first_name, last_name, climbing_type, birth_year, genre, id_compte)"
						+ " VALUES ( :pseudo, :firstName, :lastName, :climbingType, :birthYear, :genre, :idAccount)";
			
		 //auto generated primary key by the database
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		
	     NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		 MapSqlParameterSource vParams = new MapSqlParameterSource();
		 
	     vParams.addValue("pseudo", user.getPseudo(), Types.VARCHAR);
	     vParams.addValue("firstName", user.getFirstName(), Types.VARCHAR);
	     vParams.addValue("lastName", user.getLastName(), Types.VARCHAR);
	     vParams.addValue("climbingType", user.getClimbingType(), Types.VARCHAR);
	     vParams.addValue("birthYear", user.getBirthYear(), Types.DATE);
	     vParams.addValue("genre", user.getSexe(), Types.VARCHAR);
	     vParams.addValue("idAccount", user.getAccount().getIdAccount(), Types.INTEGER);
	     
	     vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_user" });   
	     user.setIdUser(keyHolder.getKey().intValue());

		return user;
	}

	@Override
	public User updateUserDao(User user) {
		String vSQL = "UPDATE user_Web SET pseudo = :pseudo, first_name = :firstName, "
					+ "last_name = :lastName, climbing_type = :climbingType, birth_year = :birthYear WHERE id_user = :idUser";
	    
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vParams.addValue("pseudo", user.getPseudo(), Types.VARCHAR);
	    vParams.addValue("firstName", user.getFirstName(), Types.VARCHAR);
	    vParams.addValue("lastName", user.getLastName(), Types.VARCHAR);
	    vParams.addValue("climbingType", user.getClimbingType(), Types.VARCHAR);
	    vParams.addValue("birthYear", user.getBirthYear(), Types.DATE);
	    vParams.addValue("idUser", user.getIdUser(), Types.INTEGER);
	    
	    vJdbcTemplate.update(vSQL, vParams);
		return user;
	}


	@Override
	public User searchUserDao(int aId) {
		String vSQL = "SELECT * FROM  user_Web WHERE id_compte = ?";
		
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		userD = (User) vJdbcTemplate.queryForObject(vSQL, new Object[] { aId }, new UserRM());
		return userD;
	}

	
	@Override
	public boolean updateRoleDao(int idUser, String role) {
		String vSQL = "UPDATE user_Web SET role = ? WHERE id_user = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL,  role, idUser);
		return true;
	}

	@Override
	public ArrayList<User> getUserAccountDao(int idUser) {
		String vSQL = "SELECT * FROM  user_Web INNER JOIN account ON user_Web.id_compte = account.id_compte "
					+ "WHERE id_user = ?";
		
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        ArrayList<User> ListUser = (ArrayList<User>) vJdbcTemplate.query(vSQL, new Object[] { idUser }, new UserAccountRM());
		return ListUser;
	}

}
