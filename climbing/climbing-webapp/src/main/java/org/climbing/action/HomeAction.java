package org.climbing.action;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Spot;
import org.climbing.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Spot spotBean;
	private ArrayList<Spot> listSpot;
	private Country countryBean;
	private boolean testVar = false;
	private boolean testAffichage = false;
	
	@Autowired
	private ManagerFactory managerFactory;
	private static final Logger LOGGER = LogManager.getLogger(HomeAction.class);

	public String execute() {
        return ActionSupport.SUCCESS;
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
	
	public ArrayList<Spot> getListSpot() {
		return listSpot;
	}

	public void setListSpot(ArrayList<Spot> listSpot) {
		this.listSpot = listSpot;
	}
	
	public boolean isTestVar() {
		return testVar;
	}

	public void setTestVar(boolean testVar) {
		this.testVar = testVar;
	}
	
	public boolean isTestAffichage() {
		return testAffichage;
	}

	public void setTestAffichage(boolean testAffichage) {
		this.testAffichage = testAffichage;
	}

	public String searchSpot() throws NotFoundException {
		String vResult = ActionSupport.INPUT;
		LOGGER.debug(spotBean.toString() + "la methode searchSpot()");

		//(Si les champs: nom du site, ville et pays sont vide)
		if((spotBean.getSpotName().equals("")) && (countryBean.getCityName().equals("")) && (countryBean.getCountryName().equals("")) ) {
			
			listSpot = managerFactory.getSpotManager().getAllSpot();
						
			vResult = ActionSupport.SUCCESS;
		}
		
		//(Si tous les champs ne sont pas vide)
		else if((!spotBean.getSpotName().isEmpty()) && (!countryBean.getCityName().isEmpty()) && (!countryBean.getCountryName().isEmpty())) {
			testVar = true;
			spotBean = managerFactory.getSpotManager().getSpot(spotBean.getSpotName(), countryBean.getCityName(), countryBean.getCountryName()); 
		
			vResult = ActionSupport.SUCCESS;
		
	    //(Si le nom du site est vide)
		}else if((spotBean.getSpotName().equals("")) && (!countryBean.getCityName().isEmpty()) && (!countryBean.getCountryName().isEmpty())){
			
			listSpot = managerFactory.getCountryManager().getCountry(countryBean.getCountryName(), countryBean.getCityName());
			LOGGER.debug(listSpot + "############");

			vResult = ActionSupport.SUCCESS;
		}
		
		//(Si les champs: nom du site et ville sont vide)
		else if((spotBean.getSpotName().equals("")) && (countryBean.getCityName().equals("")) && (!countryBean.getCountryName().isEmpty())) {

			listSpot = managerFactory.getSpotManager().getSpotCountry(countryBean.getCountryName());
			vResult = ActionSupport.SUCCESS;
		}
		
		//(Si les champs ville et pays sont vide) **
		else if((!spotBean.getSpotName().isEmpty()) && (countryBean.getCityName().equals("")) && (countryBean.getCountryName().equals(""))) {
			
			listSpot = managerFactory.getSpotManager().getSpot(spotBean.getSpotName());
			vResult = ActionSupport.SUCCESS;
		}
		testAffichage = true;
		return vResult;
	} 
	
}
