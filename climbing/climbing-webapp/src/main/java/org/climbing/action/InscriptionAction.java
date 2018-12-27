package org.climbing.action;

import org.climbing.model.exception.AccountException;
import org.climbing.model.exception.UserException;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opensymphony.xwork2.ActionSupport;

public class InscriptionAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(InscriptionAction.class);

	@Autowired
	private ManagerFactory managerFactory;

	private Map<String, Object> session;
	private static final String USER = "user";
	private User userBean;
	private Account accountBean;

	public String execute() {
		return SUCCESS;	
	}

	public User getUserBean() {
		return userBean;
	}
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
	public Account getAccountBean() {
		return accountBean;
	}
	public void setAccountBean(Account accountBean) {
		this.accountBean = accountBean;
	}

	public String doCreateUser() throws AccountException, UserException{
		String vResult = ActionSupport.INPUT;

		int var = managerFactory.getAccountManager().getAccountOk(accountBean.getEmail());

		if(var < 1) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(accountBean.getPassword());

			accountBean.setPassword(hashedPassword);		
			userBean.setAccount(accountBean);
			userBean = managerFactory.getUserManager().createUser(userBean);
			this.session.put(USER, userBean);
			vResult = ActionSupport.SUCCESS;
		}
		else {
			addActionError("L'email existe déjà !");
		}
		return vResult;	    	
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session ;		
	}


}
