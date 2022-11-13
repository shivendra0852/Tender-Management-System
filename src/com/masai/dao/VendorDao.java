package com.masai.dao;

import java.sql.Date;
import java.util.List;

import com.masai.bean.BidderBean;
import com.masai.bean.TenderBean;
import com.masai.bean.VendorBean;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public interface VendorDao {
	public VendorBean logInVendor(String id, String password) throws VendorException;
	
	public List<TenderBean> viewAllTender() throws TenderException;
	
	public String placeBidAgainstTender(String tid, int price) throws TenderException;
	
	public BidderBean viewStatusOfBid(String bid) throws BidderException;
	
	public List<BidderBean> viewOwnBidHistory() throws BidderException;
}
