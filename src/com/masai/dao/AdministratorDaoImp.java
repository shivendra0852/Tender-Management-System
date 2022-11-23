package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.AdministratorBean;
import com.masai.bean.BidderBean;
import com.masai.bean.TenderBean;
import com.masai.bean.VendorBean;
import com.masai.exception.AdministratorException;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.utility.DBUtil;

public class AdministratorDaoImp implements AdministratorDao{

	@Override
	public AdministratorBean logInAdmin(String id, String password) throws AdministratorException {
		AdministratorBean result = null;
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from administrator where aid=? AND apassword=?");
		    
			ps.setString(1,id);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String n = rs.getString("aname");
				String e = rs.getString("aemail");
				String a = rs.getString("aaddress");
				
				result = new AdministratorBean(n,e,a);
				
			}else {
				throw new AdministratorException("Invalid Admin !");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdministratorException(e.getMessage());
		}
		
		
		return result;
	}

	
	
	
	
	
	
	
	@Override
	public String registerVendor(String id, String password, String name, String email, String address) throws VendorException {
		String result = "Insertion failed!";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into vendor values(?,?,?,?,?)");
			
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, address);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Insertion successfully.";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new VendorException(e.getMessage());
		}
		return result;
	}







	@Override
	public List<VendorBean> viewAllVendor() throws VendorException {
		List<VendorBean> vendors = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from vendor");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String i = rs.getString("vid");
				String p = rs.getString("vpassword");
				String n = rs.getString("vname");
				String e = rs.getString("vemail");
				String a = rs.getString("vaddress");
				
				vendors.add(new VendorBean(i,p,n,e,a));
			}
			
			if(vendors.size()==0) {
				throw new VendorException("No vendor found!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new VendorException(e.getMessage());
		}
		
		
		
		return vendors;
	}








	@Override
	public String createTender(String id, String name, String type, int price, String location) throws TenderException {
		
		String result = "Tender creation failed";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into tender values(?,?,?,?,?)");
			
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, type);
			ps.setInt(4, price);
			ps.setString(5, location);
			
			int x = ps.executeUpdate();
			if(x>0) {
				result = "Tender created successfully.";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TenderException(e.getMessage());
		}
		
		
		return result;
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
	public List<BidderBean> viewAllBidsOfTender(String tid) throws BidderException {
		List<BidderBean> bidders = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("select * from bidder where tid=?");
			
			ps.setString(1, tid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String i = rs.getString("bno");
				String vi = rs.getString("vid");
				String ti = rs.getString("tid");
			    int p = rs.getInt("bprice");
				String s = rs.getString("bstatus");
				
				bidders.add(new BidderBean(i,vi,ti,p,s));
			}
			
			if(bidders.size()==0) {
				throw new BidderException("No bidders found!");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BidderException(e.getMessage());
		}
		
		return bidders;
	}








	@Override
	public String assignTenderToVendor(String vid, String tid) throws BidderException {
		String result = "Invalid details provided!";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update bidder set bstatus = 'selected' where vid=? AND tid=?");
			
			ps.setString(1, vid);
			ps.setString(2, tid);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Tender assigned successfully...";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BidderException(e.getMessage());
		}
		
		return result;
	}
	
}
