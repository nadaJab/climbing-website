package org.climbing.consumer.contract;

import org.climbing.consumer.contract.dao.comment.*;
import org.climbing.consumer.contract.dao.spot.*;
import org.climbing.consumer.contract.dao.topo.*;
import org.climbing.consumer.contract.dao.user.*;

public interface DaoFactory {
	
	CommentDao getCommentDao(); 
 	CommentTopoDao getCommentTopoDao();
 	CommentSpotDao getCommentSpotDao();
 	

    SpotDao getSpotDao(); 
    SectorDao getSectorDao();
    RouteDao getRouteDao();
    CountryDao getCountryDao();
    
    
    TopoDao getTopoDao(); 
    BookingTopoDao getBookingTopoDao();
    
    UserDao getUserDao(); 
    AccountDao getAccountDao();

}
