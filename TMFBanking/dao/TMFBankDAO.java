package com.sat.tmf.bank.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sat.tmf.bank.dto.BankAccountDTO;
import com.sat.tmf.bank.dto.UserDTO;

public class TMFBankDAO {

	String contextPath = "";

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	public List<BankAccountDTO> getAccountDetails(String uname) {

		List<BankAccountDTO> resBankAcctList = new ArrayList<BankAccountDTO>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_banking", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select ba.* from bank_accounts ba, user_info u where ba.user_id = u.user_id and u.user_name='"+uname+"'");
			
			
			while (rs.next()) {
				BankAccountDTO bankAcctDto = new BankAccountDTO();
				
				bankAcctDto.setId(rs.getInt("id"));
				bankAcctDto.setAccountNumber(rs.getString("account_number"));
				bankAcctDto.setAcctType(rs.getString("account_type"));
				bankAcctDto.setBankName(rs.getString("bank_name"));
				bankAcctDto.setCurrBalance(rs.getDouble("current_balance"));
				bankAcctDto.setIfscCode(rs.getString("ifsc_code"));
				bankAcctDto.setUserId(rs.getInt("user_id"));
				
				resBankAcctList.add(bankAcctDto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return resBankAcctList;
	}

	public UserDTO getUserDetails(String uname) {

		UserDTO resUser = new UserDTO();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_banking", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_info where user_name='" + uname + "'");

			while (rs.next()) {
				// System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				resUser.setUserId(rs.getInt("user_id"));
				resUser.setUname(rs.getString("user_name"));
				resUser.setPassword(rs.getString("user_password"));
				resUser.setEmail(rs.getString("user_email"));
				resUser.setPhno(rs.getString("user_phno"));

				resUser.setAddress(rs.getString("user_address"));
				resUser.setFullName(rs.getString("user_full_name"));
			}
			if (resUser.getUserId() == 0) {
				resUser = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return resUser;
	}

	public int saveUserInfo(UserDTO userDto) {

		int res = -1;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_banking", "root", "root");
			Statement stmt = con.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("insert into \r\n" + "user_info(user_name,user_password,user_email, user_phno,user_address)\r\n"
					+ "values('" + userDto.getUname() + "','" + userDto.getPassword() + "','" + userDto.getEmail()
					+ "','" + userDto.getPhno() + "','" + userDto.getAddress() + "')");

			res = stmt.executeUpdate(sb.toString());

			if (res == 1) {
				return res;
			} else {
				System.out.println("Some Error in Insertion");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;

	}

	public UserDTO getUserDetailsFromFile(String uname) {
		UserDTO resUser = new UserDTO();
		try {
			File f1 = new File(contextPath);
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);

			String strLine = "";
			while ((strLine = br.readLine()) != null) {
				if (!strLine.startsWith("#")) {
					String[] userArr = strLine.split(",");
					if (uname.equals(userArr[1])) {
						resUser.setUserId(Integer.parseInt(userArr[0]));
						resUser.setUname(userArr[1]);
						resUser.setPassword(userArr[2]);
						resUser.setEmail(userArr[3]);
						resUser.setPhno(userArr[4]);
						resUser.setAddress(userArr[5]);
						resUser.setFullName(userArr[6]);
					}
				}

			}
			if (resUser.getUserId() == 0) {
				resUser = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return resUser;
	}

	public int saveUserToFile(UserDTO userDto) {

		int res = -1;
		try {
			File f1 = new File(contextPath);
//			FileReader fr = new FileReader(f1);
//			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(f1, true);
			fw.write("TEST");

			fw.flush();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}
}
