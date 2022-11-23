package com.masai.Main;

import java.util.*;

import com.masai.usecase.*;

public class Main {
	
	public static void administratorMain() {
		Scanner sc = new Scanner(System.in);
		AdministratorUsecase au = new AdministratorUsecase();
		System.out.println("--------------------------------");
		System.out.println("1. Register a new vendor");
		System.out.println("2. View all the vendors");
		System.out.println("3. Create a new tender");
		System.out.println("4. View all the tenders");
		System.out.println("5. View all the bidds of a tender");
		System.out.println("6. Assign tender to a vendor");
		System.out.println("");
		System.out.println("");
		System.out.println("0. Logout");
		System.out.println("99. Exit the application");
		int input1 = sc.nextInt();
		switch(input1) {
		case 0 : System.out.println("Logout Successfully..."); Main.main(null);
		break;
		
		case 1 : au.RegisterVendor();
		Main.administratorMain();
		break;
		
		case 2 : au.ViewAllVendor();
		Main.administratorMain();
		break;
		
		case 3 : au.CreateTender();
		Main.administratorMain();
		break;
		
		case 4 : au.ViewAllTender();
		Main.administratorMain();
		break;
		
		case 5 : au.ViewAllBidsOfTender();
		Main.administratorMain();
		break;
		
		case 6 : au.AssignTenderToVendor();
		Main.administratorMain();
		break;
		
		case 99 : System.out.println("Thanks for visiting TENDY,");
                  System.out.println("Have a great day.....!!"); return;
		
		default : System.out.println("Please enter a valid input!");
		Main.administratorMain();
		}
	}
	
	
	
	public static void vendorMain() {
		Scanner sc = new Scanner(System.in);
		VendorUsecase vu = new VendorUsecase();
		System.out.println("--------------------------------");
		System.out.println("1. View all the current tenders");
		System.out.println("2. Place a bid against a tender");
		System.out.println("3. View status of bid");
		System.out.println("4. View the bid history");
		System.out.println("");
		System.out.println("");
		System.out.println("0. Logout");
		System.out.println("99. Exit the application");
		int input2 = sc.nextInt();
		switch(input2) {
		case 0 : System.out.println("Logout successfully..."); Main.main(null);
		break;
		
		case 1 : vu.ViewCurrentTender();
		Main.vendorMain();
		break;
		
		case 2 : vu.PlaceBidAgainstTender();
		Main.vendorMain();
		break;
		
		case 3 : vu.ViewStatusOfBid();
		Main.vendorMain();
		break;
		
		case 4 : vu.ViewOwnBidHistory();
		Main.vendorMain();
		break;
		
		case 99 : System.out.println("Thanks for visiting TENDY,");
                  System.out.println("Have a great day.....!!"); return;
		
		default : System.out.println("Please enter a valid input");
		}
	
	}
	
	

	public static void administratorAuthentication() {
		AdministratorUsecase au = new AdministratorUsecase();
		if(au.LogInAdmin()) {
			administratorMain();
		}
	}
	
	
	
	public static void vendorAuthentication() {
		VendorUsecase vu = new VendorUsecase();
		if(vu.LogInVendor()) {
			vendorMain();
		}
	}
	
	
	
	public static void tendy() {
		Scanner sc = new Scanner(System.in);
		AdministratorUsecase au = new AdministratorUsecase();
		VendorUsecase vu = new VendorUsecase();
		System.out.println("WELCOME TO THE TENDY APPLICATION");
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println("Please enter a valid input to do the following operations:-");
		System.out.println("1. Administrator");
		System.out.println("2. Vendor");
		System.out.println("");
		System.out.println("");
		System.out.println("99. Exit the application");
		int input = sc.nextInt();
		switch(input) {
		case 1 :
			System.out.println("Please enter your admin id and password to login:-");
			if(au.LogInAdmin()) {
				administratorMain();
			}while(!au.LogInAdmin()) {
				administratorAuthentication();
			}
	    break;
	    
		case 2: 
			System.out.println("Please enter your vendor id and password to login:-");
			if(vu.LogInVendor()) {
				vendorMain();
			}
			
			while(!vu.LogInVendor()) {
				vendorAuthentication();
			}
		break;
		
		case 99 : System.out.println("Thanks for visiting TENDY,");
		          System.out.println("Have a great day.....!!");return;
		
		default : System.out.println("Please enter a valid input");
		}
	}
	
	
	
	public static void main(String[] args) {
		tendy();
	}
}