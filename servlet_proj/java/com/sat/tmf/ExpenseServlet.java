package com.sat.tmf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExpenseServlet
 */
@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] ck = request.getCookies();
		request.getParameter("session_user_name");
		for (int i=0;i<ck.length;i++) {
			System.out.println(ck[0].getName() + " ::" +ck[0].getValue());
		}
		request.getSession().getAttribute("user_name");
		System.out.println("TEST");
	}

}
