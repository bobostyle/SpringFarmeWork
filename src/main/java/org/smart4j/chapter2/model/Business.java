package org.smart4j.chapter2.model;

import java.util.List;

/**
 * Business.java
 * 2017��5��13������10:46:38
 * @author cbb
 * TODO �̼Һ͹˿͡�һ���̼Ҷ�Ӧ����˿ͣ�һ���˿Ͷ�Ӧһ���̼��̼Һ͹˿���һ�Զ�Ĺ�ϵ
 */
public class Business {
	
	private long id;
	private String name;
	private String address;
	private List<Customer> customers;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}
	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Business [id=" + id + ", name=" + name + ", address=" + address + ", customers=" + customers + "]";
	}
}
