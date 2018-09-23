package org.climbing.business.impl;

import org.climbing.business.contract.ManagerFactory;
import org.climbing.business.contract.manager.comment.*;
import org.climbing.business.contract.manager.spot.*;
import org.climbing.business.contract.manager.topo.*;
import org.climbing.business.contract.manager.user.*;

import org.springframework.beans.factory.annotation.Autowired;


public class ManagerFactoryImpl implements ManagerFactory{

	//***************
	//****comment****
	//***************
	private CommentManager commentManager;
	private CommentSpotManager commentSpotManager;
	private CommentTopoManager commentTopoManager;

	//************	
	//****spot****
	//************
	private CountryManager countryManager;
	private RouteManager routeManager;
	private SectorManager sectorManager;
	private SpotManager spotManager;
	
	//***************
	//****topo****
	//***************
	private BookingTopoManager bookingTopoManager;
	private TopoManager topoManager;
	
	//***************
	//****user****
	//***************	
	private AccountManager accountManager;
	private UserManager userManager;

	
	//****comment****
	public CommentManager getCommentManager() {
		return this.commentManager;
	}
	
	@Autowired
	public void setCommentManager(CommentManager commentManager) {
		this.commentManager = commentManager;
	}

	public CommentSpotManager getCommentSpotManager() {
		return commentSpotManager;
	}
	
	@Autowired
	public void setCommentSpotManager(CommentSpotManager commentSpotManager) {
		this.commentSpotManager = commentSpotManager;
	}

	public CommentTopoManager getCommentTopoManager() {
		return commentTopoManager;
	}
	
	@Autowired
	public void setCommentTopoManager(CommentTopoManager commentTopoManager) {
		this.commentTopoManager = commentTopoManager;
	}
	
	
	//****spot****
	public CountryManager getCountryManager() {
		return countryManager;
	}
	
	@Autowired
	public void setCountryManager(CountryManager countryManager) {
		this.countryManager = countryManager;
	}

	public RouteManager getRouteManager() {
		return routeManager;
	}
	
	@Autowired
	public void setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
	}

	public SectorManager getSectorManager() {
		return sectorManager;
	}
	
	@Autowired
	public void setSectorManager(SectorManager sectorManager) {
		this.sectorManager = sectorManager;
	}

	public SpotManager getSpotManager() {
		return spotManager;
	}
	
	@Autowired
	public void setSpotManager(SpotManager spotManager) {
		this.spotManager = spotManager;
	}
	
	
	//****topo****
	public BookingTopoManager getBookingTopoManager() {
		return bookingTopoManager;
	}
	
	@Autowired
	public void setBookingTopoManager(BookingTopoManager bookingTopoManager) {
		this.bookingTopoManager = bookingTopoManager;
	}

	public TopoManager getTopoManager() {
		return topoManager;
	}
	
	@Autowired
	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	}
	

	public AccountManager getAccountManager() {
		return accountManager;
	}
	
	@Autowired
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}
	
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}
