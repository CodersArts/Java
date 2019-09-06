package com.bike;

import java.util.Arrays;

public class BikeSystem {
	String[] bikelist = new String[5];
	int capacity=5;
	int size = 0;
     public BikeSystem(){
    	//this.capacity=capacity;
    	//bikelist = new String[5]; 
     }
	
	
	public boolean insertBike(String bikeString){
		
		for(int i = 0; i< size; i++) {
			if (bikelist[i].equals(bikeString))
				return false;
		}
		//System.out.println(" i m not null adding : "+bikeString);
		bikelist[size] = bikeString;
		size++;
		return true;
	}
	
	public boolean bikeExists(String owner, String model){
		
		for(int i = 0; i< size; i++) {
			String details[] = bikelist[i].split("|");
			if (details[0].equals(owner) && details[2].equals(model) )
				return true;
		}
		
		return false;
		
	}
	public void printSystem(){
		for(int i=0;i<size;i++)
		{
			System.out.println(bikelist[i].toString());
		}
	}
	public void closeShop(){ 
		bikelist = new String[5];
	    //Arrays.fill(bikelist,null);
	}
	public void printServiceIntervals() {
		
		int interval = 0;
		for(int i=0;i<size;i++)
		{
			String details[] = bikelist[i].split("|");
			if (details[0].equals("MTB")) {
				interval = Integer.parseInt(details[2]) * Integer.parseInt(details[3]) - Integer.parseInt(details[6]);
				
			}else if(details[0].equals("RB")) {
				interval = Integer.parseInt(details[5]) * Integer.parseInt(details[6]);
				
			}
			else if(details[0].equals("Bike")) {
				interval = details[1].length() * Integer.parseInt(details[4]);
				
			}
			System.out.println(interval);
		}
		
	}
}
