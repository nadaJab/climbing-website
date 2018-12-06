package org.climbing.business.impl.manager.topo;

import org.climbing.business.contract.manager.topo.BookingTopoManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.topo.BookingTopo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("bookingTopoManager")
public class BookingTopoManagerImpl extends AbstractManagerImpl implements BookingTopoManager {
}
