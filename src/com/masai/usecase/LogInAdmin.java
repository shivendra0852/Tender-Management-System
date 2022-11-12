package com.masai.usecase;

import java.util.*;

import com.masai.bean.AdministratorBean;
import com.masai.dao.*;

public class LogInAdmin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID here:-");
		String id = sc.next();
		System.out.println("Enter the Password here:-");
		String password = sc.next();
		
		AdministratorDao ad = new AdministratorDaoImp(); 
		try {
			AdministratorBean admin = ad.logInAdmin(id, password);
			System.out.println("Welcome, "+admin.getName()+"!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
