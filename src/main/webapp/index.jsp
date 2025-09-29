<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="model.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>

</head>
<body>

<%
//allow access only if session exists
/* Student student = null;
if(session.getAttribute("student") == null){
	response.sendRedirect("login.html");
}else student = (Student) session.getAttribute("student"); */
String studentName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("student")) studentName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}else{
	sessionID = session.getId();
}
%>
	<h1>Student Management App!</h1>
	<c:choose>
    <c:when test="${studentName != null and sessionID != null }">
    <h3>Hi <%=studentName %>, Login successful. </h3>
	
	<form action="<%=response.encodeURL("logout") %>" method="post">
	<input type="submit" value="Logout" >
	</form>
    </c:when>
    <c:otherwise>
        <a href="<%=response.encodeURL("student-form.jsp") %>"> Please Login</a>
    </c:otherwise>
</c:choose>
	
	


	
	
	
</body>
</html>