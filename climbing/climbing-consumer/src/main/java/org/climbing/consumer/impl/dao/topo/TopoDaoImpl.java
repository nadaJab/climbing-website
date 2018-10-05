package org.climbing.consumer.impl.dao.topo;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.topo.TopoDao;

import org.climbing.model.beans.topo.Topo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("topoDao") 
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao  {
}
