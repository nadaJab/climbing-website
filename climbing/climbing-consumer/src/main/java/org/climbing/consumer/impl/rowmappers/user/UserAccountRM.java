package org.climbing.consumer.impl.rowmappers.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.springframework.jdbc.core.RowMapper;

public class UserAccountRM implements RowMapper<User>{
	
	public User mapRow(ResultSet rs, int rownumber) throws SQLException {

		User user = new User();
		

		Account account = new Account();
		
		account.setEmail(rs.getString("email")); 
		account.setIdAccount(rs.getInt("id_compte"));
		
		user.setIdUser(rs.getInt("id_user"));
		user.setPseudo(rs.getString("pseudo"));
		user.setLastName(rs.getString("first_name"));
		user.setFirstName(rs.getString("last_name"));
		user.setClimbingType(rs.getString("climbing_type"));
		user.setBirthYear(rs.getDate("birth_year"));
		user.setSexe(rs.getString("genre"));
		user.setRole(rs.getString("role"));
		user.setAccount(account);
		
		return user;
	}

}
