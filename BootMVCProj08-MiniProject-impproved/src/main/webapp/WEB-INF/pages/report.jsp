<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<noscript>
     <h1 style="text-align: center;color: red;size: portrait;">Please Enable Java Script !!</h1> 
 </noscript>
<h1 style="text-align: center;color: orange;size: portrait;">Employee Report</h1>

<c:choose>
<c:when test="${!empty list}">
<table border="1" bgcolor="skyblue" align="center">
<tr><th> Employee No</th>
<th> Employee Name</th>
<th> Employee Job</th>
<th> Employee Salary</th></tr>
<c:forEach var="emp" items="${list}">
<tr>
<td>${emp.empno}</td> 
<td>${emp.empname}</td> 
<td>${emp.job}</td> 
<td>${emp.salary}</td> 
<td>
<a href="edit?empno=${emp.empno}"><img alt="image not found" src="images/edit.png" width="50" height="50"></a>
&nbsp;&nbsp;&nbsp;
<a onclick="return confirm('Do you Really want to delete !!')" href="delete?empno=${emp.empno}"><img alt="image not found" src="images/delete.png" width="50" height="50"></a>
</td>
</tr>
</c:forEach>
<tr>
</table>
</c:when>
<c:otherwise>
<h1 style="text-align: center;color: red;size: portrait;">Data not found</h1>
</c:otherwise>
</c:choose>

<c:if test="${!empty msg}">
	<h1 style="color: green;text-align: center;">${msg}</h1>
</c:if>
<h1 style="color: lime;text-align: center;"><a alt="Img not fond"href="./"><img src="images/home.jpg" width="50" height="50"></a>
&nbsp;&nbsp;&nbsp;
<a alt="Img not fond"href="register"><img src="images/add.png" width="50" height="50"></a></h1>



