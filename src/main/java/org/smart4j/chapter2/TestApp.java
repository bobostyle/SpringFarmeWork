package org.smart4j.chapter2;

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
