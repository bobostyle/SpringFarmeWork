package org.smart4j.chapter1;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloServlet.java
 * 2017年5月6日下午2:22:15
 * @author cbb
 * TODO
 */

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = dateFormat.format(new Date());
		req.setAttribute("currentTime", currentTime);
		req.getRequestDispatcher("/WEB-INF/view/hello.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
	}
}
