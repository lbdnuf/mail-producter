package com.bhz.mail.config.database;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.util.ClassLoaderRepository.SoftHashMap;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 配置mybatis
 * 1.必须要加@Configuration
 * 2.@AutoConfigureAfter(配置Configguration前一定要先把数据源配置好)
 * @author Administrator
 *
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfigguration extends MybatisAutoConfiguration{

	@Resource
	private DataSource masterDataSource;
	
	@Resource
	private DataSource slaveDataSource;
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		
		
		return super.sqlSessionFactory(roundRobDataSourceProxy());
	}
	public AbstractRoutingDataSource roundRobDataSourceProxy() {
		ReadWriteSplitRoutingDataSource	proxy = new ReadWriteSplitRoutingDataSource();
		
		//SoftHashMap targetDataSource = new ClassLoaderRepository.SoftHashMap();
		SoftHashMap targetDataSource = new SoftHashMap();
		targetDataSource.put(DataBaseContextHolder.DataBaseType.MASTER, masterDataSource);
		targetDataSource.put(DataBaseContextHolder.DataBaseType.SLAVE, slaveDataSource);
		//默认数据源
		proxy.setDefaultTargetDataSource(masterDataSource);
		//装入主从数据源
		proxy.setTargetDataSources(targetDataSource);
		return proxy;
	}
}
