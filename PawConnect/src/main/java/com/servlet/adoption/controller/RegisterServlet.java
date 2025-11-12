package com.servlet.adoption.controller;

import java.io.IOException;

import com.servlet.adoption.dao.UserDAO;
import com.servlet.adoption.dao.UserDAOImpl;
import com.servlet.adoption.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	UserDAO edao=null;
	public RegisterServlet(){
		edao=new UserDAOImpl();
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username=req.getParameter("fullname");
	String email=req.getParameter("email");
	long phone=Long.parseLong(req.getParameter("phone"));
	String password=req.getParameter("password");
	String address=req.getParameter("Address");
	User user=new User(username,email,phone,password,address);
	
	boolean isRegistered=edao.registerUser(user);
	if(isRegistered) {
		req.getRequestDispatcher("login.jsp").forward(req,  resp);
	}else {
		req.setAttribute("error", "Registration failed. Try again!");
		req.getRequestDispatcher("register.jsp").forward(req, resp);

	}	
}
}
