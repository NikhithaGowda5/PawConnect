package com.servlet.adoption.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.servlet.adoption.dto.User;
import com.servlet.adoption.util.DBConnection;


public class UserDAOImpl implements UserDAO {
Connection con=null;
	public boolean registerUser(User user) {

			con=DBConnection.getConnector();
			String register="INSERT into employee values(?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(register);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getEmail());
				ps.setLong(3, user.getPhone());
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getAddress());
				
				int count=ps.executeUpdate();
				if(count>0) {
					return true;
				}
			} catch (SQLException e) {
				
		e.printStackTrace();
			}
		return false;
	}

}
