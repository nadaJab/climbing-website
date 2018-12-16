package org.climbing.action;

import java.util.ArrayList;
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

public class UserProfileAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ManagerFactory managerFactory;
	
    private Map<String, Object> session;
	private User userBean;
	private Account accountBean;
	private ArrayList<User> listUsers;
	
	private static final Logger LOGGER = LogManager.getLogger(UserProfileAction.class);

	public String execute() {
		listUsers = managerFactory.getUserManager().getListAllUser();
		LOGGER.debug(listUsers + "///");
		return SUCCESS;	
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session ;
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
	
	public ArrayList<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(ArrayList<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	public String doUpdateUser() {
		String vResult = ActionSupport.INPUT;
		
		User userSession = (User) session.get("user"); 
		LOGGER.debug("Voici les anciennes données " + userSession);
		LOGGER.debug("Voici les nouvelles données " + userBean + accountBean);
		
		userBean.setIdUser(userSession.getIdUser());
		userBean.setSexe(userSession.getSexe());
		if(userBean.getClimbingType() == null) {
			userBean.setClimbingType(userSession.getClimbingType());
			vResult = ActionSupport.SUCCESS;  

		}
		accountBean.setIdAccount(userSession.getAccount().getIdAccount());
		
		//si on a pas modifié password, on garde l'ancien password
		if(accountBean.getPassword() == "") {
			accountBean.setPassword(userSession.getAccount().getPassword());
			vResult = ActionSupport.SUCCESS;  

		}
		else {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 String hashedPassword = passwordEncoder.encode(accountBean.getPassword());
			 accountBean.setPassword(hashedPassword);	
			 vResult = ActionSupport.SUCCESS;  

		}
		userBean.setAccount(accountBean);
		userBean = managerFactory.getUserManager().updateUser(userBean);
		session.remove("user");
		session.put("user", userBean);
		vResult = ActionSupport.SUCCESS;  
		
	    return vResult;      	
	}
	
}
