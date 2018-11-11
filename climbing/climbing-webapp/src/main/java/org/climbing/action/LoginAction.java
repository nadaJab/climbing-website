package org.climbing.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.climbing.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;
    
	private Account accountBean;
	private User userBean;
	
	@Autowired
	private ManagerFactory managerFactory;
	
	public String execute() {
		return SUCCESS;	
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
	
	public Account getAccountBean() {
		return accountBean;
	}

	public void setAccountBean(Account accountBean) {
		this.accountBean = accountBean;
	}

	public String doLogin() {
		
	     String vResult = ActionSupport.INPUT;
	     Account accountL;
	     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     accountL = managerFactory.getAccountManager().getAccount(accountBean);
	     
	     if(accountBean.getEmail().equals( accountL.getEmail())) {
	    	 
	    	 if(passwordEncoder.matches(accountBean.getPassword(), accountL.getPassword())) {
	    		 
	    		 userBean = managerFactory.getUserManager().getUser(accountL.getIdAccount());
	    		 userBean.setAccount(accountL);
	    		 
		    	 this.session.put("user", userBean);
		    	 vResult = ActionSupport.SUCCESS;  
	    	 }
	    	 else {
		    	 addActionError("Entrer un mot de passe valide !");
	    	 }
	     }
	     else {
	    	 addActionError("L'email n'existe pas !");
	     }	        	
	     return vResult;      
	}
	
	public String doLogout() {
		
	    this.session.remove("userBean");
	    this.servletRequest.getSession().invalidate();
	    
		return ActionSupport.SUCCESS;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;		
	}
	
}
