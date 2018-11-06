package org.climbing.business.impl;

import javax.inject.Inject;
import javax.inject.Named;
import org.climbing.consumer.impl.DaoFactoryImpl;

public abstract class AbstractManagerImpl {
	
	@Inject
	//@Component("daoFactoryClimbing") spring
	@Named("daoFactory")
	protected DaoFactoryImpl daoFactory;
	
	protected DaoFactoryImpl getDaoFactory() {
		return daoFactory;
	}
	
	public void setDaoFactory(DaoFactoryImpl daoFactory) {
		this.daoFactory=daoFactory;
	}
}
