package org.climbing.consumer.impl.dao.spot;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.spot.SectorDao;

import org.climbing.model.beans.spot.Sector;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("sectorDao") 
public class SectorDaoImpl extends AbstractDaoImpl implements SectorDao  {
}
