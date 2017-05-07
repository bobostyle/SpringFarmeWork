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
	public List<Customer> getCustomer();
	
	//����Id ��ѯ�ͻ�
	public Customer getCustomer(long id);
	
	//�����ͻ�
	public boolean createCustomer(Map<String, Object> fieldMap);
	
	//���¿ͻ�
	public boolean updateCustomer(long id, Map<String, Object> filedMap);
	
	//ɾ���ͻ�
	public boolean deleteCustomer(long id);
	
}
