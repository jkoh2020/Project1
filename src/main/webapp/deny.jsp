<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Reimbursement"%>
<%@page import="controller.ReimburseDAO" %>

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
int reID = (int)Integer.parseInt(request.getParameter("reID"));

ReimburseDAO reDAO = new ReimburseDAO();

Reimbursement user = reDAO.status(reID);

%>



<div class="form">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: slateblue">
			
			<ul class="navbar-nav">
				<li><a href="reimburseList.jsp"
					class="nav-link" style="color:black">Back</a></li>
			</ul>
		</nav>
	</header>
	<br />
	<h2 style="color: red"> DENY CONFIRMATION</h2>	
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
	<form action="ApproveServlet" method="post">
		<!-- <input type="text"  placeholder="Enter Employee id" name="id" /><br /> -->
		 <label>Reimbursement No.</label>
		<fieldset class="form-group" >
		<input type="text"  class="form-control" name="reID"  value="<%=reID%>" /><br />
		</fieldset>
		
		<label>Name</label>
		<fieldset class="form-group">
		<input type="text"  class="form-control" name="name" value="<%=user.getName()%>"  />
		</fieldset>
		
		<fieldset class="form-group">
		<label>Title</label>
		<input type="text"   class="form-control" name="title" value="<%=user.getTitle()%>" />
		</fieldset>
		
		<label>Amount</label>
		<fieldset class="form-group">
		<input type="text"  class="form-control" name="amount" value="$<%=user.getAmount()%>" />
		</fieldset>
		
		<label for="description" ><b>Description</b></label><br /> 
        <input type="text" class="form-control" name="description" value="<%=user.getDescription()%>" />    
        
        <input type="hidden" name="status"  value="DENIED" />
        
        <label>Employee ID</label>
		<fieldset class="form-group">
		<input type="text"  class="form-control" name="id"  value="<%=user.getEmployeeID()%>" /><br />
		</fieldset>
		
		<input type="submit" value="CONFIRM DENY" class="btn btn-danger" /><br />	
	</form>
		</div>
		</div>
	</div>


</div>

</body>
</html>