package org.climbing.action;

import org.climbing.model.exception.AccountException;
import org.climbing.model.exception.UserException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opensymphony.xwork2.ActionSupport;

public class InscriptionAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	@Autowired
	private ManagerFactory managerFactory;
		
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
	
	
	public String doCreateUser(){
	    String vResult = ActionSupport.INPUT;
	    
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(accountBean.getPassword());
		
		accountBean.setPassword(hashedPassword);
		managerFactory.getAccountManager().addAccount(accountBean);	
		
		userBean.setAccount(accountBean);
		userBean = managerFactory.getUserManager().createUser(userBean);
	    
	    vResult = ActionSupport.SUCCESS;
	    
		return vResult;
	    	
	}
	
	
}
