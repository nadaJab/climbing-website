package org.climbing.business.impl.manager.spot;

import javax.inject.Named;

import org.climbing.business.contract.manager.spot.CountryManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.spot.Country;
import org.climbing.model.exception.NotFoundException;

@Named("countryManager")
public class CountryManagerImpl extends AbstractManagerImpl implements CountryManager {

}
