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
		<td>Bill Number</td>
		<%-- <td>Consumer Number</td>--%>
		<td>current reading</td>
		<td>unit consumed</td>
		<td>net amount</td>
	</tr>
		<c:forEach items="${billdetails}" var = "blist">
		<tr>
			<td>${blist.bill_num}</td>
			<%--!<td>${blist.consumer_num}</td>--%>
			<td>${blist.cur_reading}</td>
			<td>${blist.unit_consumed}</td>
			<td>${blist.netamount}</td>										
		</tr>
		</c:forEach>
		<tr><td><a href="calculatebill.jsp">Generate next bill</a></td></tr>
</table>
<a href="index.html">HOME</a>
</body>
</html>