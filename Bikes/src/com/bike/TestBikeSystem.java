package com.bike;

import java.util.Scanner;

public class TestBikeSystem {

	public static void main(String args[]) {
		String owner = " ";
		String model = " ";
		String doWantToContinue = "";
		int wheelDiameter, gears, kmsRidden, capacity;
		int choice, suspensionDepth, reflectorsFitted;

		BikeSystem bs = new BikeSystem();
		Scanner sc = new Scanner(System.in);
		String bikeString = "";
		// System.out.println("Enter Capacity");
		// capacity=sc.nextInt();
		
		do {
			System.out.println(" 1: InsertBike ");
			System.out.println(" 2: PrintSystem ");
			System.out.println(" 3: CheckBikeExistence ");
			System.out.println(" 4: Close Shop");
			System.out.println(" 5: Service Intervals ");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				String bikeType;
				System.out.println("Enter bike Type Bike or MTB or RB");
				bikeType = sc.nextLine();
				

				System.out.println("Enter owner");
				owner = sc.nextLine();

				System.out.println("Enter model");
				model = sc.nextLine();

				System.out.println("Enter wheelDiameter");
				wheelDiameter = sc.nextInt();

				System.out.println("Enter gears");
				gears = sc.nextInt();

				System.out.println("Enter kmsRidden");
				kmsRidden = sc.nextInt();

				if (bikeType.equals("MTB")) {
					System.out.println("Enter SuspensionDepth");
					suspensionDepth = sc.nextInt();
					MountainBike mtb = new MountainBike(owner,model, wheelDiameter, gears, kmsRidden,suspensionDepth);
					bikeString = mtb.toString();
				} else if (bikeType.equals("RB")) {
					System.out.println("Enter reflectorsFitted");
					reflectorsFitted = sc.nextInt();
					RoadBike rb = new RoadBike(owner, model, wheelDiameter, gears, kmsRidden, reflectorsFitted);
					bikeString = rb.toString();
				} else {
					Bike bike = new Bike(owner, model, wheelDiameter, gears, kmsRidden);
					bikeString = bike.toString();
				}

				// Bike|<owner>|<model>|<wheelDiameter>|<gears>|<kmsRidden>
				//System.out.println(" i m null : "+bikeString);
				if (bs.insertBike(bikeString) == false) {
					System.out.println("Bike already exists.");
				} 
				
				break;

			case 2:
				bs.printSystem();
				break;

			case 3:
				System.out.println("Enter owner");
				owner = sc.nextLine();
				System.out.println("Enter model");
				model = sc.nextLine();

				if (bs.bikeExists(owner, model) == true) {
					System.out.println(owner +" and "+model+"  already exists.");
				}else {
					System.out.println(owner +" and "+model+"  does not exists.");
				}

				break;

			case 4:
				bs.closeShop();
				break;

			case 5:
				bs.printServiceIntervals();
				break;

			}
			System.out.println(" Do you want to continue(y/n)?");
			sc.nextLine();
			doWantToContinue = sc.nextLine();
		} while (doWantToContinue.equalsIgnoreCase("y"));

	}
}
