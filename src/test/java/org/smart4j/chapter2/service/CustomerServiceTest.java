package org.smart4j.chapter2.service;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.model.Customer;

/**
 * CustomerServiceTest.java
 * 2017年5月6日下午4:25:27
 * @author cbb
 * TODO
 */
public class CustomerServiceTest {

	@Before
	public void before(){
		//TODO 初始化数据库操作,向数据库表中插入指定的数据
	}
	
	@After
	public void after(){
		//TODO 断开数据库的链接
	}
	
	@Test
	public void getCustomerTest(){
		List<Customer> customers = CustomerServiceImpl.getInstance().getAllCustomer();
		Assert.assertEquals(4, customers.size());
	}
	
	@Test
	public void getCustomerByIdTest(){
		long id = 3;
		Customer customer = CustomerServiceImpl.getInstance().getCustomerByPrimKey(id);
		Assert.assertNotNull(customer);
	}
	  
	
	@Test
	public void createCustomerTest(){
		
	}
	
	@Test
	public void addCustomerTest(){
		Customer customer = new Customer();
		customer.setBusinessId(1);
		customer.setContact("zte"); 
		customer.setEmail("1110@gmail");
		customer.setName("bobo");
		customer.setRemark("mark");
		customer.setTelephone("88888888");
		int result = CustomerServiceImpl.getInstance().addCustomer(customer);
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void updateCustomerTest(){
//		Map<String, Object> customerFileds = new HashMap<String, Object>();
//		customerFileds.put("concat", "cbb");
//		customerFileds.put("email", "@163.com");
//		customerFileds.put("telephone", "7777777");
//		long id = 2;
//		int result = customerServiceImpl.updateCustomer(id, customerFileds);
		
	}
	
	@Test
	public void deleteCustomerTest(){
		long id = 1;
		int result = CustomerServiceImpl.getInstance().deleteCustomer(id);
	}
}
