package com.masai.usecase;

import java.util.*;

import com.masai.dao.*;
import com.masai.exception.VendorException;

public class registerVendor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a id here:-");
		String id = sc.next();
		System.out.println("Enter a password here:-");
		String password = sc.next();
		System.out.println("Enter a name here:-");
		String name = sc.next();
		System.out.println("Enter a email here:-");
		String email = sc.next();
		System.out.println("Enter a address here:-");
		String address = sc.next();
		
		AdministratorDao dao = new AdministratorDaoImp();
		
		try {
			String result = dao.registerVendor(id, password, name, email, address);
			System.out.println(result);
		} catch (VendorException e) {
			e.printStackTrace();
		}
	}
}
