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
	public int addCustomer(Customer customer);
	
	//������ӿͻ�
	public int addMulitCustomers(List<Customer> customers);
	
	//���¿ͻ� (���ظ��µ�����)
	public int updateCustomer(Customer customer);
	
	//ɾ���ͻ�
	public int deleteCustomer(long id);
	
	//���ʵ���������£�������ô����
	public int updateCustomers();
	
	//�����������������ѯ  (�����ģ����ѯ���ȷ�˵name like "zhang")
	public List<Customer> getCustomersByCondition(Customer customer);
		
}
