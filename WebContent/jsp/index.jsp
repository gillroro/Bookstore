<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
</head>
<body>
<center>
	<img src="http://www.bookwormroom.com/wp-content/uploads/2014/03/Welcome-mat.jpg"  width="400" height="200" >
	<h4>Welcome to the Book Store</h4>

		<div class="center">
			<h5>Customer Login:</h5>
			<s:form action="CustomerLoginAction">
				<s:textfield name="Email" value="Email" theme="css_xhtml" />
				<s:password name="Password" value="Password" showPassword="true"
					theme="css_xhtml" />
				<s:submit value="Login" theme="simple" />
			</s:form>
			<h5>Admin Login</h5>
			<s:form action="AdminLoginAction">
				<s:textfield name="Email" value="Email" theme="css_xhtml" />
				<s:password name="Password" value="Password" showPassword="true"
					theme="css_xhtml" />
				<s:submit value="Login" theme="simple" />
			</s:form>
			<h5>New Customer - Register?</h5>
			<s:form action="CustomerRegister">
				<s:textfield name="name" value="Name" theme="css_xhtml" />
				<s:textfield name="address" value="Address" theme="css_xhtml" />
				<s:textfield name="email" value="Email" theme="css_xhtml" />
				<s:password name="password" value="password" showPassword="true"
					theme="css_xhtml" />
				<s:submit value="Register" theme="simple" />
			</s:form>

		</div>
	</center>
</body>
</html>