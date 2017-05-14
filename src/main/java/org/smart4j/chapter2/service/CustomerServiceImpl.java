package org.smart4j.chapter2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.dao.CustomerMapper;
import org.smart4j.chapter2.service.dao.SqlSessionBuilderManager;

/**
 * CustomerService.java
 * 2017年5月6日下午4:14:18
 * @author cbb
 * TODO 
 */  
public class CustomerServiceImpl implements CustomerService{
		
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl(){
	}
	public static CustomerServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customer = new ArrayList<Customer>();
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			customer = customerMapper.selectAllCustomer();
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return customer;
	}

	@Override
	public Customer getCustomerByPrimKey(long id) {
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		Customer customer = null;
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			customer = customerMapper.selectCustomerByIdAnnotation(id);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession); //一定要关闭sqlsession
		}
		return customer;
	}

	
	@Override
	public int addCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int updateCustomer(long id, Map<String, Object> filedMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(long id) {
		// TODO Auto-generated method stub
		return 1;
	}
	/* (non-Javadoc)
	 * @see org.smart4j.chapter2.service.CustomerService#updateCustomers()
	 */
	@Override
	public int updateCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
