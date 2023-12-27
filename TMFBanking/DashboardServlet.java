package com.sat.tmf.bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		UserDTO user = (UserDTO)request.getAttribute("user");
		
		String res = "<html>\r\n"
		+ "<body>\r\n"
		+ "dashboard page for:<h2>"+request.getParameter("user_name")+ "</h2>\r\n"
		+ "dashboard page for:<h2>"+user.getFullName()+"::"+user.getAccountID()+"::"+user.getCurrBal()+user.getLastTxnDdatTime()+ "</h2>\r\n"
		+ "</body>\r\n"
		+ "</html>";
		response.getWriter().append(res);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
