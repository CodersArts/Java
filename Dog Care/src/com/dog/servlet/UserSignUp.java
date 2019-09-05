package com.dog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.bean.User;
import com.dog.dao.UserDao;


@WebServlet("/UserSignUp")
public class UserSignUp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Added</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		//request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		User user=new User(id,name, email, password, address, contact);
		int status=UserDao.save(user);
		
		out.print("<h1>User Form</h1>");
		out.println("<p>User is added successfully!</p>");
		request.getRequestDispatcher("UserSignUpForm.html").include(request, response);
		
		out.println("</div>");
		//request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
