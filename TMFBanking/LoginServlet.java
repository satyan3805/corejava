package com.sat.tmf.bank;

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

import com.sat.tmf.bank.dto.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = "/LoginServlet",
		initParams = @WebInitParam(name = "dbName", value = "Oracle")
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/DashboardServlet");
		
		Map<String,String> userAuthMap = new HashMap<String,String>();
		userAuthMap.put("admin", "admin");
		userAuthMap.put("sat","sat");
		userAuthMap.put("cat","cat");
		userAuthMap.put("mat","mat");
		
		
		String uname = request.getParameter("user_name");
		String upass = request.getParameter("user_password");
		
		
		if(userAuthMap.containsKey(uname)) {
			if(userAuthMap.get(uname).equals(upass)) {
				UserDTO user = getUserDetails(uname);
				//request.setAttribute("user", user);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				rd.forward(request, response);
				//rd.include(request, response);
				//response.sendRedirect("http://localhost:8080/TMFBanking/DashboardServlet");
			}else {
				response.sendRedirect("http://localhost:8080/TMFBanking/login.html");
			}
		}else {
			response.sendRedirect("http://localhost:8080/TMFBanking/login.html");
		}
		
		
		
		
//		ServletContext sContext = getServletContext();
//		String dbConfig = sContext.getInitParameter("dbName");
		
//		String res = "<html>\r\n"
//				+ "<body>\r\n"
//				+ "name is:<h1>"+request.getParameter("user_name")+"</h1>\r\n"
//				+ "Password is:<h2>"+request.getParameter("user_password")+"</h2>\r\n"
//				+"database is: <h3>"+dbConfig+"</h3>\r\n"
//				+ "</body>\r\n"
//				+ "</html>";
		
//		response.getWriter().append(res);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	public UserDTO getUserDetails(String uname) {
		UserDTO sat = new UserDTO("1001","sat","SATYANARAYANA N.",	"98798987",	"2,345.00",		 "25-DEC-20203 11:09:10");
		UserDTO cat = new UserDTO("1002","cat","Catherine D.",		"2342324",	"5,343245.00", 	"25-DEC-20203 11:09:10");
		UserDTO mat = new UserDTO("1003","mat","Mathew Lee.",		"98795443",	"7,234325.00", 	"25-DEC-20203 11:09:10");
		
		List<UserDTO> usersList = new ArrayList<UserDTO>();
		usersList.add(sat);
		usersList.add(cat);
		usersList.add(mat);
		
		UserDTO resUser = null;
		
		for(UserDTO user: usersList) {
			if(uname.equals(user.getUname())) {
				resUser = user;
			}
		}
		
		
		return resUser;
	}
	
}
