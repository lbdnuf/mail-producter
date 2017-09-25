package com.bhz.mail;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bhz.mail.entity.MstDict;

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
		System.err.println("masterDataSource"+connection1.getMetaData().getURL());
		Connection connection2 = slaveDataSource.getConnection("root", "root");
		System.err.println("slaveDataSource"+connection2.getMetaData().getURL());
		
	}
//	@Autowired
//	private MstDictMapper mstDictMapper;
//	
//	@Test
//	public void test1() throws Exception{
//		List<MstDict> MstDictList = new ArrayList<MstDict>();
//		
//		MstDictList = mstDictMapper.selectAll();
//		
//		System.out.println(MstDictList.size());
//		
//	}

}
