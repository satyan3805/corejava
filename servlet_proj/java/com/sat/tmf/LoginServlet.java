package com.sat.tmf;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */


@WebServlet(
    urlPatterns = "/LoginServlet"
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig sConf = null;
       
    public LoginServlet() {
        super();
    }
    
    
	@Override
	public void init() throws ServletException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		
		ServletContext sContext = getServletContext();
		
		System.out.println("Context Path:"+sContext.getContextPath());
		Date dt = new Date();
		sContext.setAttribute("user_name","SATYA"+dt.getTime());
		request.getCookies();
		List<String> list = Collections.list(sContext.getInitParameterNames());
		
		for(String str:list) {
			System.out.println(str);
		}
		
		String userName = request.getParameter("user_name");
		String userPassword = request.getParameter("user_password");
		
		if(true) {
			
			response.sendRedirect("http://localhost:8080/FirstWebApp/FetchUserExpensesServlet");
			session.setAttribute("user_name", userName);
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("Login Servlet Destroyed");
	}

}
