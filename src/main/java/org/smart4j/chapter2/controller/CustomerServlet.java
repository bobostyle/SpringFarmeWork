package org.smart4j.chapter2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerServiceImpl;

/**
 * CustomerServlet.java
 * 2017��5��6������3:47:23
 * @author cbb
 * TODO 
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//��ȡ��Դ
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse reps) throws ServletException, IOException{
		List<Customer> customerList = CustomerServiceImpl.getInstance().getAllCustomer();
		System.out.println(customerList.size());
		req.setAttribute("customerList", customerList);
		req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, reps);
	}
		
	//������Դ
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse reps){
		//TODO
	}
		
	//�޸���Դ
	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse reps){
		//TODO
	}
		
	//ɾ����Դ
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse reps){
		//TODO
	}
}
