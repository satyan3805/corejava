package com.sat.tmf.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sat.tmf.bank.dto.UserDTO;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String tmpSessionId=request.getParameter("session_feild_id");
		HttpSession session = request.getSession();
		//session.getAttribute(getServletInfo())
		UserDTO user = (UserDTO)session.getAttribute("user");
		
		String logoutFormStr ="<form action='http://localhost:8080/TMFBanking/LogoutServlet'>\r\n"
				+ "	<input type='submit' value=\"Logout\"/>\r\n"
				+ "</form>";
		String res = "";
		if(user != null) {
			res = "<html>\r\n"
					+ "<body>\r\n"
					+ "dashboard page for:<h2>"+request.getParameter("user_name")+ "</h2>\r\n"
					+ "dashboard page for:<h2>"+user.getFullName()+"::"+user.getAccountID()+"::"+user.getCurrBal()+user.getLastTxnDdatTime()+ "</h2>\r\n"
					+ "</hr>"
					+ "<form action='http://localhost:8080/TMFBanking/StmtServlet' method='post'>\r\n"
					+ "	start date: <input type='date' name='stmt_start_date' />\r\n"
					+ "	end date: <input type='date' name='stmt_end_date' />\r\n"
					+ "	<input type='submit' />\r\n"
					//+ "<input type=\"hidden\" name=\"session_feild_id\" value='"+user.getUserId()+"'/>"
					+ "</form>"
					+logoutFormStr
					+ "</body>\r\n"
					+ "</html>";
		}else {
			res = "<html><body> Invalid User <form action='http://localhost:8080/TMFBanking/LoginServlet'>\r\n"
					+ "	<input type='submit' value=\"Login\"/>\r\n"
					+ "</form> "
					+"</body></html>";
		}
		
		
		response.getWriter().append(res);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
