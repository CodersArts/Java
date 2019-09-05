package com.dog.bean;

import java.io.InputStream;
import java.io.OutputStream;

public class Dog {
	
	private InputStream image;
    private int id;
	private String dogName;
	private String breedName;
	private String gender;
	private String location;
	private String status;
	private String temperament;
	private String condition;
    private String age;
    private String address;
    private String contact;
    
    private OutputStream images;
    
   public Dog() { 
   
   }
    
    
	public Dog(InputStream image, int id, String dogName, String breedName, String gender, String location,
			String status, String temperament, String condition, String age, String address, String contact) {
	
		this.image = image;
		this.id = id;
		this.dogName = dogName;
		this.breedName = breedName;
		this.gender = gender;
		this.location = location;
		this.status = status;
		this.temperament = temperament;
		this.condition = condition;
		this.age = age;
		this.address = address;
		this.contact = contact;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
    
    
    
    
	
    
    
}
