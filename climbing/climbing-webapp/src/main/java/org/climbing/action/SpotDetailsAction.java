package org.climbing.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.spot.Sector;
import org.climbing.model.beans.spot.Spot;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class SpotDetailsAction extends ActionSupport  implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(SpotDetailsAction.class);
	
	private Spot spotBean;
	private Integer idSpot;
	private Sector sectorBean;
	private ArrayList<Sector> sectors;
	private Map<String, Object> spotDetails;
	private static final String SPOT = "spot";

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

	public Integer getIdSpot() {
		return idSpot;
	}

	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}
	
	public ArrayList<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(ArrayList<Sector> sectors) {
		this.sectors = sectors;
	}
	
	public Sector getSectorBean() {
		return sectorBean;
	}

	public void setSectorBean(Sector sectorBean) {
		this.sectorBean = sectorBean;
	}
	
	@Override
	public void setSession(Map<String, Object> spotDetails) {
		this.spotDetails = spotDetails;	
	}

	public String searchSpotDetails() {
		String vResult = ActionSupport.INPUT;
		
		spotBean = managerFactory.getSpotManager().getSpotId(idSpot);
		sectors = managerFactory.getSectorManager().getAllSectors(idSpot);
		LOGGER.debug(spotBean.toString() + "§§§§§");
		this.spotDetails.put(SPOT, spotBean);
		
		vResult = ActionSupport.SUCCESS;	

		return vResult;
	}
/*
	public String getAllSector() {
		String vResult = ActionSupport.INPUT;
		LOGGER.debug(idSpot + "'''''");
		sectors = managerFactory.getSectorManager().getAllSectors(idSpot);
		vResult = ActionSupport.SUCCESS;	

		return vResult;

	}*/

}
