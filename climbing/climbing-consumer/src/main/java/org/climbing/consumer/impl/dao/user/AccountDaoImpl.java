package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.consumer.contract.dao.user.AccountDao;
import java.sql.Types;

import org.climbing.model.beans.user.Account;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("accountDao") 
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao  {
	
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	@Override
	public Account addAccountDao(Account account) {
				
		String vSQL = "INSERT INTO account (email, password) VALUES (:email, :password)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
				
	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();
	    
		vParams.addValue("email", account.getEmail(), Types.VARCHAR);
		vParams.addValue("password", account.getPassword(), Types.VARCHAR);
	
		vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_compte" });
		account.setIdAccount(keyHolder.getKey().intValue());
		LOGGER.debug(account.getIdAccount() + "ooooooooooooooooooooooooo");
	    return account;
	}

	@Override
	public void updateAccountDao(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccountDao(Account account) {
		// TODO Auto-generated method stub
		
	}

}
