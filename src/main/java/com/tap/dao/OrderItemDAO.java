package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDAO {
	
	List<OrderItem> getAllOrderItems();
	
	List<OrderItem> getAllOrderItem(int orderId);
	
	void addOrderItem(OrderItem orderItem);
	

}
