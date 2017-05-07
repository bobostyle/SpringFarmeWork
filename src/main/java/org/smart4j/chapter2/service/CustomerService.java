package org.smart4j.chapter2.service;

import java.util.List;
import java.util.Map;

import org.smart4j.chapter2.model.Customer;

/**
 * CustomerService.java
 * 2017年5月6日下午4:15:33
 * @author cbb
 * TODO 服务层的服务类的接口
 */
public interface CustomerService {
	
	//获取客户列表
	public List<Customer> getCustomer();
	
	//根据Id 查询客户
	public Customer getCustomer(long id);
	
	//创建客户
	public boolean createCustomer(Map<String, Object> fieldMap);
	
	//更新客户
	public boolean updateCustomer(long id, Map<String, Object> filedMap);
	
	//删除客户
	public boolean deleteCustomer(long id);
	
}
