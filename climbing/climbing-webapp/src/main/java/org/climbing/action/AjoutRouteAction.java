package org.climbing.action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.spot.Route;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutRouteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Route routeBean;
	private Integer idSector;
	private static final Logger LOGGER = LogManager.getLogger(AjoutRouteAction.class);

	@Autowired
	private ManagerFactory managerFactory;
	
	public String execute() {
		return SUCCESS;	
	}

	public Route getRouteBean() {
		return routeBean;
	}

	public void setRouteBean(Route routeBean) {
		this.routeBean = routeBean;
	}
	
	public Integer getIdSector() {
		return idSector;
	}

	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}

	public String doAddRoute() {
		String vResult = ActionSupport.INPUT;
		LOGGER.debug(idSector + "[]");
		
		routeBean = managerFactory.getRouteManager().addRoute(routeBean);
		managerFactory.getRouteManager().addJoinSectorRoute(routeBean.getIdRoute(), idSector);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
}
