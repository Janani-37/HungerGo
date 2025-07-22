package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;



public interface MenuDAO {

	List<Menu> getAllMenus();
	
	
	Menu getAllMenu(int restaurant_id);
	void addMenu(Menu menu);
	void updateMenu(Menu menu);
	void deleteMenu(int menu_id);
}
