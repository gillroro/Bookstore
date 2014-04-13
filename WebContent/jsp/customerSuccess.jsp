<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home page</title>
</head>
<body>
	Welcome to the Book Store
	<s:property value="email" />
	<br />
	<br />

	<s:form action="SearchStock">
		<s:submit name="SearchStock" value="Search Stock" theme="simple" />
	</s:form>

	<s:form action="CustomerLogout">
		<s:submit value="Logout" theme="simple" />
	</s:form>
	<br />
	<br />
	<table>
		<thead>
			<tr>
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Category</th>
				<th>Quantity</th>
				<th>Options</th>
				<th>Rate</th>
			</tr>
		</thead>
		<s:form action="addToCart">
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
						<td style="background: #CCCCCC"><s:form action="addToCart">
								<s:checkbox name="checkMe" theme="simple" />
								<s:submit value="Add To Cart" theme="simple" />
							</s:form><br /> <s:form action ="reviewBook">
								<s:checkbox name="reviewMe" theme="simple" />
								<s:submit value="Review" theme="simple" />
							</s:form></td>



					</s:if>
					<s:elseif test="#booksStatus.first == true">
						<td><img src="<s:property value ="image" />" width="90"
							height="60" /></td>
						<td><s:property value="title" /></td>
						<td><s:property value="author" /></td>
						<td>&euro;<s:property value="price" /></td>
						<td><s:property value="category" /></td>
						<td><s:property value="quantity" /></td>
						<td><s:form action="addToCart">
								<s:checkbox name="checkMe" theme="simple" />
								<s:submit value="Add To Cart" theme="simple" />
							</s:form><br /> <s:form action ="reviewBook">
								<s:checkbox name="reviewMe" theme="simple" />
								<s:submit value="Review" theme="simple" />
							</s:form></td>

					</s:elseif>
					<s:else>
						<td><img src="<s:property value ="image" />" width="90"
							height="60" /></td>
						<td><s:property value="title" /></td>
						<td><s:property value="author" /></td>
						<td>&euro;<s:property value="price" /></td>
						<td><s:property value="category" /></td>
						<td><s:property value="quantity" /></td>
						<td><s:form action="addToCart">
								<s:checkbox name="checkMe" theme="simple" />
								<s:submit value="Add To Cart" theme="simple" />
							</s:form><br /> <s:form action ="reviewBook">
								<s:checkbox name="reviewMe" theme="simple" />
								<s:submit value="Review" theme="simple" />
							</s:form></td>

					</s:else>
				</tr>
			</s:iterator>
		</s:form>
	</table>

	<br />
	<br />

</body>
</html>