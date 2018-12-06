package org.climbing.business.impl.manager.topo;

import org.climbing.business.contract.manager.topo.TopoManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.topo.Topo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("topoManager")
public class TopoManagerImpl extends AbstractManagerImpl implements TopoManager {
}
