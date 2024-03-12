package com.sat.tmf.paymentscli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sat.tmf.paymentscli.entity.User;

public class PaymentsFileOps {
	public final String usersFilePath = "E:\\Git8216Proj\\Payments_CLI_USers.csv";
	
	public void writeUserToFile(User u) throws IOException {
		File userFile = new File(usersFilePath);
		FileWriter fw = new FileWriter(userFile,true);
		fw.write(u.userToFileRecord());
		
		fw.flush();
		fw.close();
	}
	
	public List<User> fileToUser() throws IOException {
		File f = new File(usersFilePath);
		BufferedReader br = new BufferedReader(new FileReader(f));
		List<User> userObjectList = new ArrayList<User>();
//		usersList.get(0).compareTo(u);
//		Set<User> userSet = new HashSet<User>();
		String line;
		while ((line = br.readLine()) != null) {
			String[] usrDet = line.split(",");
			User user = new User();
			user.setUserId(Integer.parseInt(usrDet[0]));
			user.setFirstName(usrDet[1]);
			user.setLastName(usrDet[2]);
			user.setPhoneNum(Long.parseLong(usrDet[3]));
			user.setDateOfBirth(usrDet[4]);
			user.setCommunicationAddr(usrDet[5]);
			
			userObjectList.add(user);
//			userSet.add(user);
		}

		br.close();
		return userObjectList;

	}

}
