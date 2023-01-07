<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>

<noscript>
	<h1 style="color: red; text-align: center;">
		<b>Please Enable java Script</b>
	</h1>
</noscript>

<h1 style="color: lime; text-align: center;">
	<b>Update Employee InforMation</b>
</h1>

<script lang="javaScript" src="js/registrationValidator.js"></script>
<style>
.error {
	color: red
}
</style>

<c:form modelAttribute="emp" onsubmit="return validation(this)" cssClass="error">
	<table align="center" border="1" bgcolor="cyan">
		<tr>
			<td>Employee No</td>
			<td><c:input path="empno" readonly="true" /></td>
		</tr>
		<tr>
			<td>Employee Name</td>
			<td><c:input path="empname" /><c:errors cssStyle="color:red" path="empname"/><span id="empnameErr"></span></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><c:input path="salary" /><c:errors cssStyle="color:red" path="salary"/><span id="salaryErr"></span></td>
		</tr>
		<tr>
			<td>Employee Job</td>
			<td><c:input path="job" /><c:errors cssStyle="color:red" path="job"/><span id="jobErr"></span></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Update"></td>
		</tr>

	</table>
	<c:input path="vflag" /><span id="flag"></span>
</c:form>


<br>
<br>
<h1 style="color: lime; text-align: center;">
	<a alt="Img not fond" href="./"><img src="images/home.jpg"
		width="100" height="100"></a><a alt="Img not fond" href="report"><img
		src="images/report.png" width="100" height="100"></a>
</h1>