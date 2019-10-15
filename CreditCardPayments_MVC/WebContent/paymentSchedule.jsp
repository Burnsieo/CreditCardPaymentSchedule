<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String html = (String) request.getAttribute("html");
%>
<!DOCTYPE html>
<html>
<head>
<link href="CreditCardStyleSheet.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Card Payment Schedule MVC</title>
</head>
<body>
<h1>Payment Schedule</h1>
<p><%= html %></p>

<p><a href="index.jsp">Calculate another payment</a></p>

<footer>
  <p>Created by Ty Burns for MIST 4630</p>
</footer>
</body>
</html>