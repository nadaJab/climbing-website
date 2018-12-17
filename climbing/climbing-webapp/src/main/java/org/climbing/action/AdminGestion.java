package org.climbing.action;

<<<<<<< HEAD
import java.util.Map;
=======
import java.util.ArrayList;
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0

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
<<<<<<< HEAD
	private Integer idSector;
	private Integer idRoute;
	private User userBean;
		
=======
	private User userBean;
	
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
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
<<<<<<< HEAD
	
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
=======
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0

	public String deleteSpot() {
		String vResult = ActionSupport.INPUT;
		
		managerFactory.getSpotManager().deleteSpot(idSpot);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
	public String updateRoleUser() {
		String vResult = ActionSupport.INPUT;
		
<<<<<<< HEAD
		LOGGER.debug(userBean.getRole() + "===");
		
		managerFactory.getUserManager().updateRole(idUser, userBean.getRole());
=======
		managerFactory.getUserManager().updateRole(idUser);
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
		vResult = ActionSupport.SUCCESS;
		
		return vResult;
	}
<<<<<<< HEAD
	
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
=======
>>>>>>> 8aa81a7b9392e8a6c62aaff28b1a159dc70605f0
}
