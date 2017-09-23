package com.bhz.mail;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Resource(name="masterDataSource")
	private DataSource masterDataSource;
	
	@Resource(name="slaveDataSource")
	private DataSource slaveDataSource;
	
	@Test
	public void contextLoads() throws Exception{
		
		
		Connection connection1 = masterDataSource.getConnection("root", "root");
		System.out.println("masterDataSource"+connection1.getMetaData().getURL());
		Connection connection2 = slaveDataSource.getConnection("root", "root");
		System.out.println("slaveDataSource"+connection2.getMetaData().getURL());
		
	}

}
