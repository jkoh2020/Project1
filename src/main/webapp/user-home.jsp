<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*"%>
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
</body>
</html>
