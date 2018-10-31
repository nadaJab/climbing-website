package org.climbing.business.impl;

import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

import org.climbing.business.contract.ManagerFactory;
import org.climbing.business.contract.manager.comment.*;
import org.climbing.business.contract.manager.spot.*;
import org.climbing.business.contract.manager.topo.*;
import org.climbing.business.contract.manager.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory{
	
	private static final Logger LOGGER = LogManager.getRootLogger();

	public ManagerFactoryImpl() {
	LOGGER.info("coucou");
	}
	//***************	
	//****comment****
	//***************
	//@Autowired
	private CommentManager commentManager;
	public CommentManager getCommentManager() {
		return this.commentManager;
	}
	public void setCommentManager(CommentManager commentManager) {
		this.commentManager = commentManager;
	}
	
	//@Autowired
	private CommentSpotManager commentSpotManager;
	public CommentSpotManager getCommentSpotManager() {
		return commentSpotManager;
	}
	public void setCommentSpotManager(CommentSpotManager commentSpotManager) {
		this.commentSpotManager = commentSpotManager;
	}
	
	//@Autowired
	private CommentTopoManager commentTopoManager;
	public CommentTopoManager getCommentTopoManager() {
		return commentTopoManager;
	}
	public void setCommentTopoManager(CommentTopoManager commentTopoManager) {
		this.commentTopoManager = commentTopoManager;
	} 
	
	//************	
	//****spot****
	//************
	
	//@Autowired
	private CountryManager countryManager;
	public CountryManager getCountryManager() {
		return countryManager;
	}	
	public void setCountryManager(CountryManager countryManager) {
		this.countryManager = countryManager;
	}
	
	//@Autowired
	private RouteManager routeManager;
	public RouteManager getRouteManager() {
		return routeManager;
	}
	public void setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
	}
	
	//@Autowired
	private SectorManager sectorManager;
	public SectorManager getSectorManager() {
		return sectorManager;
	}
	public void setSectorManager(SectorManager sectorManager) {
		this.sectorManager = sectorManager;
	}

	//@Autowired
	private SpotManager spotManager;
	public SpotManager getSpotManager() {
		return spotManager;
	}
	public void setSpotManager(SpotManager spotManager) {
		this.spotManager = spotManager;
	}
	
	//***************
	//****topo****
	//***************
	//@Autowired
	private BookingTopoManager bookingTopoManager;
	public BookingTopoManager getBookingTopoManager() {
		return bookingTopoManager;
	}
	public void setBookingTopoManager(BookingTopoManager bookingTopoManager) {
		this.bookingTopoManager = bookingTopoManager;
	}
	
	//@Autowired
	private TopoManager topoManager;
	public TopoManager getTopoManager() {
		return topoManager;
	}
	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	} 
	
	//***************
	//****user****
	//***************	
	@Autowired
	private AccountManager accountManager;
	
	public AccountManager getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	
	@Autowired
	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}
