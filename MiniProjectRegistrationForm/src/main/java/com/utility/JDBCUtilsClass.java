package com.utility;
import java.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JDBCUtilsClass {
	static Connection con=null;
	static {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:6990/sqladmindb", "root", "password");
		} catch(Exception e) {
			e.printStackTrace();			
		}
	}
	public static Connection getConnection() {		
		return con;
	}
	public static Connection getDataSourceConnection() {		
		Connection con=null;
		MysqlDataSource mysqlsource=new MysqlDataSource();
		try {
			mysqlsource.setUrl("jdbc:mysql://localhost:6990/studydemo");
			mysqlsource.setUser("root");
			mysqlsource.setPassword("password");			
			con=mysqlsource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static Statement getStatement(Connection con) {
		Statement st=null;
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return st;		
	}
	public static PreparedStatement getPreparedStatement(Connection con,String sql) {
		PreparedStatement st=null;
		try {
			st=con.prepareStatement(sql);			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return st;		
	}
	public static PreparedStatement getPreparedStatementUpdatable(Connection con,String sql) {
		PreparedStatement st=null;
		try {
			st=con.prepareCall(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return st;		
	}
	public static CallableStatement getCallableStatement(Connection con,String sql) {
		CallableStatement cs=null;
		try {
			cs=con.prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return cs;		
	}
	public static void cleanup(Connection con,Statement st) {
		if(con!=null) {
			try {
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
		if(st!=null) {
			try {
		     st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
	}
	public static void cleanup(ResultSet rs,Connection con,Statement st) {
		if(rs!=null) {
			try {
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
		if(con!=null) {
			try {
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
		if(st!=null) {
			try {
		     st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
	}

	public static void cleanupResource(ResultSet rs,Statement st) {
		if(rs!=null) {
			try {
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
		if(st!=null) {
			try {
		     st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
