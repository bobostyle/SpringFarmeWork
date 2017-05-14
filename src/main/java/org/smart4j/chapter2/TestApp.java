package org.smart4j.chapter2;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerServiceImpl;
import org.smart4j.chapter2.service.dao.CustomerMapper;
import org.smart4j.chapter2.service.dao.SqlSessionBuilderManager;

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
		Customer customer1 = CustomerServiceImpl.getInstance().getCustomerByPrimKey(1);
		System.out.println(customer1.toString());
		Customer customer2 = CustomerServiceImpl.getInstance().getCustomerByPrimKey(2);
		System.out.println(customer2.toString());
		
		List<Customer> customers = new ArrayList<Customer>();
		customers = CustomerServiceImpl.getInstance().getAllCustomer();
		System.out.println(customers.size());
	}
}
