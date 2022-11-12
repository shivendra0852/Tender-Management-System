package com.masai.usecase;

import java.util.List;

import com.masai.bean.VendorBean;
import com.masai.dao.*;
import com.masai.exception.VendorException;

public class ViewAllVendor {
	public static void main(String[] args) {
		AdministratorDao dao = new AdministratorDaoImp();
		
		
		try {
			List<VendorBean> vendors = dao.viewAllVendor();
			vendors.forEach(v -> System.out.println(v));
		} catch (VendorException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
