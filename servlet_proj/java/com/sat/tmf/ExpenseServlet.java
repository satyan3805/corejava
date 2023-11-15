package com.sat.tmf;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	BufferedWriter bw = null;
       
    public ExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserExpenseDTO> userExpDTOList = null;
		
		if(request.getSession().getAttribute("userExpensesList") != null) {
			userExpDTOList = (List<UserExpenseDTO>) request.getSession().getAttribute("userExpensesList");
		}else {
			userExpDTOList = new ArrayList<UserExpenseDTO>();
		}
		
		UserExpenseDTO tempObj= new UserExpenseDTO();
		
		tempObj.setExpDate(request.getParameter("exp_date"));
		tempObj.setExpCategory(request.getParameter("exp_category"));
		tempObj.setExpDesc("\""+request.getParameter("exp_desc")+"\"");
		tempObj.setExpAmount("\""+request.getParameter("exp_amount")+"\"");
		
		String rootPath = request.getServletContext().getRealPath("/");
		String filePath = rootPath+File.separator+"to_store_files"+File.separator+"temp_my_expenses";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath),true));
		//BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(new File(filePath),true),165537);
		String user = (String)request.getSession().getAttribute("session_user_name");
		if(user != null) {
			bw.write(user+","+tempObj.toString()+"\n");
		}
		
		
		bw.close();
		
//		userExpDTOList.add(tempObj);
//		request.getSession().setAttribute("userExpensesList", userExpDTOList);
		
		request.getRequestDispatcher("/user_home.jsp").include(request, response);
	}

}
