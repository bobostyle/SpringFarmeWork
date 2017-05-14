package org.smart4j.chapter2.service;

import java.util.List;
import java.util.Map;

import org.smart4j.chapter2.model.Customer;

/**
 * CustomerService.java
 * 2017��5��6������4:15:33
 * @author cbb
 * TODO �����ķ�����Ľӿ�
 */
public interface CustomerService {
	
	//��ȡ�ͻ��б�
	public List<Customer> getAllCustomer();
	
	//����Id ��ѯ�ͻ�
	public Customer getCustomerByPrimKey(long id);
	
	//��ӿͻ�
	public int addCustomer();
	
	//���¿ͻ� (���ظ��µ�����)
	public int updateCustomer(long id, Map<String, Object> filedMap);
	
	//ɾ���ͻ�
	public int deleteCustomer(long id);
	
	//���ʵ���������£�������ô����
	public int updateCustomers();
}
