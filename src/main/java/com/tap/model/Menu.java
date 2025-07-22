package com.tap.model;

import java.io.InputStream;

public class Menu {
	private int menu_id;
	private int restaurant_id;
	private String item_name;
	private String description;
	private double price;
	private String isavalible;
	private int ratings;
	private String imagepath;
	
	
	public Menu() {
		
	}


	public Menu(int menu_id,int restaurant_id, String item_name, String description, double price, String isavalible, int ratings,
			String image_path) {
		super();
		this.menu_id=menu_id;
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.isavalible = isavalible;
		this.ratings = ratings;
		this.imagepath = image_path;
	}



	public Menu(int restaurant_id2, String item_name2, String description2, double price2, String isavailable,
			int ratings2, String image_path) {
		
		super();

		this.restaurant_id = restaurant_id2;
		this.item_name = item_name2;
		this.description = description2;
		this.price = price2;
		this.isavalible = isavailable;
		this.ratings = ratings2;
		this.imagepath = image_path;
	}


	public Menu(String itemName, String description2, double price2, String isavailable, int ratings2,
			String image_path) {
		super();
		this.item_name = itemName;
		this.description = description2;
		this.price = price2;
		this.isavalible = isavailable;
		this.ratings = ratings2;
		this.imagepath = image_path;
		
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public int getRestaurant_id() {
		return restaurant_id;
	}


	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getIsavalible() {
		return isavalible;
	}


	public void setIsavalible(String isavalible) {
		this.isavalible = isavalible;
	}


	public int getRatings() {
		return ratings;
	}


	public void setRatings(int ratings) {
		this.ratings = ratings;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


	@Override
	public String toString() {
		return "Menu [restaurant_id=" + "]";
	}
	
	

}
