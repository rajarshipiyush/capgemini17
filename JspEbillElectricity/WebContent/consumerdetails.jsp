<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		
		<tr>
			<td>${consumerdetails.consumer_num}</td>
			<td>${consumerdetails.consumer_name}</td>
			<td>${consumerdetails.address}</td>
			<td><a href="EBillController?action=billdetails&id=${consumerdetails.consumer_num}">Bill Details</a>			
		</tr>		
</table>
<a href="index.html">HOME</a>
</body>
</html>