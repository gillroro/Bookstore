<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
Edit Customer <br />


<s:form action="updateCustomer">
	<s:textfield value="%{name}" label="Name:" />
	<s:textfield value="%{address}" label="Address" />
	<s:textfield value="%{email}" label="Email" />
	<s:textfield value="%{password}" label="Password" />
	
	<s:submit value="Update" />
</s:form>

</body>
</html>