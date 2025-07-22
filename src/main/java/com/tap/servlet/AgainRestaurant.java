package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.dao.impl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurantList")
public class AgainRestaurant extends HttpServlet{
	  @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        
	        RestaurantDAO dao = new RestaurantDAOImpl();
	        List<Restaurant> allRestaurants = dao.getAllResturants();
	        
	        req.setAttribute("allResturants", allRestaurants);
	        req.getRequestDispatcher("Restaurant.jsp").forward(req, resp);
	        System.out.println("helow again");
	    }

}
