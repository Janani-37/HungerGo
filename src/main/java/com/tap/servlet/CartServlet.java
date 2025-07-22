package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.impl.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		
		
		Integer sesRestauranId = (Integer) session.getAttribute("restaurant_id"); // fixed
		String resparam = req.getParameter("restaurantId");
		

		int newrestaurantID = Integer.parseInt(req.getParameter("restaurantId"));
//		session.setAttribute("restaurantId", newrestaurantID);
		
		if (cart == null || sesRestauranId == null || sesRestauranId != newrestaurantID) {
			 cart = new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("restaurant_id", newrestaurantID);
		}
		
		
		String action = req.getParameter("action");
		if(action.equalsIgnoreCase("add")) {
			addItemToCart(req,cart);
		}
		else if(action.equalsIgnoreCase("update")) {
			updateCarrItem(req,cart);
			System.out.println("hii from serveletupdate " +cart);

		}
		else if(action.equalsIgnoreCase("delete")) {
			deleteCartItem(req,cart);
			System.out.println("delete");
		}
		
		resp.sendRedirect("cart.jsp");
		System.out.println("hii update344634 " +cart);

		
	}

	
	
	
	
	
	
	private void deleteCartItem(HttpServletRequest req, Cart cart) {
		
		
		int itemid = Integer.parseInt(req.getParameter("menuid"));
		cart.deleteCartItem(itemid);
		
	}

	private void updateCarrItem(HttpServletRequest req, Cart cart) {
		
		
		int itemid = Integer.parseInt(req.getParameter("menuid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.updateCarrItem(itemid, quantity);
		
		System.out.println("hii update "+ "fghjkl");

//		String itemIdParam = req.getParameter("menuid");
//		if (itemIdParam != null) {
//		    int itemid = Integer.parseInt(itemIdParam);
//		    int quantity = Integer.parseInt(req.getParameter("quantity"));
//		    cart.updateCarrItem(itemid, quantity);
//		} else {
//		    // Handle gracefully (log warning, redirect, etc.)
//		}

		
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		
		int menuId = Integer.parseInt(req.getParameter("menuid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		MenuDAOImpl impl = new MenuDAOImpl();
		
		Menu menu = impl.getMenu(menuId);
		
		CartItem cartItem = new CartItem(menuId,menu.getRestaurant_id(),menu.getItem_name(),quantity,menu.getPrice(),menu.getImagepath());
		
		cart.addItemToCart(cartItem);
		System.out.println(cartItem);
		System.out.println(menu.getRestaurant_id());
		System.out.println("Menu ID "+menuId);
	}
	
}
