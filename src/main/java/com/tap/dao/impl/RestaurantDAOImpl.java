package com.tap.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;


public class RestaurantDAOImpl implements RestaurantDAO{
	private String insert="insert into `restaurant`(`name`,`address`,`phone_number`,`cuisine_type`,`delivery_time`,`admineuser_id`,`isactive`,`imagepath`)"
			+ " values(?,?,?,?,?,?,?,?)";
	private String update="update `restaurant` set `name`=? , `cuisine_type`=? where restaurant_id=?";
	private String select="select * from restaurant";
	ResultSet executeQuery =null;
	List<Restaurant> list = new ArrayList<>();
	Restaurant restaurant =null;

	@Override
	public List<Restaurant> getAllResturants() {
		try(Connection con=DBConnection.getConnection();
				Statement stmt= con.createStatement();){
			executeQuery = stmt.executeQuery(select);
			while(executeQuery.next()) {
				int getRestaurant_id=executeQuery.getInt("restaurant_id");
				String name = executeQuery.getString("name");
				String address = executeQuery.getString("address");
				String phone = executeQuery.getString("phone_number");
				String cuisine = executeQuery.getString("cuisine_type");
				String delivery = executeQuery.getString("delivery_time");
				int admineuser = executeQuery.getInt("admineuser_id");
				String isactive = executeQuery.getString("isactive");
				String image = executeQuery.getString("imagepath");

				restaurant = new Restaurant(getRestaurant_id,name,address,phone,cuisine,delivery,admineuser,isactive,image);

				list.add(restaurant);
			}



		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Restaurant getResturant(int restaurant_id) {
		

		return null;
	}

	@Override
	public void addRestaurant(Restaurant resu) {

		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(insert);) {
			pstmt.setString(1,resu.getName());
			pstmt.setString(2, resu.getAddress());
			pstmt.setString(3,resu.getPhone_number());
			pstmt.setString(4, resu.getCuisine_type());
			pstmt.setString(5, resu.getDelivery_time());
			pstmt.setInt(6, resu.getAdminuser_id());
			pstmt.setString(7, resu.getIsactive());
			pstmt.setString(8, resu.getImagepath());

			int i = pstmt.executeUpdate();
			System.out.println(i);


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRestaurant(Restaurant resu) {

		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(update);) {

			pstmt.setString(1, resu.getName());
			pstmt.setString(2, resu.getCuisine_type());
			pstmt.setInt(3,resu.getAdminuser_id() );
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurant_id) {


	}

}
