package org.climbing.business.impl;

import javax.inject.Inject;
import javax.inject.Named;
import org.climbing.consumer.impl.DaoFactoryImpl;

public abstract class AbstractManagerImpl {
	
	@Inject
	//@Component("daoFactoryClimbing") spring
	@Named("daoFactoryClimbing")
	private static DaoFactoryImpl daoFactory;
	
	protected static DaoFactoryImpl getDaoFactory() {
		return daoFactory;
	}
	
	public static void setDaoFactory(DaoFactoryImpl daoFactory) {
		AbstractManagerImpl.daoFactory=daoFactory;
	}
}
