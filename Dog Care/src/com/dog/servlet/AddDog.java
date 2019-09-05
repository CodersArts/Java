package com.dog.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dog.bean.Dog;
import com.dog.dao.DogDao;
import com.dog.dao.UserDao;


@WebServlet("/AddDog")
@MultipartConfig(maxFileSize = 16177216)
public class AddDog extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Part part = request.getPart("image");
		if(part!=null) {
		InputStream images = part.getInputStream();
			
		int id = Integer.parseInt(request.getParameter("roll"));
		String name=request.getParameter("name");
	 	String breed=request.getParameter("breed");
		String sex=request.getParameter("sex");
		String location=request.getParameter("location");
		String status=request.getParameter("status");
		String temperament=request.getParameter("temperament");
		String condition=request.getParameter("condition");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		Dog dog=new Dog(images,id,name,breed,sex,location,status,temperament,condition,age,address,contact);
	    int statuz=DogDao.save(dog);
		
		}
		
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
		
		out.println("Student is added successfully!");
		
		request.getRequestDispatcher("DogForm.html").include(request, response);
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
