package com.dao;
import java.sql.*;
import com.utility.JDBCUtilsClass;

public class RegisterDao {
	static Connection con=JDBCUtilsClass.getConnection();		
	public boolean  registerUser(String username, String password, String gender, String phone, String email) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="insert into employees values(?,?,?,?,?)";
		boolean flag=false;		
		try {		
			ps=JDBCUtilsClass.getPreparedStatement(con, query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, gender);
			ps.setString(4, phone);
			ps.setString(5, email);
			int x=ps.executeUpdate();
			if(x==1) {
				flag=true;			
			}
		} catch(Exception ex) {
			ex.printStackTrace();			
		} finally {
			JDBCUtilsClass.cleanupResource(rs,ps);
		}		
		return flag;
	}
}

