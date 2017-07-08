<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EBillController?action=calculatebill&id=${cons_num}" method = "post">
	<table>
		<tr>
			<td><label>Consumer Number</label>
			<input type="text" name ="consnum" value="${cons_num}"/></td>
		</tr>
		<tr>
			<td><label>current meter reading</label>
			<input type="text" name="cmred"></td>
			
		</tr>
		<tr>
			<td><label>last month meter reading</label>
			<input type="text" name = "lmred"/></td>
			<td></td>
			<td><input type = "submit" value = "calculateBill"/></td>
		</tr>
</table>
</form>
</body>
</html>