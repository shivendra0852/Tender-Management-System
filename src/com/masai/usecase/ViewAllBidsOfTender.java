package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.BidderBean;
import com.masai.dao.*;
import com.masai.exception.BidderException;

public class ViewAllBidsOfTender {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the tender ID here:-");
		String tid = sc.next();
		AdministratorDao dao = new AdministratorDaoImp();
		try {
			List<BidderBean> bidders = dao.viewAllBidsOfTender(tid);
			bidders.forEach(b -> System.out.println(b));
			
		} catch (BidderException e) {
			System.out.println(e.getMessage());
		}
	}
}
