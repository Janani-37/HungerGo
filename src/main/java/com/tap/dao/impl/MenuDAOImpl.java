package com.tap.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.Menu;
import com.tap.util.DBConnectionMenu;



public class MenuDAOImpl {
	

	private String insert="insert into `menu` (`restaurant_id`,`item_name`,`description`,`price`,`isavailable`,`ratings`,`image_path`) values (? , ? , ? , ? , ? , ? , ?) ";
	private String delete="delete from `menu` where `menu_id`=?";
	private String select="select * from menu";
	private String selectAll="select * from `menu` where restaurant_id=?";
	
	private String select2="select * from menu where menu_id=?";
	



	public List<Menu> getAllMenus(){
		List<Menu> list=new ArrayList<>();
		try (Connection con = DBConnectionMenu.getConnection();
				Statement stmt = con.createStatement()){
			ResultSet res = stmt.executeQuery(select);
			while(res.next()) {
				
				int restaurant_id=res.getInt("restaurant_id");
				String item_name = res.getString("item_name");
				String description = res.getString("description");
				double price = res.getDouble("price");
				String isavailable = res.getString("isavailable");
				int ratings = res.getInt("ratings");
				String image_path = res.getString("image_path");
				
				Menu menu = new Menu(restaurant_id,item_name,description,price,isavailable,ratings,image_path);
				
				list.add(menu);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Menu> getAllmenu(int restaurant_id) {
		List<Menu> list=new ArrayList<>();

		try (Connection con = DBConnectionMenu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(selectAll);){
				pstmt.setInt(1, restaurant_id);
				ResultSet res = pstmt.executeQuery();
			
			
			while(res.next()) {
				int restaurant =res.getInt("restaurant_id");
				int menu_id=res.getInt("menu_id");
				String item_name = res.getString("item_name");
				String description = res.getString("description");
				double price = res.getDouble("price");
				String isavailable = res.getString("isavailable");
				int ratings = res.getInt("ratings");
				String image_path = res.getString("image_path");
				
				Menu menu= new Menu(menu_id,restaurant,item_name,description,price,isavailable,ratings,image_path);
				
				list.add(menu);
				System.out.println("Hii menu from menusImo "+ restaurant);
				System.out.println("Hii menu from menu List  "+ list);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void addMenu(Menu menu) {
		try(Connection con = DBConnectionMenu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(insert);) {
			pstmt.setInt(1, menu.getRestaurant_id());
			pstmt.setString(2, menu.getItem_name());
			pstmt.setString(3, menu.getDescription());
			pstmt.setDouble(4, menu.getPrice());
			pstmt.setString(5, menu.getIsavalible());
			pstmt.setInt(6, menu.getRatings());
			pstmt.setString(7, menu.getImagepath());
			
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMenu(Menu menu) {
		
	}
	
	public void deleteMenu(int menu_id) {
		
		try(Connection con = DBConnectionMenu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(delete);) {
			pstmt.setInt(1, menu_id);
			int i = pstmt.executeUpdate();
			System.out.println(i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Menu getMenu(int menu_id) {
		
		Menu menu=null;
		try(Connection con = DBConnectionMenu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(select2);) {
			
			pstmt.setInt(1,menu_id);
			ResultSet re = pstmt.executeQuery();
			
			while(re.next()) {
				
				String itemName = re.getString("item_name");
				String description = re.getString("description");
				double price = re.getDouble("price");
				String isavailable = re.getString("isavailable");
				int ratings = re.getInt("ratings");
				String image_path = re.getString("image_path");
				
				 menu = new Menu(itemName,description,price,isavailable,ratings,image_path);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menu;
	}
	
}
