package org.climbing.action;

/* import org.apache.commons.lang3.StringUtils; */
import com.opensymphony.xwork2.ActionSupport;

/* 
import beans.user.User;
import exception.NotFoundException;
import org.climbing.business.contract.ManagerFactory; */

import org.climbing.model.beans.user.Account;
 
public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account accountBean;
	private String password;
	
	public String execute() {
		return SUCCESS;	
	}
	

	public Account getAccountBean() {
		return accountBean;
	}


	public void setAccountBean(Account accountBean) {
		this.accountBean = accountBean;
	}




	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String doLogin() {
	     String vResult = ActionSupport.INPUT;
	     /*    if (!StringUtils.isAllEmpty(email, password)) {
	        	try {
	        		
	        		User user = ManagerFactory.getUtilisateurManager()
                            	.getUtilisateur(email, password);
	        		
	                this.session.put("user", user); 
	                vResult = ActionSupport.SUCCESS;
	        		
	        	}catch  (NotFoundException pEx) {
	                this.addActionError("Email ou mot de passe invalide !");
	            }
	        } */ 

	     return vResult;      
	}
	
	
}
