package com.tap.model;


import java.sql.Timestamp;
import java.util.List;

public class Order {
	
	private int orderId;
	private int restaurantID;
	private int userID;
	private Timestamp orderDate;
	private double totalAmount;
	private String status;
	private String pamentMode;
	private List<OrderItem> items;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, int restaurantID, int userID, Timestamp orderDate, double totalAmount, String status,
			String pamentMode) {
		super();
		this.orderId = orderId;
		this.restaurantID = restaurantID;
		this.userID = userID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.pamentMode = pamentMode;
	}

	
	
	public List<OrderItem> getItems() {
	    return items;
	}

	public void setItems(List<OrderItem> items) {
	    this.items = items;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int string) {
		this.restaurantID = string;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public Order(int orderId, int restaurantID, Timestamp orderDate, double totalAmount, String status,
			String pamentMode) {
		super();
		this.orderId = orderId;
		this.restaurantID = restaurantID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.pamentMode = pamentMode;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPamentMode() {
		return pamentMode;
	}
	public void setPamentMode(String pamentMode) {
		this.pamentMode = pamentMode;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", restaurantID=" + restaurantID + ", userID=" + userID + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", pamentMode=" + pamentMode
				+ "]";
	}
	
	
	
	

	

}
