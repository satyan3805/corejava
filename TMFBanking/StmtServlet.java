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
 * Servlet implementation class StmtServlet
 */
@WebServlet("/StmtServlet")
public class StmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stmtStr ="";
		//String tmpSessionId=request.getParameter("session_feild_id");
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		
		String logoutFormStr ="<form action='http://localhost:8080/TMFBanking/LogoutServlet'>\r\n"
				+ "	<input type='submit' value=\"Logout\"/>\r\n"
				+ "</form>";
		
		String goHomeFormStr = "<form action='http://localhost:8080/TMFBanking/DashboardServlet' method='post'>\r\n"
				//+ "	<input type=\"hidden\" name=\"session_feild_id\" value='"+tmpSessionId+"'/>\r\n"
				+ "	<input type='submit' value=\"Go Home\" />\r\n"
				+ "</form>";
		try {
			
			//System.out.println(tmpSessionId);
			
			if(user !=null) {
				stmtStr = "Stetement for user "+user.getUname()+" is generated"
						+logoutFormStr;
			}else {
				stmtStr = "Invalid User"
						+"<html><body> Invalid User <form action='http://localhost:8080/TMFBanking/LoginServlet'>\r\n"
						+ "	<input type='submit' value=\"Login\"/>\r\n"
						+ "</form> "
						+"</body></html>";
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
			stmtStr = "Invalid Request"+"<html><body> Invalid User <form action='http://localhost:8080/TMFBanking/LoginServlet'>\r\n"
					+ "	<input type='submit' value=\"Login\"/>\r\n"
					+ "</form> "
					+"</body></html>";;
		}finally {
			response.getWriter().append("<html><body>").append(stmtStr).append(goHomeFormStr).append("</body></html>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
