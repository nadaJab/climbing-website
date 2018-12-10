package org.climbing.action;

import java.util.Map;

import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class UserProfileAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ManagerFactory managerFactory;
	
    private Map<String, Object> session;
	private User userBean;
	private Account accountBean;
	
	public String execute() {
		return SUCCESS;	
	}

	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}

	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	
}
