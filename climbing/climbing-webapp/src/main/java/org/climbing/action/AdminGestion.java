package org.climbing.action;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AdminGestion extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ManagerFactory managerFactory;
	private static final Logger LOGGER = LogManager.getLogger(AdminGestion.class);
	private Integer idSpot;
	private Integer idUser;
	private User userBean;
	
	public String execute() {
        return ActionSupport.SUCCESS;
	}
	
	public Integer getIdSpot() {
		return idSpot;
	}

	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	public String deleteSpot() {
		String vResult = ActionSupport.INPUT;
		
		managerFactory.getSpotManager().deleteSpot(idSpot);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
	public String updateRoleUser() {
		String vResult = ActionSupport.INPUT;
		
		managerFactory.getUserManager().updateRole(idUser);
		vResult = ActionSupport.SUCCESS;
		
		return vResult;
	}
}
