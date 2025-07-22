package com.tap.servlet;

import java.io.IOException;
import java.util.List;


import com.tap.dao.impl.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int restid = Integer.parseInt(req.getParameter("restaurant_id"));
		System.out.println("resId    "+" "+restid);
		System.out.println("resId    "+" "+restid);
		System.out.println("resId    "+" "+restid);
		System.out.println("resId    "+" "+restid);
		req.getSession().setAttribute("restaurantId", restid);
		MenuDAOImpl impl = new MenuDAOImpl();
		List<Menu> allmenu = impl.getAllmenu(restid);
		for(Menu menu:allmenu) {
			System.out.println(menu);
		}
		
		
		req.setAttribute("allmenu", allmenu);
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.forward(req, resp);
//		System.out.println();
		System.out.println("All menu items size: " + allmenu.size());

	}

}
