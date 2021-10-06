<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.UserAccount"%>
<%@page import="controller.UserDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reimbursement</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>


<%
int id = (int)session.getAttribute("id");


UserDAO userDAO = new UserDAO();

UserAccount user = userDAO.getUser(id);


%>



<div class="form">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			
			<ul class="navbar-nav">
				<li><a href="user-home.html"
					class="nav-link">Back</a></li>
			</ul>
		</nav>
	</header>
	<h2>Reimbursement Request</h2>	
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
	<form action="ReimburseServlet" method="post">
		<!-- <input type="text"  placeholder="Enter Employee id" name="id" /><br /> -->
		<label>Employee ID</label>
		<fieldset class="form-group">
		<input type="text"  placeholder="Enter Employee ID"  class="form-control" name="id" value="<%=id%>" required />
		</fieldset>
		
		<label>Name</label>
		<fieldset class="form-group">
		<input type="text"  placeholder="Enter name"  class="form-control" name="name" required value="<%=user.getName()%>" />
		</fieldset>
		
		<fieldset class="form-group">
		<label>Title</label>
		<input type="text"  placeholder="Enter title"  class="form-control" name="title" required />
		</fieldset>
		<label>Amount</label>
		<fieldset class="form-group">
		<input type="text" placeholder="Enter amount" class="form-control" name="amount" required />
		</fieldset>
		<label for="description"><b>Description</b></label><br />
        <textarea id="description" name="description" required
            rows = "5"
            cols = "50">
        </textarea><br />
        <input type="hidden" name="status" value="pending" />
		
		<input type="submit" value="Submit"><br />	
	</form>
		</div>
		</div>
	</div>


</div>

</body>
</html>