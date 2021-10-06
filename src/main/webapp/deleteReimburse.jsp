<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.ReimburseDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String reID = (String)request.getParameter("reID");
ReimburseDAO reDAO = new ReimburseDAO();
reDAO.delete(reID);

%>

<script type="text/javascript">
window.location.href="http://localhost:8080/ReimbursementApp/reimburseList.jsp"
</script>
</body>
</html>