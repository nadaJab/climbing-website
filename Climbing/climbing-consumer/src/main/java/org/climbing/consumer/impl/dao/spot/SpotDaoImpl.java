package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.spot.SpotDao;

import org.climbing.model.beans.spot.Spot;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("spotDao") 
public class SpotDaoImpl extends AbstractDaoImpl implements SpotDao  {
}
