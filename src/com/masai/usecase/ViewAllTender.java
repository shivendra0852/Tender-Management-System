package com.masai.usecase;

import java.util.List;

import com.masai.bean.TenderBean;
import com.masai.dao.*;
import com.masai.exception.TenderException;

public class ViewAllTender {
	public static void main(String[] args) {
		AdministratorDao dao = new AdministratorDaoImp();
		
		
		try {
			List<TenderBean> vendors = dao.viewAllTender();
			vendors.forEach(v -> System.out.println(v));
		} catch (TenderException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
