package com.sat.tmf.bank;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sat.tmf.bank.dao.TMFBankDAO;
import com.sat.tmf.bank.dto.BankAccountDTO;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		TMFBankDAO dao = new TMFBankDAO();
		String res="";
		
		String logoutFormStr = "<form action='http://localhost:8080/TMFBanking/LogoutServlet'>\r\n"
				+ "	<input type='submit' value=\"Logout\"/>\r\n" + "</form>";
		String userInfoStr = "";
		String addAcctFormStr="";
		
		if (user != null) {
			userInfoStr = "<h1> "+user.getFullName()+"'s Dashboard </h1>\r\n"
					+ "\r\n"
					+ "<h2>PhNo: </h2>\r\n"
					+ "<h2>Email: </h2>\r\n"
					+ "<h2>Address: </h2>";
			addAcctFormStr="<form action=\"http://localhost:8080/TMFBanking/AddAccountServlet\" method=\"post\">\r\n"
					+ "	<input type=\"submit\" value=\"Add Account\" />\r\n"
					+ "</form>";
			List<BankAccountDTO> acctList = dao.getAccountDetails(user.getUname());
			StringBuffer acctSb = new StringBuffer();
			acctSb.append("<form>");
			for(BankAccountDTO acct: acctList) {
				acctSb.append("<input type=\"radio\" id=\""+acct.getAccountNumber()+"\" name='acct_no_group'/>\r\n"
						+ "	<h2>"+acct.getAccountNumber()+"</h2> : <h2> "+acct.getIfscCode()+"</h2>\r\n"
						+ "	<h3>"+acct.getBankName()+"</h3>\r\n"
						+ "	<h3>"+acct.getAcctType()+"</h3> \r\n"
						+ "	<h3>"+acct.getCurrBalance()+"</h3>\r\n"
						+ "	<h3>last_txn_date</h3>");
			}
			acctSb.append("</form>");
			String stmtFormStr = "<form action='http://localhost:8080/TMFBanking/StmtServlet' method='post'>\r\n"
					+ "	start date: <input type='date' name='stmt_start_date' />\r\n"
					+ "	end date: <input type='date' name='stmt_end_date' />\r\n"
					+ "<input id='stmt_acct_number' type=\"hidden\" name=\"selected_bank_acct_number\" value='"+12345+"'/>"
					+ "	<input type='submit' />\r\n"
					+ "</form>";
			
					// + "<input type=\"hidden\" name=\"session_feild_id\"
					// value='"+user.getUserId()+"'/>"
			res = "<html><body>"+userInfoStr+addAcctFormStr+acctSb.toString()+stmtFormStr+logoutFormStr + "</body>\r\n" + "</html>";
		} else {
			res = "<html><body> Invalid User <form action='http://localhost:8080/TMFBanking/LoginServlet'>\r\n"
					+ "	<input type='submit' value=\"Login\"/>\r\n" + "</form> " + "</body></html>";
		}

//		Cookie ck = new Cookie("user_id", String.valueOf(user.getUserId()));// creating cookie object

		response.getWriter().append(res);
//		response.addCookie(ck);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
