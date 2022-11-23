package com.masai.usecase;

import java.util.*;

import com.masai.bean.*;
import com.masai.dao.*;
import com.masai.exception.*;

public class VendorUsecase {
	
	public boolean LogInVendor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter the ID here:-");
		String id = sc.next();
		System.out.println("Enter the Password here:-");
		String password = sc.next();
		
		VendorDao dao = new VendorDaoImp();
		
		try {
			VendorBean vendor = dao.logInVendor(id, password);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Welcome, "+ vendor.getName()+"!");
			return true;
		} catch (VendorException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	
	public void ViewCurrentTender() {
		AdministratorDao dao = new AdministratorDaoImp();
		System.out.println("--------------------------------");
		try {
			List<TenderBean> vendors = dao.viewAllTender();
			System.out.println();
			System.out.println();
			vendors.forEach(v -> System.out.println(v));
		} catch (TenderException e) {
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public void PlaceBidAgainstTender() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter the Tender ID (format : TRXXXX) here:-");
		String tid = sc.next();
		System.out.println("Enter the Bidding price here:-");
		int bprice = sc.nextInt();
		
		VendorDao dao = new VendorDaoImp();
		
			try {
				String result = dao.placeBidAgainstTender(tid, bprice);
				System.out.println();
				System.out.println();
				System.out.println(result);
			} catch (TenderException e) {
				System.out.println();
				System.out.println();
				System.out.println(e.getMessage());
			}
	}

	

	
	public void ViewStatusOfBid() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------");
		System.out.println("Enter the Bid S. No. here:-");
		String id = sc.next();
		
		VendorDao dao = new VendorDaoImp();
		try {
			BidderBean bidder = dao.viewStatusOfBid(id);
			System.out.println();
			System.out.println();
			System.out.println(bidder.getStatus());
		} catch (BidderException e) {
			System.out.println();
			System.out.println();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public void ViewOwnBidHistory() {
		VendorDao dao = new VendorDaoImp();
		System.out.println("--------------------------------");
		try {
			List<BidderBean> bidders = dao.viewOwnBidHistory();
			System.out.println();
			System.out.println();
			bidders.forEach(b -> System.out.println(b));
		} catch (BidderException e) {
			System.out.println();
			System.out.println();
		    System.out.println(e.getMessage());
		}
	}
}
