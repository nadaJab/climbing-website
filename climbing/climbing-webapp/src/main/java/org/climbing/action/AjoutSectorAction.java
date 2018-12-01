package org.climbing.action;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.spot.Sector;
import org.climbing.model.beans.spot.Spot;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutSectorAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sector sectorBean;
	private Integer idSpot;
	private Spot spotBean;

	private static final Logger LOGGER = LogManager.getLogger(HomeAction.class);
	//private Map<String, Object> session;

	@Autowired
	private ManagerFactory managerFactory;
	
	public String execute() {
		return SUCCESS;	
	}
	
	public Sector getSectorBean() {
		return sectorBean;
	}

	public void setSectorBean(Sector sectorBean) {
		this.sectorBean = sectorBean;
	}
	
	public Integer getIdSpot() {
		return idSpot;
	}

	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}
	
	/*
	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}*/

	public Spot getSpotBean() {
		return spotBean;
	}

	public void setSpotBean(Spot spotBean) {
		this.spotBean = spotBean;
	}

	public String doAddSector() {
		String vResult = ActionSupport.INPUT;

		LOGGER.debug(idSpot + "==");
		sectorBean = managerFactory.getSectorManager().addSector(sectorBean);
		
	    vResult = ActionSupport.SUCCESS;
		return vResult;
	}
}
