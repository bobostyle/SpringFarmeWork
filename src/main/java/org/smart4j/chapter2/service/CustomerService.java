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
	public List<Customer> getAllCustomer();
	
	//根据Id 查询客户
	public Customer getCustomerByPrimKey(long id);
	
	//添加客户
	public int addCustomer();
	
	//更新客户 (返回更新的条数)
	public int updateCustomer(long id, Map<String, Object> filedMap);
	
	//删除客户
	public int deleteCustomer(long id);
	
	//如何实现批量更新，参数怎么传入
	public int updateCustomers();
}
