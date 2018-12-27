package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.impl.rowmappers.user.AccountRM;
import org.climbing.consumer.impl.rowmappers.user.UserRM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.consumer.contract.dao.user.AccountDao;
import java.sql.Types;

import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.AccountException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("accountDao") 
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao  {

	private static final Logger LOGGER = LogManager.getRootLogger();
	AccountRM accountRow = new AccountRM();

	public Account addAccountDao(Account account) throws AccountException {

		String vSQL = "INSERT INTO account (email, password) VALUES (:email, :password)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("email", account.getEmail(), Types.VARCHAR);
		vParams.addValue("password", account.getPassword(), Types.VARCHAR);

		try {
			vJdbcTemplate.update(vSQL, vParams, keyHolder, new String[] { "id_compte" });
			account.setIdAccount(keyHolder.getKey().intValue());
		} catch (DuplicateKeyException vEx) {

			LOGGER.debug("Coordonnee invalide email=" + account.getEmail());
			throw new AccountException("email invalide=" + account.getEmail());
		}  
		return account;
	}

	@Override
	public Account getAccountDao(Account account) {
		String vSQL = "SELECT * FROM account WHERE email = :email";

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("email", account.getEmail(), Types.VARCHAR);
		vParams.addValue("password", account.getPassword(), Types.VARCHAR);
		vParams.addValue("id_compte", account.getIdAccount(), Types.INTEGER);

		account = vJdbcTemplate.queryForObject(vSQL, vParams, accountRow);

		return account;	
	}

	@Override
	public Account updateAccountDao(Account account) {
		String vSQL = "UPDATE account SET email = :email, password = :password WHERE id_compte = :idAccount";

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		MapSqlParameterSource vParams = new MapSqlParameterSource();

		vParams.addValue("email", account.getEmail(), Types.VARCHAR);
		vParams.addValue("password", account.getPassword(), Types.VARCHAR);
		vParams.addValue("idAccount", account.getIdAccount(), Types.INTEGER);

		vJdbcTemplate.update(vSQL, vParams);

		return account;
	}

	@Override
	public boolean deleteAccountDao(int idAccount) {
		boolean var=false;
		String vSQL = "DELETE FROM account WHERE id_compte = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		try {
			vJdbcTemplate.update(vSQL, idAccount) ;
			var=true;
		} catch (DataAccessException vEx) {
			vEx.printStackTrace();
		}        

		return var;
	}

	@Override
	public Integer getAccountOk(String email) {

		String vSQL = "SELECT count(email) FROM account WHERE email = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		int var = vJdbcTemplate.queryForObject(vSQL, new Object[] { email }, Integer.class);

		return var;

	}

}
