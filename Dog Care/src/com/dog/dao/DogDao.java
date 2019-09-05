package com.dog.dao;

import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dog.bean.Dog;




public class DogDao {

	public static int save(Dog dog){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into dog_table(image,id,name,breed,gender,location,status,temperament,condition,age,address,contact) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setBlob(1,dog.getImage());
			ps.setInt(2,dog.getId());
			ps.setString(3,dog.getDogName());
			ps.setString(4,dog.getBreedName());
			ps.setString(5,dog.getGender());
			ps.setString(6,dog.getLocation());
			ps.setString(7,dog.getStatus());
			ps.setString(8,dog.getTemperament());
			ps.setString(9,dog.getCondition());
			ps.setString(10,dog.getAge());
			ps.setString(11,dog.getAddress());
			ps.setString(12,dog.getContact());
			ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	
	/*public static List<Dog> getAllRecords(){
		List<Dog> dogList=new ArrayList<Dog>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from fee_student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Dog dog=new Dog();
				dog.setImage(rs.getInt(1);
				dog.setName(rs.getString(2));
				dog.setEmail(rs.getString(3));
				dog.setSex(rs.getString(4));
				dog.setCourse(rs.getString(5));
				dog.setFee(rs.getInt(6));
				dog.setPaid(rs.getInt(7));
				dog.setDue(rs.getInt(8));
				dog.setAddress(rs.getString(9));
				dog.setContact(rs.getString(10));
				dogList.add(dog);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return dogList;
	}*/
	
	public static Dog getRecordById(int id){
		Dog dog=new Dog();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from fee_student where rollno=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Blob blob = rs.getBlob(1);
				byte byteArray[] = blob.getBytes(1, (int)blob.length());
		        /*OutputStream os = response.getOutputStream();
		        os.write(byteArray);
		        os.flush();
		        os.close();*/
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return dog;
	}
	
}
