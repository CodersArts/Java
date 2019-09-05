package com.dog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.bean.Dog;
import com.dog.dao.DogDao;


@WebServlet("/SearchDog")
public class SearchDog extends HttpServlet {
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			int dogId=Integer.parseInt(request.getParameter("id"));
			
			Dog dog=DogDao.getRecordById(dogId);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Search Student</title>");
			out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
			out.println("<link rel='stylesheet' href='style.css'/>");
			out.println("</head>");
			out.println("<body>");
			request.getRequestDispatcher("NewUserHome.html").include(request, response);
			out.println("<div class='container'>");
			
		
			out.println("<h1>Search Dog</h1>");
			
			if(dog.getId()>0){
			out.println("<table class='table table-bordered table-striped'>");
			out.print("<tr><td>Image:</td><td>"+dog.getImage()+"</td></tr>");
			out.print("<tr><td>Rollno:</td><td>"+dog.getId()+"</td></tr>");
			out.print("<tr><td>Name:</td><td>"+dog.getDogName()+"</td></tr>");
			out.print("<tr><td>Email:</td><td>"+dog.getBreedName()+"</td></tr>");
			out.print("<tr><td>Sex:</td><td>"+dog.getGender()+"</td></tr>");
			out.print("<tr><td>Rollno:</td><td>"+dog.getLocation()+"</td></tr>");
			out.print("<tr><td>Name:</td><td>"+dog.getStatus()+"</td></tr>");
			out.print("<tr><td>Email:</td><td>"+dog.getTemperament()+"</td></tr>");
			out.print("<tr><td>Sex:</td><td>"+dog.getCondition()+"</td></tr>");
			out.print("<tr><td>Rollno:</td><td>"+dog.getAge()+"</td></tr>");
			out.print("<tr><td>Name:</td><td>"+dog.getAddress()+"</td></tr>");
			out.print("<tr><td>Email:</td><td>"+dog.getContact()+"</td></tr>");
			
			
			out.print("</table>");
			}else{
				out.println("<p>Sorry, No Record found for "+dogId+"</p>");
			}
			
			out.println("</div>");
			//request.getRequestDispatcher("footer.html").include(request, response);
			out.println("</body>");
			out.println("</html>");
			
			out.close();
		}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	}


