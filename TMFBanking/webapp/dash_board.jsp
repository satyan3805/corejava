<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.sat.tmf.bank.dto.UserDTO"%>
<%@ page import="com.sat.tmf.bank.dao.TMFBankDAO"%>
<%@ page import="com.sat.tmf.bank.dto.BankAccountDTO"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% UserDTO user = (UserDTO) session.getAttribute("user"); %>
	<h1 style="text-align: center">
		<% out.print(user.getFullName().toUpperCase()); %>'s Dashboard
	</h1>
	<%! int x=50; %>

	<div style="display: flex; justify-content: space-between;">
		<h2>
			PhNo:<%= "+91-"+user.getPhno() %>
		</h2>
		<h2>
			Email:<% out.print(user.getEmail()); %>
		</h2>
		<h2>
			Address:<% out.print(user.getAddress()); %>
		</h2>
	</div>


	<form action="" method="post">
		<input type="submit" value="Add Account" />
	</form>

	<%
	TMFBankDAO dao = new TMFBankDAO();
	List<BankAccountDTO> acctList = dao.getAccountDetails(user.getUname());
	%>
	<form>
		<table>
			<%
			for (BankAccountDTO acct : acctList) {
			%>
			<tr>
				<td><input type="radio"
					id="<%out.print(acct.getAccountNumber());%>" name='acct_no_group' />
				</td>
				<td>
				<div style="display: flex; justify-content: space-between;">
					<h2>
						<% out.print(acct.getAccountNumber());%>:
					</h2> 
					<h2>
						<% out.print(acct.getIfscCode()); %>
					</h2>
				</div>	
				</td>
			</tr>

			<tr>
				<td>
				</td>
				<td>
				<div style="display: flex; justify-content: space-between;">
					<h3>
						<% out.print(acct.getBankName()); %>
					</h3>
					<h3>
						<% out.print(acct.getAcctType()); %>
					</h3>
					<h3>
						<% out.print(acct.getCurrBalance()); %>
					</h3>
					<h3>last_txn_date</h3>
					</div>
				</td>
			</tr>
			<%
		}
		%>
		</table>
	</form>
</body>
</html>