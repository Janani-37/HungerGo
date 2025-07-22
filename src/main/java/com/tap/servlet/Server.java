package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tap.dao.impl.UserDAOimpl;
import com.tap.model.User;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class Server extends HttpServlet {

	
	private String password="janani";
	private String username="root";
	private String url="jdbc:mysql://localhost:3306/food_delivery";
	private String select="select `password` from `user` where `username`=?";
	
	
	private int count=3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String name=req.getParameter("username");
		String newPass=req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String oldPassword="";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = con.prepareStatement(select);
			pstmt.setString(1,name);
			ResultSet query = pstmt.executeQuery();
			while(query.next()) {
				oldPassword=query.getString("password");
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(oldPassword.equals(newPass)) {
//			out.println("Hii "+ name +" Welcome to the Laddu's Kitchen");
//			RequestDispatcher rd = req.getRequestDispatcher("checkout.jsp");
//			rd.include(req, resp);
			
			   HttpSession session = req.getSession();

			    UserDAOimpl userDAO = new UserDAOimpl();
			    User user = userDAO.getUser(name);  

			    if (user != null) {
			        session.setAttribute("user", user); 
			        session.setAttribute("user_id", user.getUserID());
			        System.out.println("User in session: " + user);
			        resp.sendRedirect("checkout.jsp"); 
			    } else {
			        out.println("User not found!");
			        RequestDispatcher rd = req.getRequestDispatcher("login.html");
			        rd.include(req, resp);
			    }
			    

			
		}
		else if(count>0) {
			out.println("Invalid Password Please Check U have only "+ count +" chance");
			
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			count--;
		}
		else {
			out.println("No more chance please go to study");
		}
		
	}
}
