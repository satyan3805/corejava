package com.sat.tmf;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FetchUserExpensesServlet")
public class FetchUserExpensesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FetchUserExpensesServlet() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		ServletContext sContext = getServletContext();
		String sessionUserName = sContext.getAttribute("user_name").toString();
		System.out.println(sContext.getAttribute("user_name"));
		System.out.println(sContext.getContextPath());
		pw.print("<div>\r\n"
				+ "			<form action=\"http://localhost:8080/FirstWebApp/ExpenseServlet\" method=\"post\" >\r\n"
				+ "				<table>\r\n"
				+ "<tr>\r\n"
				+ "						<td><input type='hidden' name='session_user_name' value='"+ sessionUserName+"'/></td>\r\n"
				+ "					</tr>"
				+ "					<tr>\r\n"
				+ "						<td>Expense Date:</td>\r\n"
				+ "						<td><input type=\"date\" name=\"exp_date\"/></td>\r\n"
				+ "						\r\n"
				+ "						<td>Expense Category:</td>\r\n"
				+ "						<td>\r\n"
				+ "							<select name=\"exp_category\">\r\n"
				+ "								<option value=\"1\">Food</option>\r\n"
				+ "								<option value=\"2\">Cloths</option>\r\n"
				+ "								<option value=\"3\">House Holds</option>\r\n"
				+ "								<option value=\"4\">Medicine&Hospital</option>\r\n"
				+ "								<option value=\"5\">Travel&Fuel</option>\r\n"
				+ "							</select>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td>Expense Details:</td>\r\n"
				+ "						<td><input type=\"text\" name=\"exp_desc\"/></td>\r\n"
				+ "						\r\n"
				+ "						<td>Expense Amount:</td>\r\n"
				+ "						<td><input type=\"text\" name=\"exp_amount\"/></td>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td></td>\r\n"
				+ "						\r\n"
				+ "						<td colspan=\"2\" style=\"text-align: center\"><input type=\"submit\" value=\"ADD EXPENSE\"/></td>\r\n"
				+ "						<td></td>\r\n"
				+ "					</tr>\r\n"
				+ "				</table>\r\n"
				+ "			</form>\r\n"
				+ "			\r\n"
				+ "		</div>");
		
		pw.print("<table border='1px'>\r\n"
				+ "				<tr>\r\n"
				+ "					<th>Date</th>\r\n"
				+ "					<th>Exp Category</th>\r\n"
				+ "					<th>Description</th>\r\n"
				+ "					<th>Amount</th>\r\n"
				+ "				</tr>\r\n"
				+ "				<tr>\r\n"
				+ "					<td> 05-NOV-2023</td>\r\n"
				+ "					<td>FOOD</td>\r\n"
				+ "					<td>PIZZA</td>\r\n"
				+ "					<td>340.00</td>\r\n"
				+ "				</tr>\r\n"
				+ "			</table>");
		
		Cookie ck = new Cookie("user_name",(String) sContext.getAttribute("user_name"));
		response.addCookie(ck);
	}

}
