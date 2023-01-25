<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>

<h1 style="color: red;text-align: center;background-color: green;">Registration Form</a></h1>

<frm:form modelAttribute="js" enctype="multipart/form-data">
<table style="bgcolor:skyblue;text-align:center;" border="2" align="center" bgcolor="cyan" >
<tr>
<td>Enter Name :: </td>
<td><frm:input path="jsname"/></td>
</tr>

<tr>
<td>Enter Address :: </td>
<td><frm:input path="jsaddr"/></td>
</tr>

<tr>
<td>Upload Resume :: </td>
<td><frm:input type="File" path="resume"/></td>
</tr>

<tr>
<td>Upload photo :: </td>
<td><frm:input type="File" path="photo"/></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Register"/></td>
</tr>
</table>

</frm:form>
<h1 style="color: red;text-align: center;background-color: green;"><a href="./">Home</a></h1>