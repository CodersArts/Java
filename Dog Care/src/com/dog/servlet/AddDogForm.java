package com.dog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddDogForm")
public class AddDogForm extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("NewUserHome.html").include(request, response);
		out.println("<div class='container'>");
		
		
		HttpSession session=request.getSession(false);
		
		if(session==null||session.getAttribute("user")==null){
			out.println("<h1>Not User!</h1>");
			request.getRequestDispatcher("UserLoginForm.html").include(request, response);
		}else{
			request.getRequestDispatcher("DogForm.html").include(request, response);
		}
		
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	}

	
	

