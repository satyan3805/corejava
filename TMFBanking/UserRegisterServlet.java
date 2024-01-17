package com.sat.tmf.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sat.tmf.bank.dao.TMFBankDAO;
import com.sat.tmf.bank.dto.UserDTO;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegisterServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName=request.getParameter("first_name") + " "+request.getParameter("last_name");
		String userName=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		String email=request.getParameter("user_email");
		String phNo=request.getParameter("user_phno");
		String address=request.getParameter("user_address");
		
		TMFBankDAO dao = new TMFBankDAO();
		UserDTO userDto = new UserDTO();
		userDto.setAddress(address);
		userDto.setEmail(email);
		userDto.setFullName(fullName);
		userDto.setPassword(password);
		userDto.setPhno(phNo);
		userDto.setUname(userName);
		
		dao.saveUserInfo(userDto);
		
		response.sendRedirect("http://localhost:8080/TMFBanking/");
		
	}

}
