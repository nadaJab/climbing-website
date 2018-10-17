package org.climbing.consumer.impl;

import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

public abstract class AbstractDaoImpl {
	
	@Autowired
	//@Component("dataSourceClimbing")
	@Named("dataSourceClimbing")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}