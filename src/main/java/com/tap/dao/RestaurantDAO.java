package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;


public interface RestaurantDAO {
	List<Restaurant> getAllResturants();
	
	Restaurant getResturant(int restaurant_id);
	void addRestaurant(Restaurant resu);
	void updateRestaurant(Restaurant resu);
	void deleteRestaurant(int restaurant_id);

}
