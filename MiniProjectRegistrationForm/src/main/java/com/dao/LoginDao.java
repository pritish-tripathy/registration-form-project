package com.dao;

import com.model.User;
import java.sql.*;
import com.utility.JDBCUtilsClass;

public class LoginDao {
	static Connection con=JDBCUtilsClass.getConnection();	
	public User getUser(String username,String password) {
		User user=null;		
		PreparedStatement ps=null;
		ResultSet rs=null;		
		String query="select * from employees where username=? and password=?";		
		try {
		ps=JDBCUtilsClass.getPreparedStatement(con, query);
		ps.setString(1, username);
		ps.setString(2, password);
		rs=ps.executeQuery();
		if(rs.next()) {
			user=new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch(Exception e) {
			e.printStackTrace();			
		} finally {
			JDBCUtilsClass.cleanupResource(rs,ps);
		}		
		return user;	
	}
}
