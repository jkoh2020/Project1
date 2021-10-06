<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>



<header>
		
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
	</header>
	<h3>Employee List</h3><br />
	<table class="table table-bordered">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Name</th>
						<th>Username</th>
						<th>Password</th>
						<th>Action</th>
						
					</tr>
					
				</thead>



<% 

try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "12345");
		PreparedStatement ps = con.prepareStatement("SELECT * from users");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			
			%>
			
			<tr>
			<td><%=rs.getInt("id") %></td>
			<td><%=rs.getString("name") %></td>
			<td><%=rs.getString("username") %></td>
			<td><%=rs.getString("password") %></td>
			<td>
			<a href="user-form.jsp?id=<%=rs.getInt("id")%>"><i class='fa fa-edit' style='font-size:20px'></i>Edit</a> 
			<a href="deleteUser.jsp?id=<%=rs.getInt("id")%>"><i class='fa fa-trash' style='font-size:21px;color:red'></i>Delete</a>
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