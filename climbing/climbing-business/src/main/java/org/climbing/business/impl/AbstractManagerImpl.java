package org.climbing.business.impl;

import javax.inject.Named;

import org.climbing.consumer.impl.DaoFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManagerImpl {
	
	@Autowired
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
