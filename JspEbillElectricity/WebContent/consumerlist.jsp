<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>Consumer Number</td>
		<td>Consumer Name</td>
		<td>Address</td>
		<td>Bill details page</td>
	</tr>
		<c:forEach items="${consumerlist}" var = "clist">
		<tr>
			<td>${clist.consumer_num}</td>
			<td>${clist.consumer_name}</td>
			<td>${clist.address}</td>
			<td><a href="EBillController?action=billdetails&id=${clist.consumer_num}&name=${clist.consumer_name}">Bill Details</a>						
		</tr>
		</c:forEach>		
</table>
<a href="index.html">HOME</a>
</body>
</html>