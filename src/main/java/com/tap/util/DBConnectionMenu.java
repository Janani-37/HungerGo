package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMenu {
	private static String url="jdbc:mysql://localhost:3306/food_delivery";
	private static String username="root";
	private static String password="janani";
	private static Connection con=null;

	public static Connection getConnection() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
