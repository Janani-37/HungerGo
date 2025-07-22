package com.tap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDAO;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.util.DBConnectionMenu;

public class OrderDAOImpl implements OrderDAO {

	private String select="select * from order";
	private String select1="select * from `order` where `user_id`=?";
	private String insert="insert into `order` (`resturant_id`,`user_id`,`order_date`,`total_amount`,`status`,`payment_mode`) values (? , ? , ? , ? , ? , ?) ";
	
	
	List<Order> list=new ArrayList<>();

	Order order =null;




	@Override
	public List<Order> getAllOrders() {
		
		try (Connection con = DBConnectionMenu.getConnection();
				Statement stmt = con.createStatement()){
			ResultSet res = stmt.executeQuery(select);
			
			while(res.next()) {
				int orderID = res.getInt("order_id");
				int resId = res.getInt("resturant_id");
				int userId = res.getInt("user_id");
				Timestamp orderDate = res.getTimestamp("order_date");
				double totalAmo = res.getDouble("total_amount");
				String Status = res.getString("status");
				String Payment = res.getString("payment_mode");
				
				Order order = new Order(orderID,resId,userId,orderDate,totalAmo,Status,Payment);
				
				list.add(order);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Order getAllOrder(int userId) {
		
		
		try (Connection con = DBConnectionMenu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(select1);){
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int orderID = res.getInt("order_id");
				int resId = res.getInt("resturant_id");
				Timestamp orderDate = res.getTimestamp("order_date");
				double totalAmo = res.getDouble("total_amount");
				String Status = res.getString("status");
				String Payment = res.getString("payment_mode");
				
				 order = new Order(orderID,resId,orderDate,totalAmo,Status,Payment);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return order;
	}

	@Override
	public int addOrder(Order order) {
		int orderId =0;
		
		try (Connection con = DBConnectionMenu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);){
			
				pstmt.setInt(1, order.getRestaurantID());
				pstmt.setInt(2, order.getUserID());
				pstmt.setTimestamp(3, order.getOrderDate());
				pstmt.setDouble(4, order.getTotalAmount());
				pstmt.setString(5, order.getStatus());
				pstmt.setString(6, order.getPamentMode());
				int i = pstmt.executeUpdate();
				System.out.println("Order Table "+i);
			
				ResultSet id = pstmt.getGeneratedKeys();
				while(id.next()) {
					 orderId = id.getInt(1);
				}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return orderId;

	}
	
	@Override
	public List<Order> getOrdersByUserId(int userId) {
	    List<Order> userOrders = new ArrayList<>();

	    try (Connection con = DBConnectionMenu.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(select1)) {

	        pstmt.setInt(1, userId);
	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {
	            int orderID = res.getInt("order_id");
	            int resId = res.getInt("resturant_id");
	            int userid = res.getInt("user_id");
	            Timestamp orderDate = res.getTimestamp("order_date");
	            double totalAmo = res.getDouble("total_amount");
	            String status = res.getString("status");
	            String payment = res.getString("payment_mode");
	            

	            Order order = new Order(orderID, resId, userid, orderDate, totalAmo, status, payment);
	            
	            OrderItemDAOImpl itemDAO = new OrderItemDAOImpl(); // create DAO object
	             List<OrderItem> allOrderItem = itemDAO.getAllOrderItem(orderID); // get items
	            order.setItems(allOrderItem); // set items to order

	            userOrders.add(order);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return userOrders;
	}

}
