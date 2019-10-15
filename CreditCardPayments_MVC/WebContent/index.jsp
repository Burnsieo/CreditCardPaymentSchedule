<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.CreditCard" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CreditCardStyleSheet.css" type="text/css" rel="stylesheet">
<title>Payment Schedule</title>
</head>
<body>
<h1>Credit Card Payment Schedule</h1>
<form name="paymentInformation" action="doCalculate" method="doPost">
	First name:<br>
	<input type="text" name="firstName"><br>
	Last name:<br>
	<input type="text" name="lastName"><br>
	Account number:<br>
	<input type="text" name="accountNumber"><br>
	Current balance:<br>
	<input type="text" name="currentBalance"><br>
	Percent payable monthly:<br>
	<input type="text" name="payoffRate"><br><br>
	<input type="submit" name="submit" value="Calculate Payments">
</form>
<footer>
  <p>Created by Ty Burns for MIST 4630</p>
</footer>
</body>
</html>