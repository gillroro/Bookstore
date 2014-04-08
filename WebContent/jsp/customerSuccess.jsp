<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home page</title>
</head>
<body>
Welcome to the Book Store <s:property value="email" />
<table>
<s:iterator value="books" status ="booksStatus" >
 <tr>
  	<s:if test="#booksStatus.even == true">
      <td style="background: #CCCCCC"><s:property value ="title" /></td>
	  <td style="background: #CCCCCC"><s:property value ="author" /></td>
	  <td style="background: #CCCCCC"><s:property value ="price" /></td>
	  <td style="background: #CCCCCC"><s:property value ="category" /></td>
	  <td style="background: #CCCCCC"><s:property value ="image" /></td>
    </s:if>
    <s:elseif test="#booksStatus.first == true">
      <td><s:property value ="title"  /></td>
	  <td><s:property value ="author" /></td>
	  <td><s:property value ="price" /></td>
	  <td><s:property value ="category" /></td>
	  <td><s:property value ="image" /></td>
    </s:elseif>
    <s:else>
      <td><s:property value ="title"  /></td>
	  <td><s:property value ="author" /></td>
	  <td><s:property value ="price" /></td>
	  <td><s:property value ="category" /></td>
	  <td><s:property value ="image" /></td>
    </s:else>
  </tr>
</s:iterator>
</table>

<s:form action = "CustomerLogout" >
	<s:submit value = "Logout" theme= "simple"  />
</s:form>
</body>
</html>