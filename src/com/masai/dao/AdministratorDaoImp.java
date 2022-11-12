package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.AdministratorBean;
import com.masai.bean.VendorBean;
import com.masai.exception.AdministratorException;
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
	public String createTender(String id, String name, String type, int price, String location, Date deadline) {
		
		return null;
	}

}
