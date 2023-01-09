<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" />
<noscript>
     <h1 style="text-align: center;color: red;size: portrait;">Please Enable Java Script !!</h1> 
 </noscript>
 <div class="container">
<h1 style="text-align: center;color: orange;size: portrait;">Employee Report</h1>

<c:choose>
<c:when test="${!empty list.getContent()}">
<!-- <table border="1" bgcolor="skyblue" align="center"> -->
<table border="1" class="table table-hover" >
<tr class="bg-Secondary"><th> Employee No</th>
<!-- <tr bgcolor="pink"><th> Employee No</th> -->
<th> Employee Name</th>
<th> Employee Job</th>
<th> Employee Salary</th>
<th> &nbsp;&nbsp;&nbsp;Edit  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;Delete</th></tr>
<c:forEach var="emp" items="${list.getContent()}">
<tr class="bg-Light">
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
<p align="center">

 <c:if test="${!list.isFirst()}">
 <a href="report?page=0">  Frist</a>&nbsp;&nbsp;&nbsp;
 </c:if>

<c:if test="${list.hasPrevious()}">
 <a href="report?page=${list.getPageable().getPageNumber()-1}">  Previous</a>&nbsp;&nbsp;&nbsp;
 </c:if>

<c:forEach var="i" begin="1" end="${list.getTotalPages()}" step="1">
	[<a href="report?page=${i-1}">${i}</a>]&nbsp;&nbsp;&nbsp;
</c:forEach>

<c:if test="${list.hasNext()}">
 <a href="report?page=${list.getPageable().getPageNumber()+1}">Next </a>&nbsp;&nbsp;&nbsp;
 </c:if>
 
 <c:if test="${!list.isLast()}">
 <a href="report?page=${list.getTotalPages()-1}">  Last</a>&nbsp;&nbsp;&nbsp;
 </c:if>
</p>
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

</div>

