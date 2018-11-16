package org.climbing.action;
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

	public String doAddSector() {
		String vResult = ActionSupport.INPUT;
		
		sectorBean = managerFactory.getSectorManager().addSector(sectorBean);
		
	    vResult = ActionSupport.SUCCESS;
		return vResult;
	}
}
