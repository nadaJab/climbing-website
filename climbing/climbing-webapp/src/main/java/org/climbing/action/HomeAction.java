package org.climbing.action;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.spot.Country;
import org.climbing.model.beans.spot.Sector;
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
	private ArrayList<Sector> listSector;
	private boolean testVar = false;
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
	
	public ArrayList<Spot> getListSpot() {
		return listSpot;
	}

	public void setListSpot(ArrayList<Spot> listSpot) {
		this.listSpot = listSpot;
	}

	public ArrayList<Sector> getListSector() {
		return listSector;
	}

	public void setListSector(ArrayList<Sector> listSector) {
		this.listSector = listSector;
	}
	
	public boolean isTestVar() {
		return testVar;
	}

	public void setTestVar(boolean testVar) {
		this.testVar = testVar;
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
			countryBean = managerFactory.getCountryManager().getCountry(countryBean.getCountryName(), countryBean.getCityName());
			LOGGER.debug(countryBean.toString() + "coucou");
			spotBean = managerFactory.getSpotManager().getSpot(spotBean.getSpotName(), countryBean.getIdCityCountry()); 
		
			vResult = ActionSupport.SUCCESS;
		
	    //(Si le du nom du site est vide)
		}else if((spotBean.getSpotName().equals("")) && (!countryBean.getCityName().isEmpty()) && (!countryBean.getCountryName().isEmpty())){
			
			countryBean = managerFactory.getCountryManager().getCountry(countryBean.getCountryName(), countryBean.getCityName());
			LOGGER.debug(countryBean.getIdCityCountry() + "############");

			listSpot = managerFactory.getSpotManager().getSpot(countryBean.getIdCityCountry()); 
			
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
		
		return vResult;
	}
	
	public String searchSpotDetails(int id) {
		
		spotBean = listSpot.get(id+1);
		
		return ActionSupport.SUCCESS;	
	}
	
}
