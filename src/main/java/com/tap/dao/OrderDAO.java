package com.tap.dao;

import java.util.List;


import com.tap.model.Order;

public interface OrderDAO {
	
	List<Order> getAllOrders();
	
	
	Order getAllOrder(int userId);
	int addOrder(Order order );


	List<Order> getOrdersByUserId(int userId);

}
