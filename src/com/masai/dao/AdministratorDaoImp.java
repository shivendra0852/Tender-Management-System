package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.utility.DBUtil;

public class AdministratorDaoImp implements AdministratorDao{

	@Override
	public String logInAdmin(String id, String password) throws Exception {
		String result = null;
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select ");
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}

}
