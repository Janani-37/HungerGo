package com.tap.servlet;

import java.io.IOException;

import com.tap.dao.impl.UserDAOimpl;

import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class registerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int id=15;
		
		
		String Name = req.getParameter("fullname");
		String UserName = req.getParameter("username");
		String Password = req.getParameter("password");
		String Email = req.getParameter("email");
		String Phone = req.getParameter("phonenumber");
		String Address = req.getParameter("address");
		String Role = req.getParameter("role");
//		
		User user = new User(Name,UserName,Password,Email,Phone,Address,Role);
//		
		
		UserDAOimpl impl = new UserDAOimpl();
		impl.addUser(user);
//		impl.deleteUser(id);
		resp.sendRedirect("login.html");
		
	}
	
	
}
