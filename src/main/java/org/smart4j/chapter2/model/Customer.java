package org.smart4j.chapter2.model;

 /**
 * Customer.java
 * 2017��5��6������3:22:21
 * @author cbb
 * TODO �ͻ�Bean
 */
public class Customer {
	
	//ID
	private long id;
	
	//��Ӧ�̼ҵ�ID
	private long businessId;
	
	//�ͻ�����
	private String name;
	
	//�ͻ���ϵ��
	private String contact;
	
	//�绰����
	private String telephone;
	
	//�����ַ
	private String email;
	
	//��ע
	private String remark;
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
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * @return the businessId
	 */
	public long getBusinessId() {
		return businessId;
	}
	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", businessId=" + businessId + ", name=" + name + ", contact=" + contact
				+ ", telephone=" + telephone + ", email=" + email + ", remark=" + remark + "]";
	}
}
