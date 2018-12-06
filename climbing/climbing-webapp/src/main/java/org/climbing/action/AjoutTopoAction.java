package org.climbing.action;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.topo.Topo;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutTopoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Topo topoBean;
	private Integer idSpot;
	
	@Autowired
	private ManagerFactory managerFactory;
	
	public String execute() {
		return SUCCESS;	
	}

	public Topo getTopoBean() {
		return topoBean;
	}

	public void setTopoBean(Topo topoBean) {
		this.topoBean = topoBean;
	}

	public Integer getIdSpot() {
		return idSpot;
	}

	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}
	
	public String doAddTopo() {
		String vResult = ActionSupport.INPUT;	
		//topoBean = managerFactory.getTopoManager().addTopo(topoBean);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}

}
