package org.climbing.action;
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
	
	public String doAddRoute() {
		String vResult = ActionSupport.INPUT;
		routeBean = managerFactory.getRouteManager().addRoute(routeBean);
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
}
