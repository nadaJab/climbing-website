package org.climbing.business.impl.manager.spot;

import javax.inject.Named;

import org.climbing.business.contract.manager.spot.SpotManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.spot.Spot;
import org.climbing.model.exception.NotFoundException;

@Named("spotManager")
public class SpotManagerImpl extends AbstractManagerImpl implements SpotManager {
	
}
