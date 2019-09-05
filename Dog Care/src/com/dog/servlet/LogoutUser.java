package com.dog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutUser")
public class LogoutUser extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		request.getRequestDispatcher("NewUserHome.html").include(request, response);
		out.println("<div class='container'>");
		
		out.println("<h1>User Logout Success</h1>");
		HttpSession session=request.getSession();
		session.invalidate();
		//request.getRequestDispatcher("AdminLoginForm.html").include(request, response);
		
		out.println("</div>");
		out.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
		
		request.getRequestDispatcher("footer.html").include(request, response);
		
		out.close();
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
