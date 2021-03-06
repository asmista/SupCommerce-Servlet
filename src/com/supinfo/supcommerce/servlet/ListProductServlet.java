package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

public class ListProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<SupProduct> products = SupProductDao.getAllProducts();

		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		for (SupProduct p : products) {
			out.println("<p>");
			out.println("<strong>" + p.getName() + "</strong><br />");
			out.println(p.getPrice() + "<br/>");
			out.println("<a href=\"" + req.getContextPath() + "/showProduct?id=" + p.getId() + "\">Voir en détail</a>");
			out.println("</p>");
		}
	}

}
