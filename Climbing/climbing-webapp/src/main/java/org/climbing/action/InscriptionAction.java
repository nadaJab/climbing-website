package org.climbing.action;

//import org.climbing.business.contract.manager.user.UserManager;
//import org.climbing.business.impl.manager.user.UserManagerImpl;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import com.opensymphony.xwork2.ActionSupport;

public class InscriptionAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User userBean;
	private Account accountBean;
	
	//private UserManager userManager = new UserManagerImpl();
	
	public String execute() throws Exception {
		//return INPUT;	
		return SUCCESS;
	}

	public String input() throws Exception {
		return INPUT;
	}
	
	public User getUser() {
		return userBean;
	}

	public void setUser(User user) {
		this.userBean = user;
	}

	public Account getAccount() {
		return accountBean;
	}

	public void setAccount(Account accountBean) {
		this.accountBean = accountBean;
	}
	
}
