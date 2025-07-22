package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface UserDAO {

	
		List<User> getAllUsers();
		
//		User getUser(int id);
		void addUser(User user);
		void updateUser(User user);
		void deleteUser(int id);

		User getUser(String user);
		
}
