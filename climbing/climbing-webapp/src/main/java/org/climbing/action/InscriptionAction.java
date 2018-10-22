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
	
	//private UserManager userManager = new UserManagerImpl();
		
	
	
}
