package com.sat.tmf.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sat.tmf.bank.dto.UserDTO;

public class TMFBankDAO {
	public UserDTO getUserDetails(String uname) {
		
		UserDTO resUser = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_banking","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_info");
			
			while(rs.next())  {
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
				  

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return resUser;
	}
}
