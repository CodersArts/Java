package com.dog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dog.bean.User;
import com.dog.dao.UserDao;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	
		request.getRequestDispatcher("NewUserHome.html").include(request, response);
		out.println("<div class='container'>");
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean status=UserDao.validate(email, password);
		if(status){
			HttpSession session=request.getSession();
			session.setAttribute("user","true");
			request.getRequestDispatcher("UserHome.html").include(request, response);
		}else{
			out.println("<h1>User Login Form</h1>");
			out.println("<p>Sorry, username or password error!</p>");
			request.getRequestDispatcher("UserLoginForm.html").include(request, response);
		}
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		
		
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
