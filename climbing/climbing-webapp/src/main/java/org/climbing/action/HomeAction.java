package org.climbing.action;
import java.util.ArrayList;

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
	
	//private ArrayList<Spot> ListSpot;
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
		LOGGER.debug(spotBean.toString() + "la methode searchSpot()");

		if((countryBean.getCityName().equals("")) &&(countryBean.getCountryName().equals("")) ) {
			
			spotBean = managerFactory.getSpotManager().getSpot(spotBean.getSpotName());
			countryBean = managerFactory.getCountryManager().getCountry(spotBean.getCountry().getIdCityCountry());
			
		}
		else if((!countryBean.getCityName().isEmpty()) && (!countryBean.getCountryName().isEmpty())) {
			
			countryBean = managerFactory.getCountryManager().getCountry(countryBean.getCityName(), countryBean.getCountryName());
			spotBean = managerFactory.getSpotManager().getSpot(spotBean.getSpotName(), countryBean.getIdCityCountry());
		}
		vResult = ActionSupport.SUCCESS;
		
		return vResult;
}
	
}
