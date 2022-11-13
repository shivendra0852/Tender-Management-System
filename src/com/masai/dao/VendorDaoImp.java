package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.BidderBean;
import com.masai.bean.TenderBean;
import com.masai.bean.VendorBean;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.utility.DBUtil;

public class VendorDaoImp implements VendorDao{
	String master_id;
	String master_password;
	

	@Override
	public VendorBean logInVendor(String id, String password) throws VendorException {
		this.master_id=id;
		this.master_password=password;
		
		VendorBean vendor = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from vendor where vid=? AND vpassword=?");
			
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String i = rs.getString("vid");
				String p = rs.getString("vpassword");
				String n = rs.getString("vname");
				String e = rs.getString("vemail");
				String a = rs.getString("vaddress");
				
				vendor = new VendorBean(i,p,n,e,a);
			}else {
				throw new VendorException("Invalid credentials!");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new VendorException(e.getMessage());
		}
		
		
		return vendor;
	}

	
	
	
	
	
	
	@Override
	public List<TenderBean> viewAllTender() throws TenderException {
        List<TenderBean> tenders = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from tender");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String i = rs.getString("tid");
				String n = rs.getString("tname");
				String t = rs.getString("ttype");
				int p = rs.getInt("tprice");
				String l = rs.getString("tlocation");
				
				tenders.add(new TenderBean(i,n,t,p,l));
			}
			
			if(tenders.size()==0) {
				throw new TenderException("No vendor found!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		
		return tenders;
	}







	@Override
	public BidderBean viewStatusOfBid(String bid) throws BidderException {
		BidderBean bidder = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bidder where bno=?");
			
			ps.setString(1, bid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String i = rs.getString("bno");
				String vi = rs.getString("vid");
				String ti = rs.getString("tid");
			    int p = rs.getInt("bprice");
				String s = rs.getString("bstatus");
				
				bidder = new BidderBean(i,vi,ti,p,s);
			}else {
				throw new BidderException("Invalid Bidder ID !");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BidderException(e.getMessage());
		}
		
		return bidder;
	}







	@Override
	public List<BidderBean> viewOwnBidHistory() throws BidderException {
        List<BidderBean> bidders = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bidder where vid=?");
			
			ps.setString(1, master_id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String i = rs.getString("bid");
				String vi = rs.getString("vid");
				String ti = rs.getString("tid");
			    int p = rs.getInt("bprice");
				String s = rs.getString("bstatus");
				
				bidders.add(new BidderBean(i,vi,ti,p,s));
			}

			if(bidders.size()==0) {
				throw new BidderException("No bids found!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BidderException(e.getMessage());
		}
		
		return bidders;
	}







	@Override
	public String placeBidAgainstTender(String tid, int price) throws TenderException {
		
        String result = "Bidding failed!";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps1 = conn.prepareStatement("select * from tender where tid=?");
			
			ps1.setString(1, tid);
			
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("insert into bidder(vid, tid, bprice, bdeadline) values(?,?,?,?)");
				
				ps2.setString(1, master_id);
				ps2.setString(2, tid);
				ps2.setInt(3, price);
				
				int x = ps2.executeUpdate();
				
				if(x>0) {
					result = "Bidded successfully...";
				}
				
			}else {
				throw new TenderException("Tender didn't found with this "+tid);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		
		return result;
	}







	
	
	
	

}
