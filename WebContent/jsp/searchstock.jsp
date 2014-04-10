<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Stock</title>
</head>
<body>
<h5><b><i>Search By Category</i></b></h5>
<s:form action="StockByCategory">
	<s:textfield name="category" value="category" />
	<s:submit value="Search" />
</s:form>
<s:form action="StockByAuthor">
	<s:textfield name="author" value="author" />
	<s:submit value="Search" />
</s:form>

</body>
</html>