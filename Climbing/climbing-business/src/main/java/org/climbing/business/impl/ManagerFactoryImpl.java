package org.climbing.business.impl;

import javax.inject.Inject;

import org.climbing.business.contract.ManagerFactory;

import org.climbing.business.contract.manager.comment.*;
import org.climbing.business.contract.manager.spot.*;
import org.climbing.business.contract.manager.topo.*;
import org.climbing.business.contract.manager.user.*;


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
	
    @Inject
	public void setCommentManager(CommentManager commentManager) {
		this.commentManager = commentManager;
	}

	public CommentSpotManager getCommentSpotManager() {
		return commentSpotManager;
	}
	
    @Inject
	public void setCommentSpotManager(CommentSpotManager commentSpotManager) {
		this.commentSpotManager = commentSpotManager;
	}

	public CommentTopoManager getCommentTopoManager() {
		return commentTopoManager;
	}
	
    @Inject
	public void setCommentTopoManager(CommentTopoManager commentTopoManager) {
		this.commentTopoManager = commentTopoManager;
	}
	
	
	//****spot****
	public CountryManager getCountryManager() {
		return countryManager;
	}
	
    @Inject
	public void setCountryManager(CountryManager countryManager) {
		this.countryManager = countryManager;
	}

	public RouteManager getRouteManager() {
		return routeManager;
	}
	
    @Inject
	public void setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
	}

	public SectorManager getSectorManager() {
		return sectorManager;
	}
	
    @Inject
	public void setSectorManager(SectorManager sectorManager) {
		this.sectorManager = sectorManager;
	}

	public SpotManager getSpotManager() {
		return spotManager;
	}
	
    @Inject
	public void setSpotManager(SpotManager spotManager) {
		this.spotManager = spotManager;
	}
	
	
	//****topo****
	public BookingTopoManager getBookingTopoManager() {
		return bookingTopoManager;
	}
	
    @Inject
	public void setBookingTopoManager(BookingTopoManager bookingTopoManager) {
		this.bookingTopoManager = bookingTopoManager;
	}

	public TopoManager getTopoManager() {
		return topoManager;
	}
	
    @Inject
	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	}
	

	public AccountManager getAccountManager() {
		return accountManager;
	}
	
    @Inject
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}
	
    @Inject
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}
