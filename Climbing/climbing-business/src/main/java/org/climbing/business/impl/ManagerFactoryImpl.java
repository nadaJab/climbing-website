package org.climbing.business.impl;

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

	
	public CommentManager getCommentManager() {
		return this.commentManager;
	}

	public void setCommentManager(CommentManager commentManager) {
		this.commentManager = commentManager;
	}

	public CommentSpotManager getCommentSpotManager() {
		return commentSpotManager;
	}

	public void setCommentSpotManager(CommentSpotManager commentSpotManager) {
		this.commentSpotManager = commentSpotManager;
	}

	public CommentTopoManager getCommentTopoManager() {
		return commentTopoManager;
	}

	public void setCommentTopoManager(CommentTopoManager commentTopoManager) {
		this.commentTopoManager = commentTopoManager;
	}
	//************	
	//****spot****
	//************
	private CountryManager countryManager;
	private RouteManager routeManager;
	private SectorManager sectorManager;
	private SpotManager spotManager;


	public CountryManager getCountryManager() {
		return countryManager;
	}

	public void setCountryManager(CountryManager countryManager) {
		this.countryManager = countryManager;
	}

	public RouteManager getRouteManager() {
		return routeManager;
	}

	public void setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
	}

	public SectorManager getSectorManager() {
		return sectorManager;
	}

	public void setSectorManager(SectorManager sectorManager) {
		this.sectorManager = sectorManager;
	}

	public SpotManager getSpotManager() {
		return spotManager;
	}

	public void setSpotManager(SpotManager spotManager) {
		this.spotManager = spotManager;
	}
	

	//***************
	//****topo****
	//***************
	private BookingTopoManager bookingTopoManager;
	private TopoManager topoManager;


	public BookingTopoManager getBookingTopoManager() {
		return bookingTopoManager;
	}

	public void setBookingTopoManager(BookingTopoManager bookingTopoManager) {
		this.bookingTopoManager = bookingTopoManager;
	}

	public TopoManager getTopoManager() {
		return topoManager;
	}

	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	}
	
	//***************
	//****user****
	//***************
	
	private AccountManager accountManager;
	private UserManager userManager;


	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	

}
