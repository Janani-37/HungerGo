package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.impl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")

public class HomeServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAOImpl impl = new RestaurantDAOImpl();
		List<Restaurant> allResturants = impl.getAllResturants();
		for(Restaurant restaurant:allResturants) {
			System.out.println(restaurant);
		}
		req.setAttribute("allResturants",allResturants);
		RequestDispatcher rd = req.getRequestDispatcher("Restaurant.jsp");
		rd.forward(req, resp);
		
	}
}
