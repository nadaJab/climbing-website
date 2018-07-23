package org.climbing.business.impl;

import org.climbing.consumer.impl.DaoFactoryImpl;

public abstract class AbstractManagerImpl {

	private static DaoFactoryImpl daoFactory;
	
	protected static DaoFactoryImpl getDaoFactory() {
		return daoFactory;
	}
	
	public static void setDaoFactory(DaoFactoryImpl daoFactory) {
		AbstractManagerImpl.daoFactory=daoFactory;
	}
}
