package com.tap.servlet;

import java.io.IOException;
import java.sql.Date;


import com.tap.dao.OrderDAO;
import com.tap.dao.impl.OrderDAOImpl;
import com.tap.dao.impl.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Timestamp;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet{
	
	private OrderDAO orderDAOImpl;
	
	@Override
	public void init() throws ServletException {
		
		 orderDAOImpl = new OrderDAOImpl();
		 OrderItem orderItem = new OrderItem();
		 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		
		if(user == null) {
//			RequestDispatcher rd = req.getRequestDispatcher("login.html");
//			rd.forward(req, resp);
//			return;
			
			resp.sendRedirect("login.html");
			return;
			
		}
		
		if(cart != null && user != null && ! cart.getItems().isEmpty()) {
			String paymenuMethod = req.getParameter("payment");
			String Address = req.getParameter("address");
			
			Order order = new Order();
			order.setUserID(user.getUserID());

//			order.setRestaurantID((int)session.getAttribute("restaurantId"));
			
//			Integer restaurantId =(Integer) session.getAttribute("restaurantId");
//			System.out.println(restaurantId);
//			if(restaurantId == null) {
//				resp.sendRedirect("cart.jsp");
//				return;
//			}
			
			
			
			
			Integer restaurantId = (Integer) session.getAttribute("restaurant_id");
			if (restaurantId == null || restaurantId == 0) {
			    resp.sendRedirect("cart.jsp");
			    return;
			}
			order.setRestaurantID(restaurantId); // ✅ Fix

			
//			order.setOrderDate(new Timestamp(new Date(0).getTime()));
			
			order.setOrderDate(new Timestamp (System.currentTimeMillis()));
			order.setPamentMode(paymenuMethod);
			order.setStatus("Completed");
			
			
			
			
			double totalAmount=0;
			for(CartItem item : cart.getItems().values()) {
				
				totalAmount +=item.getPrice() * item.getQuantity();
				
			}
			order.setTotalAmount(totalAmount);
			
			int orderID = orderDAOImpl.addOrder(order);
			
			
			for(CartItem item : cart.getItems().values()) {
				
				int itemId = item.getMenu_id();
				System.out.println("menu Item ID from Checout page  "+itemId);
				int quantity = item.getQuantity();
				double total_amount = item.getTotal_amount();
				String name = item.getName();
				String image = item.getImage();
				
				
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderID(orderID);
				orderItem.setMenuId(itemId);
				orderItem.setQuantity(quantity);
				orderItem.setTotalAmount(totalAmount);
				orderItem.setName(name);
				orderItem.setImage(image);
				
				OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
				orderItemDAOImpl.addOrderItem(orderItem);
				
				
//				OrderItem orderItem = new OrderItem(orderID, itemId, quantity, total_amount);
				
//				OrderItemDAOImpl order1 = new OrderItemDAOImpl();
//				order1.addOrderItem(orderItem);
//				OrderDAOImpl orderDAOImpl2 = new OrderDAOImpl();
//				
				
				
				
			}
			
			session.removeAttribute("cart");
			session.setAttribute("user", user);
			session.setAttribute("order", order);
			resp.sendRedirect("Confirm.jsp");
			System.out.println("forwarding to confirm.jsp");
			
		}
		else {
			resp.sendRedirect("cart.jsp");
		}
		
	}

}
