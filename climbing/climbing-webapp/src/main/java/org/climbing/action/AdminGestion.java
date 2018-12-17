package org.climbing.action;

import java.util.Map;

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
	private Integer idSector;
	private Integer idRoute;
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
	
	public Integer getIdSector() {
		return idSector;
	}

	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}
	
	public Integer getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(Integer idRoute) {
		this.idRoute = idRoute;
	}

	public String deleteSpot() {
		String vResult = ActionSupport.INPUT;
		
		managerFactory.getSpotManager().deleteSpot(idSpot);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
	public String updateRoleUser() {
		String vResult = ActionSupport.INPUT;
		
		LOGGER.debug(userBean.getRole() + "===");
		
		managerFactory.getUserManager().updateRole(idUser, userBean.getRole());
		vResult = ActionSupport.SUCCESS;
		
		return vResult;
	}
	
	public String deleteSector() {
		String vResult = ActionSupport.INPUT;
		LOGGER.debug(idSector + "===");
		managerFactory.getSectorManager().deleteSector(idSector);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
	public String deleteRoute() {
		String vResult = ActionSupport.INPUT;
		LOGGER.debug(idRoute);
		managerFactory.getRouteManager().deleteRoute(idRoute);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
}
