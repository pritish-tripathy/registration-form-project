package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.User;
import com.service.LoginService;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	static LoginService service=new LoginService();		
	public LoginServlet(){
		System.out.println("Object Created During Application Start-Up");
	}	
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		String unm=req.getParameter("loginUserName");
		String pw=req.getParameter("loginPassword");		
		RequestDispatcher rd=null;
		User user=service.getUser(unm, pw);
		if(user!=null) {
			rd=req.getRequestDispatcher("/WEB-INF/LoginSuccess.html");
			rd.forward(req, res);
		} else {
			rd=req.getRequestDispatcher("/WEB-INF/LoginError.html");
			rd.forward(req, res);				
		}			
	}
}
