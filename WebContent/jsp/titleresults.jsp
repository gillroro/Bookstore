<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock By Title</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
</head>
<body>
	<h2>
		<b><i>Search Results - Title</i></b>
	</h2>
	<table id="myTable" class="tablesorter">
		<thead>
			<tr>
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Category</th>
				<th>Quantity</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="books" status="booksStatus">
				<tr>
					<s:if test="#booksStatus.even == true">
						<td style="background: #CCCCCC"><img 
							src="<s:property value ="image" />" width="90" height="60" /></td>
						<td style="background: #CCCCCC"><s:property value="title" /></td>
						<td style="background: #CCCCCC"><s:property value="author" /></td>
						<td style="background: #CCCCCC">&euro;<s:property
								value="price" /></td>
						<td style="background: #CCCCCC"><s:property value="category" /></td>
						<td style="background: #CCCCCC"><s:property value="quantity" /></td>
					</s:if>
					<s:elseif test="#booksStatus.first == true">
						<td><img src="<s:property value ="image" />" width="90" height="60" /></td>
						<td><s:property value="title" /></td>
						<td><s:property value="author" /></td>
						<td>&euro;<s:property value="price" /></td>
						<td><s:property value="category" /></td>
						<td><s:property value="quantity" /></td>
					</s:elseif>
					<s:else>
						<td><img src="<s:property value ="image" />" width="90" height="60" /></td>
						<td><s:property value="title" /></td>
						<td><s:property value="author" /></td>
						<td>&euro;<s:property value="price" /></td>
						<td><s:property value="category" /></td>
						<td><s:property value="quantity" /></td>
					</s:else>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>