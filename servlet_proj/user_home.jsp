<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.sat.tmf.ExpenseDAO" %>
<%@ page import="com.sat.tmf.UserExpenseDTO" %>
<%@ page import="java.io.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script>
window.onbeforeunload = function() { 
	document.getElementById("logoutForm").submit()
	
	};
</script>
</head>
<body>
	<div id="bodyDiv" class="center">
		<div>
			<% 	
				if(session.getAttribute("session_user_name") == null){
					response.sendRedirect("http://localhost:8080/FirstWebApp/user_login.html");
				}
				out.print(session.getAttribute("session_user_name"));
				
			%>
			<form id="logoutForm" action="http://localhost:8080/FirstWebApp/LogoutServlet">
				<input type="submit" value="LOGOUT" />
			</form>
		</div>
		<div>
			<form action="http://localhost:8080/FirstWebApp/ExpenseServlet" method="post" >
				<table>
					<tr>
						<td><input type='hidden' name='session_user_name' value='SATYA'/></td>
					</tr>
					<tr>
						<td>Expense Date:</td>
						<td><input type="date" name="exp_date"/></td>
						
						<td>Expense Category:</td>
						<td>
							<select name="exp_category">
								<%
									//String[] expCatArr = {"Food","Cloths","House Holds","Medicine&Hospital","Travel&Fuel","CAteOne","CatTwo","CatThree","CatFour"};
									List<String> expCatList = ExpenseDAO.getExpenseCategories();	
									for(int i=0;i<expCatList.size();i++){
								%>
										<option value="<% out.print(i); %>"><%out.print(expCatList.get(i)); %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<td>Expense Details:</td>
						<td><input type="text" name="exp_desc"/></td>
						
						<td>Expense Amount:</td>
						<td><input type="text" name="exp_amount"/></td>
					</tr>
					<tr>
						<td></td>
						
						<td colspan="2" style="text-align: center"><input type="submit" value="ADD EXPENSE"/></td>
						<td></td>
					</tr>
				</table>
			</form>

		</div>
		<div>
			<table border='1px'>
				<tr>
					<th>Date</th>
					<th>Exp Category</th>
					<th>Description</th>
					<th>Amount</th>
				</tr>
				
					<%
						if(session.getAttribute("userExpensesList") != null){
							for(UserExpenseDTO exp: (List<UserExpenseDTO>)session.getAttribute("userExpensesList")){
					%>
								<tr>
								<td><% out.print(exp.getExpDate()); %></td>
								<td><% out.print(exp.getExpCategory()); %></td>
								<td><% out.print(exp.getExpDesc()); %></td>
								<td><% out.print(exp.getExpAmount()); %></td>
								</tr>
					<%
							}
						}
					%>
					
					<%
						List<UserExpenseDTO> allExpList = new ArrayList<UserExpenseDTO>();
						String loggedInUser = (String)session.getAttribute("session_user_name");
						String rootPath = session.getServletContext().getRealPath("/");
						String filePath = rootPath+File.separator+"to_store_files"+File.separator+"temp_my_expenses";
						BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
			        	String line = "";
						while((line=br.readLine())!=null){
							if(line.substring(0, line.indexOf(",")) .equalsIgnoreCase(loggedInUser) ){
								String data[] = line.split(",");
					%>
								<tr>
								<td><% out.print(data[1]); %></td>
								<td><% out.print(data[2]); %></td>
								<td><% out.print(data[3]); %></td>
								<td><% out.print(data[4]); %></td>
								</tr>
					<%
								//out.print(line);
								out.print("</br>");
							}
							
						}
			        	
			            //out.print("No of Expenses:"+allExpList.size());
			        	
					%>
				
			</table>
		</div>
	</div>
</body>
</html>