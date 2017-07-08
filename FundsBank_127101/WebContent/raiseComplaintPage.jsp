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
<h5>Customer Complaint Request Form</h5>
<form:form action="insertComplaint.obj" modelAttribute="complaintRaise" method="get">
<table>
	<tr>
		<td><label>Account Id*</label></td>
		<td><form:input path="accountId"/></td>
	</tr>
	<tr>
		<td><label>Branch Code*</label></td>
		<td><form:input path="branchCode"/></td>
	</tr>
	<tr>
		<td><label>EmailId*</label></td>
		<td><form:input path="emailId"/></td>
	</tr>
	<tr>
		<td><label>Complaint Category*</label></td>
		<td>
			<form:select path="category"> 
			<form:option value="" label="Please Select"/>
			<form:options items="${complaintlist}"/>
  			</form:select>
  		</td>
	</tr>
	<tr>
		<td><label>Description*</label></td>
		<td><p><textarea name="description" rows="5" cols="20"></textarea></p></td>
	</tr>
	<tr><td center><input type="submit" value="Submit"/></td></tr>
</table>
</form:form>
<a href="checkStatusComplaint.obj">Check Status</a>
</body>
</html>