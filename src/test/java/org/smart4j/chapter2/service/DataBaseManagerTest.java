package org.smart4j.chapter2.service;

import org.junit.Test;
import org.smart4j.chapter2.service.dao.DataBaseManager;

/**
 * DataBaseManagerTest.java
 * 2017��5��22������12:02:10       
 * @author cbb
 * TODO
 */
public class DataBaseManagerTest {
	
	@Test
	public void test_Data_Base_inital(){
 		DataBaseManager.getInstance().initalSchemal();
	}
}
