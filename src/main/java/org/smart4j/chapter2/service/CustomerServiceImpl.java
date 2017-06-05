package org.smart4j.chapter2.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.dao.CustomerMapper;
import org.smart4j.chapter2.service.dao.SqlSessionBuilderManager;

/**
 * CustomerService.java
 * 2017��5��6������4:14:18
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
		}catch(Exception e){
			System.out.println(e.getMessage()); 
		}
		finally{
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
			customer = customerMapper.selectCustomerById(id);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession); //һ��Ҫ�ر�sqlsession
		}
		return customer;
	}

	@Override
	public List<Customer> getMulitsCustomers(List<Long> ids) {
		SqlSession sqlSession = null;
		List<Customer> customers = null;
		try{
			sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			customers = customerMapper.selectCustomers(ids);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return customers;
	}
	
	//����Ǽ�������Ҫ�޸ģ����븸����ӱ�ṹ
	@Override
	public int addCustomer(Customer customer) {
		int result = 0;
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper= sqlSession.getMapper(CustomerMapper.class);
			result = customerMapper.insertCustomer(customer);
			SqlSessionBuilderManager.getInstance().commit(sqlSession);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			SqlSessionBuilderManager.getInstance().rollBack(sqlSession);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return result;
	}
	
	@Override
	public int addMulitCustomers(List<Customer> customers) {
		int result = 0;
		for(int i = 0; i < customers.size(); i++){
			addCustomer(customers.get(i));
			result++;
		}
		return result;
	}
	
	//�������id����Ҫ�޸ĺ���ֶΡ�id��ǰ̨��������,��ʱ��ѡ��ĳ����¼�ͻ��¼��Ӧ��id
	@Override 
	public int updateCustomer(Customer customer) {
		int result = 0;
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			result = customerMapper.updateCustomer(customer);
			SqlSessionBuilderManager.getInstance().commit(sqlSession);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			SqlSessionBuilderManager.getInstance().rollBack(sqlSession);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return result;
	}

	@Override
	public int deleteCustomer(long id) {
		int result = 0;
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			result = customerMapper.deleteCustomerById(id);
			SqlSessionBuilderManager.getInstance().commit(sqlSession);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			SqlSessionBuilderManager.getInstance().rollBack(sqlSession);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return result;
	}
	
	@Override
	public int updateCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public List<Customer> getCustomersByCondition(Customer customer) {
		List<Customer> customers = new ArrayList<Customer>();
 		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			customers = customerMapper.selectCustomerBySomeCondition(customer);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			SqlSessionBuilderManager.getInstance().rollBack(sqlSession);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return customers;
	}
}
