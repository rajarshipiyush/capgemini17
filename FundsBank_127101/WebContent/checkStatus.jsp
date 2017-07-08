<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 center>Funds Bank Limited</h3>
<br>
<h4>Check Status</h4>
<form:form action="retrievecomplaint.obj" modelAttribute="statusComplaint" method="get">
<table>
	<tr>
		<td>Complaint Id:</td>
		<td><form:input path="complaintId"/></td>
		<td><input type="submit" value="Check Status"/>
	</tr>
</table>
</form:form>
<c:if test="${complaintStatus ne null}">
<table border="1">
		<tr>
			<th>Complaint Id</th>
			<th>Description</th>
			<th>Status</th>
		</tr>
		<tr>
			<td>${complaintStatus.complaintId}</td>
			<td>${complaintStatus.description}</td>
			<td>${complaintStatus.status}</td>
		</tr>
</table>
</c:if>
<a href="newComplaint.obj">Raise Complaint</a>
</body>
</html>