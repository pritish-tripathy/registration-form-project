package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class RegistrationFormServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fn = req.getParameter("firstName");
		String mn = req.getParameter("middleName");
		String ln = req.getParameter("lastName");
		String em = req.getParameter("email");
		String ph = req.getParameter("phoneNumber");
		String gn = req.getParameter("gender");
		String[] crs = req.getParameterValues("courses");
		String tms = req.getParameter("timings");
		String rmks = req.getParameter("remarks");
		
		// Printing in Console
		System.out.println(fn);
		System.out.println(mn);
		System.out.println(ln);
		System.out.println(em);
		System.out.println(ph);
		System.out.println(gn);
		for(String crss : crs)
			System.out.print(crss + "\t");
		System.out.println(tms);
		System.out.println(rmks);
			
		// Using PrintWriter
		res.setContentType("text/html");
		PrintWriter pwr = res.getWriter();
		pwr.print("<center>");
			pwr.print("<h1>You Following Information Stored Successfully</h1>");
			pwr.print("<h3>Your First Name: </h3>"+fn);
			pwr.print("<h3>Your Middle Name: </h3>"+mn);
			pwr.print("<h3>Your Last Name: </h3>"+ln);
			pwr.print("<h3>Your Email: </h3>"+em);
			pwr.print("<h3>Your Phone Number: </h3>"+ph);
			pwr.print("<h3>Your Gender: </h3>"+gn);
			pwr.print("<h3>Your Selected Courses: </h3>");
			if(crs != null)
				for(String c : crs)
					pwr.print("<br>"+c);
			pwr.print("<h3>Your Timings are: </h3>"+tms);
			pwr.print("<h3>Remarks: </h3>"+rmks);
		pwr.print("</center>");
	}
}
