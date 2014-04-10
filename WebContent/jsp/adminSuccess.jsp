<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body>

<h5>Register New Administrator</h5>

	<s:form action="AdminRegister">
		<s:textfield name="name" value="Name" theme="css_xhtml" />
		<s:textfield name="email" value="Email" theme="css_xhtml" />
		<s:password name="password" value="password" showPassword="true" theme="css_xhtml"/>
		<s:submit value="Register" theme="simple" />
	</s:form>

<h5>Add Book to Store</h5>
<s:form action="AddBook">
	<s:textfield name="title" value="Title" theme="css_xhtml" />
	<s:textfield name="author" value="Author" theme="css_xhtml" />
	<s:textfield name="price" value="Price" theme="css_xhtml" />
	<s:textfield name="category" value="Category" theme="css_xhtml" />
	<s:textfield name="image" value="Image" theme="css_xhtml" />
	<s:textfield name="quantity" value="Quantity" theme="css_xhtml" />
	<s:submit value="Add Book" theme="simple" />
</s:form>

<h5><b><i>Stock</i></b></h5>
<s:form action="ViewStock" >
	<s:submit name="ViewStock" value="View Stock" />
</s:form>
<s:form action="SearchStock" >
	<s:submit name="SearchStock" value="Search Stock" />
</s:form>
<h5><b><i>Customers</i></b></h5>
<s:iterator  value="customers">
	<a href="<s:url  />"><s:property value ="name" /></a><br />
</s:iterator>
<s:form action = "Logout" >
	<s:submit value = "Logout" theme= "simple"  />
</s:form>
</body>
</html>