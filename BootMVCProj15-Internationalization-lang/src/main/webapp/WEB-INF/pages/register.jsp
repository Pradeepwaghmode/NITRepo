<%@ page isELIgnored="false"  contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h1 style="color: red;text-align: center;"><c:message code="cust.Registration.title"></c:message></h1>
<br><br>

<form:form modelAttribute="emp">
<table align="center" bgcolor="cyan">
<tr>
<td><c:message code="cust.Registration.name"></c:message></td>
<td><form:input  path="empname"/></td>
</tr>
<td><c:message code="cust.Registration.addr"></c:message></td>
<td><form:input  path="addr"/></td>
</tr>
<td><c:message code="cust.Registration.billAmt"></c:message></td>
<td><form:input  path="billAmt"/></td>
</tr>
<td colspan="2" align="center"><input  type="submit" value="<c:message code="cust.button.register"></c:message>"/></td>
</tr>
</table>
</form:form>
    
 <br><br>
<p align="center">
<a href="?lang=gu_IN">ગુજરાતી</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=hi_IN">हिंदी</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=mar_IN">मराठी</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;
</p>

<br><br>
<a href="./" algin="center">Home</a>