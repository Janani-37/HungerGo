package com.tap.model;

public class OrderItem {
	
	private int orderItemId;
	private int orderID;
	private String name;
	private int menuId;
	private double price;
	private int quantity;
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private double TotalAmount;
	
	
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(int orderItemId, int orderID, String name, int menuId, int quantity, double totalAmount) {
		super();
		this.orderItemId = orderItemId;
		this.orderID = orderID;
		this.name = name;
		this.menuId = menuId;
		this.quantity = quantity;
		TotalAmount = totalAmount;
		
	}
	

	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	
	
	
	
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderID=" + orderID + ", name=" + name + ", menuId="
				+ menuId + ", quantity=" + quantity + ", TotalAmount=" + TotalAmount + "]";
	}
	public OrderItem(int orderItemId, String name, int menuId, int quantity, double totalAmount) {
		super();
		this.orderItemId = orderItemId;
		this.name = name;
		this.menuId = menuId;
		this.quantity = quantity;
		TotalAmount = totalAmount;
	}
	

	
	public OrderItem(int orderItemId, String name,double price , int menuId,  int quantity, double totalAmount, String image) {
	    this.orderItemId = orderItemId;
	    this.name = name;
	    this.price=price;
	    this.menuId = menuId;
	    this.quantity = quantity;
	    this.TotalAmount = totalAmount;
	    this.image = image;

	}
	
	

}
