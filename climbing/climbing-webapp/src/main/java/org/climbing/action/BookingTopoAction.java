package org.climbing.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.topo.BookingTopo;
import org.climbing.model.beans.topo.Topo;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class BookingTopoAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(BookingTopoAction.class);
	private Map<String, Object> session;
	private static final String USER = "user";
	
	@Autowired
	private ManagerFactory managerFactory;
	
	private ArrayList<BookingTopo> bookingTopoList;
	private BookingTopo bookingTopoBean;
	
	//*****
	private Topo topoBean;
	private Integer idTopo;
	//*****
	
	
	public String execute() {
		return SUCCESS;	
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
	
	
	public Topo getTopoBean() {
		return topoBean;
	}

	public void setTopoBean(Topo topoBean) {
		this.topoBean = topoBean;
	}

	public Integer getIdTopo() {
		return idTopo;
	}

	public void setIdTopo(Integer idTopo) {
		this.idTopo = idTopo;
	}
	
	public ArrayList<BookingTopo> getBookingTopoList() {
		return bookingTopoList;
	}

	public void setBookingTopoList(ArrayList<BookingTopo> bookingTopoList) {
		this.bookingTopoList = bookingTopoList;
	}

	public BookingTopo getBookingTopoBean() {
		return bookingTopoBean;
	}

	public void setBookingTopoBean(BookingTopo bookingTopoBean) {
		this.bookingTopoBean = bookingTopoBean;
	}

	public String bookingTopo() {
		String vResult = ActionSupport.INPUT;
		
		LOGGER.debug(bookingTopoBean + "date de retour et date de réservation");

		topoBean = managerFactory.getTopoManager().getTopo(idTopo);
		LOGGER.debug(topoBean.toString() + "Voici le topo à reserver");
		
		bookingTopoList = managerFactory.getBookingTopoManager().getBookingTopoInfo(idTopo);
		LOGGER.debug(bookingTopoList.toString() + "Voici les topo déjà commandé");
		
		if( (bookingTopoList.size() == 0) || (topoBean.getNbCopyMax() > bookingTopoList.size()) ){
			
			User userSession = (User) session.get("user"); 
			bookingTopoBean.setIdUser(userSession.getIdUser());
			
			bookingTopoBean.setIdTopo(idTopo);
			
			managerFactory.getBookingTopoManager().addBookingTopo(bookingTopoBean);	
			vResult = ActionSupport.SUCCESS;
		}
		
		else if(topoBean.getNbCopyMax() == bookingTopoList.size()) {
				
			addActionError("Indisponible !!");		
			LOGGER.debug("Indisponible");
			vResult = ActionSupport.SUCCESS;


		}
		return vResult;	
	}

}
