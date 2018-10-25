package org.climbing.business.contract;

import org.climbing.business.contract.manager.comment.*;
import org.climbing.business.contract.manager.spot.*;
import org.climbing.business.contract.manager.topo.*;
import org.climbing.business.contract.manager.user.*;

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

