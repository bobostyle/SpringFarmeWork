package org.smart4j.chapter2.service;

import java.util.List;
import org.smart4j.chapter2.model.Customer;

/**
 * CustomerService.java
 * 2017年5月6日下午4:15:33
 * @author cbb
 * TODO 服务层的服务类的接口
 */
public interface CustomerService {
	
	//获取客户列表
	public List<Customer> getAllCustomer();
	
	//根据Id 查询客户
	public Customer getCustomerByPrimKey(long id);
	
	//根据输入的条件来查询  (如果是模糊查询，比方说name like "zhang")
	public List<Customer> getCustomersByCondition(Customer customer);
	
	//查询多条记录 in语句
	public List<Customer> getMulitsCustomers(List<Long> ids);
	
	//添加客户
	public int addCustomer(Customer customer);
	
	//批量添加客户
	public int addMulitCustomers(List<Customer> customers);
	
	//更新客户 (返回更新的条数)
	public int updateCustomer(Customer customer);
	
	public int updateCustomers();
	
	//删除客户
	public int deleteCustomer(long id);
}
