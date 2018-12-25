package org.climbing.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.user.Account;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport implements SessionAware, ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
    private HttpServletRequest servletRequest;
    	
	private static final String USER = "user";
	
	private static final Logger LOGGER = LogManager.getLogger(LogOutAction.class);

			
	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
	
	public String doLogout() {
		
		LOGGER.debug("Methode deconnexion" );
	    this.session.remove(USER);
	    this.servletRequest.getSession().invalidate();
	    
		return ActionSupport.SUCCESS;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;		
	}

}
