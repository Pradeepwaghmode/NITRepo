<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color: fuchsia;text-align: center;border: thick;">Student Registration</h1>

<%-- <form:form  method="post" modelAttribute="stud"> --%>
<form:form   modelAttribute="stud">
<table align="center" bgcolor="cyan" >
<tr>
<td>Student No </td>
</tr>
<tr>
<td><form:input path="sno"/></td>
</tr>

<tr>
<td>Student Name </td>
</tr>
<tr>
<td><form:input path="sname"/> </td>
</tr>

<tr>
<td>Student address </td>
</tr>
<tr>
<td><form:input path="addr"/> </td>
</tr>

<tr>
<td>Student Average </td>
</tr>
<tr>
<td><form:input path="avg"/> </td>
</tr>


<tr>
<td colspan="2"><input type="submit" value="Register"> </td>
</tr>

</table>
</form:form>