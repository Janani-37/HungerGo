package com.tap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBConnectionMenu;

public class OrderItemDAOImpl implements OrderItemDAO {

	private String select="select * from order_item where order_id=?";

	private String select2 = 
		    "SELECT oi.*, m.image_path, m.item_name, m.price " +
		    "FROM order_item oi " +
		    "JOIN menu m ON oi.menu_id = m.menu_id " +
		    "WHERE oi.order_id = ?";

	
	OrderItem orderItem ;
	@Override
	public List<OrderItem> getAllOrderItems() {
		
		return null;
	}

	@Override
	public List <OrderItem> getAllOrderItem(int orderId) {
		
		 List<OrderItem> orderList = new ArrayList<>();
		try (Connection con = DBConnectionMenu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(select2);){
			
				pstmt.setInt(1, orderId);
				ResultSet res = pstmt.executeQuery();
				while(res.next()) {
					
					int orederItemId = res.getInt("order_item_id");
					String name = res.getString("name");
					int menuID = res.getInt("menu_id");
					double price = res.getDouble("price");
					int quentity = res.getInt("quantity");
					double TotAmount = res.getDouble("total_amount");
					String image = res.getString("image_path");
					System.out.println(image);
					 orderItem = new OrderItem(orederItemId,name,price,menuID,quentity,TotAmount, image);
//					 orderItem.setImage(image);
					 orderList.add(orderItem);
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderList;
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
	    String insertSQL = "INSERT INTO order_item (order_item_id, order_id, name, menu_id, quantity, total_amount,image) VALUES (?, ?, ?, ?, ? , ? , ?)";

	    try (Connection con = DBConnectionMenu.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(insertSQL)) {

	    	pstmt.setInt(1, orderItem.getOrderItemId());
	    	pstmt.setInt(2, orderItem.getOrderID());
	        pstmt.setString(3, orderItem.getName());
	        pstmt.setInt(4, orderItem.getMenuId());
	        pstmt.setInt(5, orderItem.getQuantity());
	        pstmt.setDouble(6, orderItem.getTotalAmount());
	        pstmt.setString(7, orderItem.getName());

	        int rowsInserted = pstmt.executeUpdate();
	        System.out.println("Order item inserted: " + rowsInserted);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}

}
