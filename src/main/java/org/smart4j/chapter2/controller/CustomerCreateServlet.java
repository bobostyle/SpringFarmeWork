package org.smart4j.chapter2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * CustomerCreateServlet.java
 * 2017��5��6������3:46:25
 * @author cbb
 * TODO �����ͻ�
 */

@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		//TODO
	}
}
