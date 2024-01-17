package com.sat.tmf.bank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sat.tmf.bank.dao.TMFBankDAO;
import com.sat.tmf.bank.dto.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login", initParams = @WebInitParam(name = "dbName", value = "Oracle"))
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/DashboardServlet");
//		Map<String,String> userAuthMap = new HashMap<String,String>();
//		userAuthMap.put("admin", "admin");
//		userAuthMap.put("sat","sat");
//		userAuthMap.put("cat","cat");
//		userAuthMap.put("mat","mat");

		String uname = request.getParameter("user_name");
		String upass = request.getParameter("user_password");

		TMFBankDAO dao = new TMFBankDAO();
		UserDTO user = dao.getUserDetails(uname);
		dao.setContextPath(request.getServletContext().getRealPath("/db/user_info.csv"));
		dao.saveUserToFile(null);
//		UserDTO user = dao.getUserDetailsFromFile(uname);

		if (user != null) {
			if (user.getPassword().equals(upass)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				rd.forward(request, response);
			} else {
				response.sendRedirect("http://localhost:8080/TMFBanking/login.html");
			}

		} else {
			response.sendRedirect("http://localhost:8080/TMFBanking/login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
