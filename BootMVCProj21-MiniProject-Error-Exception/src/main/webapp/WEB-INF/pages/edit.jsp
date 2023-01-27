<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>

<h1 style="color: lime; text-align: center;">
	<b>Update Employee InforMation</b>
</h1>

<c:form modelAttribute="emp">
	<table align="center" border="1" bgcolor="cyan">
		<tr>
			<td>Employee No</td>
			<td><c:input path="empno"   readonly="true"/></td>
		</tr>
		<tr>
			<td>Employee Name</td>
			<td><c:input path="empname" /></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><c:input path="salary" /></td>
		</tr>
		<tr>
			<td>Employee Job</td>
			<td><c:input path="job" /></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Update"></td>
		</tr>

	</table>

</c:form>


<br>
<br>
<h1 style="color: lime; text-align: center;">
	<a alt="Img not fond" href="./"><img src="images/home.jpg"
		width="100" height="100"></a><a alt="Img not fond" href="report"><img
		src="images/report.png" width="100" height="100"></a>
</h1>