package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.user.AccountRM;

import java.sql.Types;
import java.util.ArrayList;

import org.climbing.consumer.contract.dao.user.AccountDao;

import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("accountDao") 
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao  {

    AccountRM accountRow = new AccountRM();

	@Override
	public void addAccount(Account account) {
		
		String vSQL = "INSERT INTO account (email, password) VALUES (:email, :password)";
	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	    
	    BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(account);
	    vParams.registerSqlType("email", Types.VARCHAR);
	    vParams.registerSqlType("password", Types.VARCHAR);
	    
	    //try {
	        vJdbcTemplate.update(vSQL, vParams);
	        
	    /*} catch (DuplicateKeyException vEx) {
	        LOGGER.error("L'email existe déjà ! id=", vEx);*/	
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub
		
	}
}
