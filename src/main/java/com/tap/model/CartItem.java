package com.tap.model;

public class CartItem {
	
	private int Order_Item_id;
	private int Order_id;
	private String name;
	private int Menu_id;
	private int Quantity;
	private double Total_amount;
	private double Price;
	private String image;
	private int menuId;
	private int resId;
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}

	

	public CartItem(int order_Item_id, int order_id,String name ,int menu_id, int quantity, double total_amount,int Price) {
		super();
		Order_Item_id = order_Item_id;
		Order_id = order_id;
		this.name=name;
		Menu_id = menu_id;
		Quantity = quantity;
		Total_amount = total_amount;
		this.Price=Price;
	}


//	public CartItem(int menuId, int restaurant_id, String item_name, int quantity2, double price2, String image) {
//	    super();
//	    this.menuId = menuId;
//	    this.resId = restaurant_id;
//	    this.name = item_name;
//	    this.Quantity = quantity2;
//	    this.Price = price2;
//	    this.image=image;
//	  
//	}
	
	
	
//	public CartItem(int menuId2, int resID, String name, double price, int quantity, String image) {
//		super();
//		
//		
//		Menu_id = menuId2;
//		this.resId = resID;
//		this.name = name;
//		Price = price;
//		Quantity = quantity;
//		this.image = image;
//
//	}
	
	

	public CartItem(int menuId2, int restaurant_id, String item_name, int quantity2, double price2, String imagepath) {
		
		
		Menu_id = menuId2;
		this.resId = restaurant_id;
		this.name = item_name;
		Price = price2;
		Quantity = quantity2;
		this.image = imagepath;
	}
	public String getImage() {
		return image;
	}

	
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder_Item_id() {
		return Order_Item_id;
	}
	public void setOrder_Item_id(int order_Item_id) {
		Order_Item_id = order_Item_id;
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public int getMenu_id() {
		return Menu_id;
	}
	public void setMenu_id(int menu_id) {
		Menu_id = menu_id;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getTotal_amount() {
		return Total_amount;
	}
	public void setTotal_amount(double total_amount) {
		Total_amount = total_amount;
	}
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	@Override
	public String toString() {
		return "CartItem [Order_Item_id=" + Order_Item_id + ", Order_id=" + Order_id + ", name=" + name + ", Menu_id="
				+ Menu_id + ", Quantity=" + Quantity + ", Total_amount=" + Total_amount + ", Price=" + Price
				+ ", image=" + image + ", menuId=" + menuId + ", resId=" + resId + "]";
	}
	
	
	
	
}
