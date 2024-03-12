package com.sat.tmf.paymentscli.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.sat.tmf.paymentscli.entity.User;

public class PaymentsCliDAO {
	public void storeUserDetails(User u) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentcliapp","root","root");
		Statement stmt = con.createStatement();
		String query = "insert into user_info(FirstName,LastName,PhoneNo,DateOfBirth,Address,PassWord,CurrWalletBal) "
				+ "values('"+u.getFirstName()+"','"+u.getLastName()+"','"+u.getPhoneNum()+"','"+u.getDateOfBirth()+"','"+u.getCommunicationAddr()+"','"+u.getPassword()+"',"+0+")";
		System.out.println(query);
		stmt.executeUpdate(query);
	}
}
