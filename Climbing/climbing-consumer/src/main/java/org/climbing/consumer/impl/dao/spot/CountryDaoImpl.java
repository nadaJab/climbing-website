package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.spot.CountryDao;

import org.climbing.model.beans.spot.Country;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("countryDao") 
public class CountryDaoImpl extends AbstractDaoImpl implements CountryDao  {
	
}
