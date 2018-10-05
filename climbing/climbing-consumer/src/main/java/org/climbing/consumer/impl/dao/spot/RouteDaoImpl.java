package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.spot.RouteDao;

import org.climbing.model.beans.spot.Route;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("routeDao") 
public class RouteDaoImpl extends AbstractDaoImpl implements RouteDao  {
}
