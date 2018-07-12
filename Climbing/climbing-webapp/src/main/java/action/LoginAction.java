package action;

import org.apache.commons.lang3.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

import beans.user.User;
import exception.NotFoundException;
import org.climbing.business.contract.ManagerFactory;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;

	
	public String execute() {
		return SUCCESS;	
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
	
	public String doLogout() {
		 // Suppression de l'utilisateur en session
	    this.session.remove("user");

	    return ActionSupport.SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;		
	} 
}
