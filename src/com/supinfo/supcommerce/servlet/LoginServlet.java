package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");		
		String password = req.getParameter("password");
		
		if(username != null && username.equals("foo") &&
				password != null && password.equals("bar")) {
			
			req.getSession().setAttribute("username", username);
			resp.sendRedirect(req.getContextPath() + "/listProduct");
		} else {
			resp.sendRedirect(req.getContextPath() + "/login.html");
		}
	}

}
