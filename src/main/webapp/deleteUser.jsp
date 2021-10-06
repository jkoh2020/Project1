<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.UserDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String id = (String)request.getParameter("id");
UserDAO userDAO = new UserDAO();
userDAO.delete(id);
%>


<script type="text/javascript">
window.location.href="http://localhost:8080/ReimbursementApp/list.jsp"
</script>
</body>
</html>