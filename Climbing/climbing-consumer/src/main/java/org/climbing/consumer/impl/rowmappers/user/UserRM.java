package org.climbing.consumer.impl.rowmappers.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.user.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRM implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rownumber) throws SQLException {

		User user = new User();
		user.setId_user(rs.getInt("id"));
		user.setPseudo(rs.getString("pseudo"));
		user.setLast_name(rs.getString("nom"));
		user.setFirst_name(rs.getString("prénom"));
		user.setClimbing_type(rs.getString("type_grimpe"));
		user.setBirth_year(rs.getDate("date_naissance"));
		user.setGenre(rs.getString("genre"));
		user.setRole(rs.getString("role"));
		//*****
		//user.setCompte(rs.);
		
		return user;
	}

}
