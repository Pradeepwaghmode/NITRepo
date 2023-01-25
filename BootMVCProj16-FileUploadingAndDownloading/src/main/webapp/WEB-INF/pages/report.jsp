<%@ page  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red;text-align: center;background-color: green;"><a href="register">Report Page</a></h1>

<c:choose>
<c:when test="${!empty jsList}">

<table align="center" bgcolor="cyan" border="1">
<tr>
<th>JS ID</th><th>JS NAME</th><th>JS ADDRESS</th><th>RESUME</th><th>PHOTO</th>
</tr>

<c:forEach var="list" items="${jsList}">
<tr>
<td>${list.id}	</td>
<td>${list.jsname}	</td>
<td>${list.jsaddr}	</td>
<td><a href="download?jsid=${list.id}&type=resume">download Resume</a></td>
<td><a href="download?jsid=${list.id}&type=photo">download photo</a></td>
</tr>
</c:forEach>
</table>

</c:when>
<c:otherwise>Record not found !!</c:otherwise>
</c:choose>