package com.masai.usecase;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.masai.dao.AdministratorDao;
import com.masai.dao.AdministratorDaoImp;
import com.masai.exception.TenderException;

public class CreateTender {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a id here:-");
		String id = sc.next();
		System.out.println("Enter a name here:-");
		String name = sc.next();
		System.out.println("Enter a type here:-");
		String type = sc.next();
		System.out.println("Enter a price here:-");
		int price = sc.nextInt();
		System.out.println("Enter a location here:-");
		String location = sc.next();
		System.out.println("Enter a deadline here:-");
		String deadline = sc.next();
		DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		Date deadline2 = (Date) formatter.parse(deadline);
		
		AdministratorDao dao = new AdministratorDaoImp();
		
		try {
			String result = dao.createTender(id, name, type, price, location, deadline2);
			System.out.println(result);
		} catch (TenderException e) {
			System.out.println(e.getMessage());
		}
	}
}
