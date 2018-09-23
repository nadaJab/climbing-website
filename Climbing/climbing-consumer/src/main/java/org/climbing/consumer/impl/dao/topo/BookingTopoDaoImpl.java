package org.climbing.consumer.impl.dao.topo;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.topo.BookingTopoDao;

import org.climbing.model.beans.topo.BookingTopo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("bookingTopoDao") 
public class BookingTopoDaoImpl extends AbstractDaoImpl implements BookingTopoDao  {
	
}
