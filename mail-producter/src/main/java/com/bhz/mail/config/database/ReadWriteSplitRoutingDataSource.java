package com.bhz.mail.config.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 继承spring的AbstractRoutingDataSource路由功能
 * @author Administrator
 *
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DataBaseContextHolder.getDataBaseType();
	}

	
}
