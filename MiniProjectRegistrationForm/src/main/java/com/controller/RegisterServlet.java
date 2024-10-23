package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.RegisterService;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{
	static RegisterService service=new RegisterService();		
	public RegisterServlet(){
		System.out.println("Object Created during Application StartUp");
	}	

	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		String unm = req.getParameter("registerUserName");
		String pw = req.getParameter("registerPassword");	
		String gn = req.getParameter("registerGender");	
		String ph = req.getParameter("registerPhoneNumber");
		String em = req.getParameter("registerEmail");
		RequestDispatcher rd=null;
		boolean flag=service.registerUser(unm, pw, gn, ph, em);
		if(flag) {
			rd=req.getRequestDispatcher("/WEB-INF/RegisterSuccess.html");
			rd.forward(req, res);
		} else {
			rd=req.getRequestDispatcher("/WEB-INF/RegisterError.html");
			rd.forward(req, res);				
		}
				
	}
	

}
