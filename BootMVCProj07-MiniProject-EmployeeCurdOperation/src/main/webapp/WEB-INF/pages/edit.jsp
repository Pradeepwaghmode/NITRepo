<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: lime; text-align: center;">
	<b>Update Employee InforMation</b>
</h1>

<form method="Post" action="edit">
	<table align="center" border="1" bgcolor="cyan">
		<tr>
			<td>Employee No</td>
			<td><input type="text" name="empno" value="${empno}"></td>
		</tr>
		<tr>
			<td>Employee Name</td>
			<td><input type="text" name="empname" value="${empname}"></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><input type="text" name="salary" value="${salary}"></td>
		</tr>
		<tr>
			<td>Employee Job</td>
			<td><input type="text" name="job" value="${job}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Update"></td>
		</tr>

	</table>

</form>


<br>
<br>
<h1 style="color: lime; text-align: center;">
	<a alt="Img not fond" href="./"><img src="images/home.jpg"
		width="100" height="100"></a><a alt="Img not fond" href="report"><img
		src="images/report.png" width="100" height="100"></a>
</h1>