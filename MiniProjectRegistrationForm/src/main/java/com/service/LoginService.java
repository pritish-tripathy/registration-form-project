package com.service;
import com.dao.LoginDao;
import com.model.User;

public class LoginService {
	static LoginDao dao=new LoginDao();
	public User getUser(String username,String password) {
		return dao.getUser(username, password);		
	}	
}
