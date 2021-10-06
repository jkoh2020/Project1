<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reimbursement List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato" >
			
			<div>
				<a href="#" class="navbar-brand"> 
					Financial Manager </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="list.jsp"
					class="nav-link" style="color:white">Employees List</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="reimburseList.jsp" class="nav-link" style="color:white">Reimbursement List</a></li>
			</ul>
			
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li> <form action='Logout'>
					<input type="submit" value="Logout" class="btn btn-primary" ><br>
				</form>
			</ul>			
		</nav>
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
						<th>Action</th>
					
						
					</tr>
					
				</thead>



<% 

try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
		PreparedStatement ps = con.prepareStatement("SELECT * from rem");
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
			<td style="color:blue"><%=rs.getString("status") %></td>
			<td><%=rs.getInt("id") %></td>
			<td>
			<a href="approve.jsp?reID=<%=rs.getInt("reID")%>">Approve</a> |
			<a href="deny.jsp?reID=<%=rs.getInt("reID")%>">Deny</a> |
			<a href="deleteReimburse.jsp?reID=<%=rs.getInt("reID")%>"><i class='fa fa-trash' style='font-size:21px;color:red'></i>Delete</a>
			</td>
			
			</tr>
			<%
		}
	}catch(Exception e) {
		}
		
			
			%>

</table>

</body>
</html>