package com.tap.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOimpl implements UserDAO {

	private String insert="insert into `user` (`userID`,`name`,`username`,`password`,`email`,`phone_number`,`address`,`role`,`create_date`,`last_login_date`) values (?,?,?,?,?,?,?,?,?,?) ";
	private String update="update `user` set  `name` = ? , `username`=?, `password`=?,`email`=?, `phone_number`=?, `address`=? where `id`=? ";
	private String select="select * from `user` where `name`=?";
	public String delete="delete from `user` where `userID`=?";

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String user) {
		User u = null;
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(select); ) {

			pstmt.setString(1,user);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int userid = result.getInt("userID");
				String name = result.getString("name");
				String username = result.getString("username");
				String pass = result.getString("password");
				String email = result.getString("email");
				String phone = result.getString("phone_number");
				String address = result.getString("address");
				String role = result.getString("role");
				Timestamp createdate = result.getTimestamp("create_date");
				Timestamp lastlogindate = result.getTimestamp("last_login_date");
				
				
				u = new User(userid,name,username,pass,email,phone,address,role,null,null);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void addUser(User user) {

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(insert);) {


			pstmt.setInt(1,user.getUserID());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhone_number());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getRole());
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));


			int i = pstmt.executeUpdate();
			System.out.print(i);

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}



	}

	@Override
	public void updateUser(User user) {
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(update);) {


				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getUsername());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPhone_number());
				pstmt.setString(6, user.getAddress());
				pstmt.setInt(7,user.getUserID());

				int i = pstmt.executeUpdate();
				System.out.print(i);

			} 
			catch (SQLException e) {
				e.printStackTrace();
			}

	}

	@Override
	public void deleteUser(int id) {
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(delete);) {
//			System.out.println("execute");
			pstmt.setInt(1, id);
			
			int i = pstmt.executeUpdate();
			System.out.print(i);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
