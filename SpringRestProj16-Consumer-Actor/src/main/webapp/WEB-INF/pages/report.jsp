<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color: red;align-content: center;text-align: center;">Report Page</h1><br>
<c:choose>
<c:when test="${!empty actorInfo}">

<table align="center" border="1" bgcolor="cyan">

<tr>
<th><b>Actor Id</b></th>
<th><b>Actor Name</b></th>
<th><b>Actor Category</b></th>
<th><b>Actor Mobile No</b></th>
<th><b>Actions</b></th>
</tr>

<c:forEach  var="act" items="${actorInfo}">

<tr>
<td>${act.actorid } </td>

<td>${act.actorname } </td>

<td>${act.category } </td>

<td>${act.mobileNo } </td>

<td>
<a href="edit?actid=${act.actorid}"><img alt="image not found" src="images/edit.png" width="50" height="50"></a>
&nbsp;&nbsp;&nbsp;
<a href="delete?actid=${act.actorid}" onclick="return confirm('Really you want to delete')"><img alt="image not found" src="images/delete.png" width="50" height="50"></a>
</td>

</tr>
</c:forEach>


</table>
<c:if test="${!empty msg}">
<h1 style="text-align: center;color: green;"><a href="save">${msg}</a></h1>
</c:if>
</c:when>
<c:otherwise>
<h1 style="color: red;align-content: center;text-align: center;" >Record Not Found !!</h1>
</c:otherwise>
</c:choose> 
<br>
<h1 style="text-align: center;color: red;"><a href="save">Register New Actor</a></h1>
<br>
<h1 style="color: green; text-align: center;"> <a href="./">HOME </a></h1>