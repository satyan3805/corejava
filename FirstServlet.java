package com.sat.tmf;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cijd_8216","root","root");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from expenses");  
			pw.append("<table border='1px'>");
			pw.append("<tr>");
			while(rs.next())  {
				
				pw.append("<td>");
				pw.append(rs.getString(1));
				pw.append("</td>");
				pw.append("<td>");
				pw.append(rs.getString(2));
				pw.append("</td>");
				pw.append("<td>");
				pw.append(rs.getString(3));
				pw.append("</td>");
				
			}
			pw.append("</tr>");
			pw.append("</table>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost Method:");
		doGet(request, response);
	}
	
	

}
