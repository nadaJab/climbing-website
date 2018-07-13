package org.climbing.business.contract;

import org.climbing.business.contract.manager.Comment.*;
import org.climbing.business.contract.manager.Spot.*;
import org.climbing.business.contract.manager.Topo.*;
import org.climbing.business.contract.manager.User.*;

	/**
	 * Factory des Managers
	 */
	public interface ManagerFactory {

		 	CommentManager getCommentManager(); 
		 	CommentTopoManager getCommentTopoManager();
		 	CommentSpotManager getCommentSpotManager();
		 	

		    SpotManager getSpotManager(); 
		    SectorManager getSectorManager();
		    RouteManager getRouteManager();
		    CountryManager getCountryManager();
		    
		    
		    TopoManager getTopoManager(); 
		    BookingTopoManager getBookingTopoManager();
		    
		    UserManager getUserManager(); 
		    AccountManager getAccountManager();
		    
		    
	}

