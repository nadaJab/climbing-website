package org.climbing.consumer.impl.dao;


import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public class AbstractDaoImpl {

	
	@Inject
	@Named("DataSourceClimbing")
	private static DataSource dataSource;
	
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	public static void setDataSource(DataSource dataSource) {
        AbstractDaoImpl.dataSource = dataSource;
    }
}
