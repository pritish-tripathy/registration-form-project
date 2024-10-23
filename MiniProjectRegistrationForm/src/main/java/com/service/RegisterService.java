package com.service;
import com.dao.RegisterDao;

public class RegisterService {
	static RegisterDao dao=new RegisterDao();
	public boolean registerUser(String username,String password,String gender, String phone, String email) {
		return dao.registerUser(username, password, gender, phone, email);		
	}
}
