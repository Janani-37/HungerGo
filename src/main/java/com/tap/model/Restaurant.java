package com.tap.model;

import java.io.InputStream;

public class Restaurant {
	private int restaurant_id;
	private String name;
	private String address;
	private String phone_number;
	private String cuisine_type;
	private String delivery_time;
	private int adminuser_id;
	private String isactive;
	private String imagepath;
	
	public Restaurant() {
		
	}

	public Restaurant(int restaurant_id,String name, String address, String phone_number, String cuisine_type, String delivery_time,
			int admineuser, String isactive,String imagepath) {
		super();
		this.restaurant_id=restaurant_id;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.adminuser_id = admineuser;
		this.isactive = isactive;
		this.imagepath=imagepath;
	}
	

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCuisine_type() {
		return cuisine_type;
	}

	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}

	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public int getAdminuser_id() {
		return adminuser_id;
	}

	public void setAdminuser_id(int adminuser_id) {
		this.adminuser_id = adminuser_id;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Restaurant [Restarid="+restaurant_id+", name=" + name + ", address=" + address + ", phone_number=" + phone_number
				+ ", cuisine_type=" + cuisine_type + ", delivery_time=" + delivery_time + ", adminuser_id="
				+ adminuser_id + ", isactive=" + isactive + "]";
	}

}
