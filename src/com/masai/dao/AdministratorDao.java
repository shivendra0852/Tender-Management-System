package com.masai.dao;

import java.sql.Date;
import java.util.List;

import com.masai.bean.AdministratorBean;
import com.masai.bean.BidderBean;
import com.masai.bean.TenderBean;
import com.masai.bean.VendorBean;
import com.masai.exception.AdministratorException;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public interface AdministratorDao {
	public AdministratorBean logInAdmin(String id, String password) throws AdministratorException;
	
	public String registerVendor(String id, String password, String name, String email, String address) throws VendorException;

    public List<VendorBean> viewAllVendor() throws VendorException;
    
    public String createTender(String id, String name, String type, int price, String location, Date deadline) throws TenderException;

    public List<TenderBean> viewAllTender() throws TenderException;
    
    public List<BidderBean> viewAllBidsOfTender(String tid) throws BidderException;
}
