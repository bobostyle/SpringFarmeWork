package org.smart4j.chapter2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.model.Customer;

/**
 * CustomerServiceTest.java
 * 2017��5��6������4:25:27
 * @author cbb
 * TODO
 */
public class CustomerServiceTest {

	CustomerServiceImpl customerServiceImpl;
	@Before
	public void before(){
		//TODO ��ʼ�����ݿ����,�����ݿ���в���ָ��������
	}
	
	@After
	public void after(){
		//TODO �Ͽ����ݿ������
	}
	
	@Test
	public void getCustomerTest(){
		List<Customer> customers = CustomerServiceImpl.getInstance().getAllCustomer();
		Assert.assertEquals(2, customers.size());
	}
	
	@Test
	public void getCustomerByIdTest(){
		long id = 1;
		Customer customer = CustomerServiceImpl.getInstance().getCustomerByPrimKey(1);
		Assert.assertNotNull(customer);
	}
	
	@Test
	public void createCustomerTest(){
	}
	
//	@Test
//	public void updateCustomerTest(){
//		Map<String, Object> customerFileds = new HashMap<String, Object>();
//		customerFileds.put("concat", "cbb");
//		customerFileds.put("email", "@163.com");
//		customerFileds.put("telephone", "7777777");
//		long id = 2;
//		boolean result = customerServiceImpl.updateCustomer(id, customerFileds);
//		Assert.assertTrue(result);
//	}
//	
//	@Test
//	public void deleteCustomerTest(){
//		long id = 1;
//		boolean result = customerServiceImpl.deleteCustomer(id);
//		Assert.assertTrue(result);
//	}
}
