package com.dog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dog.bean.User;


public class UserDao {

	
	
	public static int save(User user){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into user_accoun(id,name,email,password,address,contact) values(?,?,?,?,?,?)");
			ps.setInt(1,user.getId());
			ps.setString(2,user.getName());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getAddress());
			ps.setString(6,user.getContact());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	public static boolean validate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user_accoun where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	public static int update(User user){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update user_accoun set name=?,email=?,password=?,address=?,contact=? where id=?");
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getAddress());
			ps.setString(5,user.getContact());
			ps.setInt(6,user.getId());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}	

	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from user_accoun where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}

	public static List<User> getAllRecords(){
		List<User> list=new ArrayList<User>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user_accoun");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setContact(rs.getString(6));
				list.add(user);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list;
	}

	public static User getRecordById(int id){
		User user=new User();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user_accoun where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setContact(rs.getString(6));
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return user;
	}
}
