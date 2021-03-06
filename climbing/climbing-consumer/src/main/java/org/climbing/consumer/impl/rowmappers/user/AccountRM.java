package org.climbing.consumer.impl.rowmappers.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.climbing.model.beans.user.Account;
import org.springframework.jdbc.core.RowMapper;

public class AccountRM implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rownumber) throws SQLException {
		
		Account account = new Account();
		
		account.setIdAccount(rs.getInt("id_compte"));
		account.setEmail(rs.getString("email"));
		account.setPassword(rs.getString("password"));
		
		return account;
	}

}
