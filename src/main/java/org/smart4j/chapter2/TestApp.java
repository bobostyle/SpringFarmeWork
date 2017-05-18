package org.smart4j.chapter2;

import java.util.List;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerServiceImpl;

/**
 * Client.java
 * 2017年5月10日下午11:42:26
 * @author cbb
 * TODO
 */
public class TestApp {
	
	//使用try/finally块对session进行控制。
	//所有的dao层api都需要这种结构，特别不好看，把mybatis框架使用的像原生态的jdbc.
	//所以决定使用动态代理，进行模板化，对insert 、update等名称的方法进行拦截。加上before()和
	//after()方法。
	public static void main(String[] args) {
		
//		List<Customer> customers = new ArrayList<Customer>();
// 		Customer customer1 = new Customer();
//		customer1.setContact("zhang");
//		customer1.setName("wang");
//		customer1.setEmail("@gmail");
//		customer1.setRemark("good");
//		customer1.setTelephone("1");
//		
//		Customer customer2 = new Customer();
//		customer2.setContact("san");
//		customer2.setName("er");
//		customer2.setEmail("@gmail");
//		customer2.setRemark("bad");
//		customer2.setTelephone("2");
//		
//		customers.add(customer1);
//		customers.add(customer2);
//		
//		int result = CustomerServiceImpl.getInstance().addMulitCustomers(customers);
		
//		Customer customer1 = CustomerServiceImpl.getInstance().getCustomerByPrimKey(1);
//		System.out.println(customer1.toString());
//		Customer customer2 = CustomerServiceImpl.getInstance().getCustomerByPrimKey(5);
//		System.out.println(customer2.toString());
//		
//		List<Customer> allCustomers = new ArrayList<Customer>();
//		allCustomers = CustomerServiceImpl.getInstance().getAllCustomer();
//		System.out.println(allCustomers.size());
//		System.out.println(CustomerServiceImpl.getInstance().deleteCustomer(1));
//		
//		Customer customer5 = CustomerServiceImpl.getInstance().getCustomerByPrimKey(2);
//		System.out.println(customer5.toString());
		
//		Customer updateCustomer = new Customer();
//		updateCustomer.setId(32);
//		updateCustomer.setEmail("1183280736@qq.com");
//		int result = CustomerServiceImpl.getInstance().updateCustomer(updateCustomer);
		
		Customer selcetCustomerByCondition = new Customer();
		selcetCustomerByCondition.setContact("zhang");
		selcetCustomerByCondition.setEmail("@%");
		List<Customer> customers = CustomerServiceImpl.getInstance().getCustomersByCondition(selcetCustomerByCondition);
		System.out.println(customers.toString());
	}
}
