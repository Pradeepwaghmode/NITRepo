<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color: red;text-align: center;">Update Actor Information</h1><br>

<frm:form modelAttribute="actor"  >
<table bgcolor="cyan" align="center" border="0">
<tr>
<td>Actor Id :: </td>
<td><frm:input path="actorid" readonly="true" /></td>
</tr>

<tr>
<td>Actor Name :: </td>
<td><frm:input path="actorname"/></td>
</tr>

<tr>
<td>Actor Category :: </td>
<td><frm:input path="category"/></td>
</tr>

<tr>
<td>Actor Mobile No :: </td>
<td><frm:input path="mobileNo"/></td>

<tr align="center">
<td colspan="2"><input type="submit" value="Update"></td>
</tr>
		
</table>


</frm:form>
<br>
<h1 style="color: green; text-align: center;"> <a href="./">HOME </a></h1>