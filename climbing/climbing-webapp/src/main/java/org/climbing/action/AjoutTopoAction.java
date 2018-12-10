package org.climbing.action;
import java.util.Calendar;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.topo.Topo;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutTopoAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(AjoutTopoAction.class);

	private Topo topoBean;
	private Integer idSpot;
	
	private Map<String, Object> session;
	private static final String USER = "user";
	
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
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}

	public String doAddTopo() {
		String vResult = ActionSupport.INPUT;	

		topoBean.setPublished(Calendar.getInstance().getTime());
		LOGGER.debug(topoBean.getPublished() + "date d'ajout du topo");
		
		LOGGER.debug(((User) session.get(USER)).getIdUser());
		int idUser = ((User) session.get(USER)).getIdUser();
		
		topoBean = managerFactory.getTopoManager().addTopo(topoBean);
		managerFactory.getTopoManager().addJoinTopoSpot(topoBean.getIdTopo(), idSpot);
		managerFactory.getTopoManager().addJoinTopoUser(topoBean.getIdTopo(), idUser);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}


}
