package com.sat.tmf.paymentscli;

import com.sat.tmf.paymentscli.entity.User;

public class UserOperations {
	
	public User doUserRegistration(String fName, String lName, String password, long phNum, String dob,String addr) {
		User u = new User();
		u.setFirstName(fName);
		u.setLastName(lName);
		u.setPhoneNum(phNum);
		u.setDateOfBirth(dob);
		u.setCommunicationAddr(addr);
		u.setPassword(password);
		
		u.setUserId(1234);
		return u;
	}
	
	public void printUserList(User[] users){
		for(int i=0;i<users.length;i++) {
			if(users[i] != null) {
				System.out.println("User Details of "+ users[i].getFirstName());
				System.out.println(users[i]);
			}
			
		}
	}

}
