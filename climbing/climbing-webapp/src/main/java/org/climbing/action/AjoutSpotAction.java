package org.climbing.action;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutSpotAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Spot spotBean; 
	private Country countryBean;
	@Autowired
	private ManagerFactory managerFactory;
	
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
	
	public String doAddSpot() {
	    String vResult = ActionSupport.INPUT;
	    spotBean.setCountry(countryBean);
	    spotBean = managerFactory.getSpotManager().addSpot(spotBean);
	    vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
}
