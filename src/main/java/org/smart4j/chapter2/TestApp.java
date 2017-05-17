package org.smart4j.chapter2;

import java.util.ArrayList;
import java.util.List;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerServiceImpl;

/**
 * Client.java
 * 2017��5��10������11:42:26
 * @author cbb
 * TODO
 */
public class TestApp {
	
	//ʹ��try/finally���session���п��ơ�
	//���е�dao��api����Ҫ���ֽṹ���ر𲻺ÿ�����mybatis���ʹ�õ���ԭ��̬��jdbc.
	//���Ծ���ʹ�ö�̬��������ģ�廯����insert ��update�����Ƶķ����������ء�����before()��
	//after()������
	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setContact("zhang");
		customer.setName("wang");
		customer.setEmail("@gmail");
		customer.setRemark("good");
		customer.setTelephone("1");
		System.out.println(CustomerServiceImpl.getInstance().addCustomer(customer));
		
		Customer customer1 = CustomerServiceImpl.getInstance().getCustomerByPrimKey(1);
		System.out.println(customer1.toString());
		Customer customer2 = CustomerServiceImpl.getInstance().getCustomerByPrimKey(5);
		System.out.println(customer2.toString());
		
		List<Customer> customers = new ArrayList<Customer>();
		customers = CustomerServiceImpl.getInstance().getAllCustomer();
		System.out.println(customers.size());
	}
}
