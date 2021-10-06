<%@page import="model.UserAccount"%>
<%@page import="controller.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<%


int id = (int)Integer.parseInt(request.getParameter("id"));

UserDAO userDAO = new UserDAO();

UserAccount user = userDAO.getUser(id);


%>




	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			
			<ul class="navbar-nav">
				<li><a href="admin-home.html"
					class="nav-link">Back</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="EditServlet" method="post"> 
				<caption>
					<h2>Edit Employee</h2>
				</caption>
				<fieldset class="form-group">
					<label>Employee ID</label>
					<input type="text" name="id" value="<%=id%>"/>
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Name</label> 
					<input type="text"  class="form-control" name="name" value="<%=user.getName()%>" />
				</fieldset>

				<fieldset class="form-group">
					<label>Username</label> 
					<input type="text"  class="form-control" name="username" value="<%=user.getUsername()%>" />
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> 
					<input type="text"  class="form-control" name="password" value="<%=user.getPassword()%>" />
				</fieldset>

				<button type="submit" class="btn btn-success">Edit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
