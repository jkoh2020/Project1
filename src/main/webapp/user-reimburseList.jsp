<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
</head>
<body>


<%
int id = (int)session.getAttribute("id");





%>
<header>
		
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black" >
			
			<div>
				<a href="#" class="navbar-brand"> 
					Welcome  </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="user-reimburseList.jsp?id=<%=id%>"
					class="nav-link" style="color:yellow">Reimbursement List</a></li>
			</ul>
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><form action='Logout'>
					<input type="submit" value="Logout" class="btn btn-primary" ><br>
				</form>
			</ul>
			
		</nav>
		
		<br />
		<form action='reimburseForm.jsp'>
		<input type="submit" value="Request Reimbursement" class="btn btn-primary">
		</form>
	
				
	</header>
	<br />
<h3>Reimbursement List</h3><br />
	<table class="table table-bordered">
				<thead>
					<tr>
						<th>Reimbursement No.</th>
						<th>Name</th>
						<th>Title</th>
						<th>Description</th>
						<th>Amount</th>
						<th>Status</th>
						<th>ID</th>
					
						
					</tr>
					
				</thead>



<% 

try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
	

	PreparedStatement ps = con.prepareStatement("SELECT * from rem where id = ?");
	
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	
		while(rs.next())
		{
			
			%>
			
			<tr>
			<td><%=rs.getInt("reID") %></td>
			<td><%=rs.getString("name") %></td>
			<td><%=rs.getString("title") %></td>
			<td><%=rs.getString("description") %></td>
			<td>$<%=rs.getString("amount") %></td>
			<td style="color: blue"><%=rs.getString("status") %></td>
			<td><%=rs.getString("id") %></td>
			
			</tr>
			<%
		
		}
	}catch(Exception e) {
		}
		

			%>

</table>

</body>
</html>