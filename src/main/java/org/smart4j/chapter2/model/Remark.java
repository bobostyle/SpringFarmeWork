package org.smart4j.chapter2.model;

 /**
 * Remark.java
 * 2017��5��20������4:16:56
 * @author cbb
 * TODO  Customer���е�remark���ԣ���json��ʾ������ת��javabean����
 */
public class Remark {
	
	private String company;
	
	private int age;
	
	private String description;

	
	public String getCompany() {
		return company;
	}

	
	public void setCompany(String company) {
		this.company = company;
	}

	
	public int getAge() {
		return age;
	}

	
	public void setAge(int age) {
		this.age = age;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Remark [company=" + company + ", age=" + age + ", description=" + description + "]";
	}
}
