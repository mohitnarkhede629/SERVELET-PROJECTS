<%@page import="com.technoelevate.employee_registration.employee.Employee"%>
<%@page import="org.hibernate.MultiIdentifierLoadAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
			
			<%Employee s =(Employee) request.getAttribute("empid"); %>
			<%=s %>
			
			<a href="changedetails" >EDIT</a>
			<br>
			<br>
			
		<!-- <form action="" method="post" >
		<input type="number" name="empid" placeholder="Enter your emp id">
		<input type="text" name="name" placeholder="Enter your name">
		<input type="email" name="email" placeholder="Enter your email id">
		<input type="submit" value="submit">
		</form> -->
</body>
</html>