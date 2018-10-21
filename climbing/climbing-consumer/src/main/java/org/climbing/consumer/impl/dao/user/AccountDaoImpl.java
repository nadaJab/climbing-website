package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.impl.AbstractDaoImpl;

import java.sql.Types;

import org.climbing.consumer.contract.dao.user.AccountDao;

import org.climbing.model.beans.user.Account;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("accountDao") 
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao  {

	@Override
	public void addAccount(Account account) {
		
		String vSQL = "INSERT INTO account (email, password) VALUES (:email, :password)";
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(account.getPassword());
				
	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	    
	    BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(account);
	    vParams.registerSqlType("email", Types.VARCHAR);
	    vParams.registerSqlType("password", Types.VARCHAR);
	  //vParams.registerSqlType(hashedPassword, Types.VARCHAR); 
	    
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
