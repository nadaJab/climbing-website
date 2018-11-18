package org.climbing.action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	private String nameSpot;
	private String Ville;
	private String pays; */
	
	private Spot spotBean;
	private Country countryBean;
	
	@Autowired
	private ManagerFactory managerFactory;
	private static final Logger LOGGER = LogManager.getLogger(HomeAction.class);

	public String execute() {
		return SUCCESS;	
	}

	public Spot getSpotBean() {
		return spotBean;
	}

	public void setSpotBean(Spot spotBean) {
		this.spotBean = spotBean;
	}

	public Country getCountryBean() {
		return countryBean;
	}

	public void setCountryBean(Country countryBean) {
		this.countryBean = countryBean;
	}

	public String searchSpot() {
		String vResult = ActionSupport.INPUT;
		LOGGER.debug(spotBean + "la methode searchSpot()");
		
		spotBean = managerFactory.getSpotManager().getSpot(spotBean.getSpotName());
		    
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
}
