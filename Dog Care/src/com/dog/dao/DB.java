package com.dog.dao;
import java.sql.*;
public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","a");
	}catch(Exception ex){System.out.println(ex);}
	return con;
}
}
