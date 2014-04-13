<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>

Please select a payment method: 

<br />
<s:form action ="pay" >
<s:select label="Select a month" 
		headerKey="-1" headerValue="Select Payment Method"
		list="#{'1':'Credit Card', '2':'Paypal'}" 
		name="payment" 
		 />

<s:submit value = "Pay" />
</s:form>
</body>
</html>