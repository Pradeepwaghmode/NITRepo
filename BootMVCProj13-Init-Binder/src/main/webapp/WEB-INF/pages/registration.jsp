<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="text-align: center;size: portrait;color: teal;">Registration Form </h1>
<form:form modelAttribute="pp">

	<table bgcolor="cyan" align="center">
		
		<tr>
			<td>Politician Name ::</td>
			<td><form:input path="pname"/></td>
		</tr>
		
		<tr>
			<td>Politician party ::</td>
			<td><form:input path="party"/></td>
		</tr>
		
		<tr>
			<td>Politician DOB ::</td>
			<td><form:input path="dob" type="date"/></td>
		</tr>
		
		<tr>
			<td>Politician DOJ ::</td>
			<td><form:input path="doj" type="date"/></td>
		</tr>
		
		<tr>
			<td>Politician  is Contitution Post ::</td>
			<td><form:radiobutton path="conspost" value="true"/>Yes &nbsp;&nbsp;
				<form:radiobutton path="conspost" value="false"/>No
			</td>
		</tr>
		
			<tr>
			<td><input type="submit" value="register"></td>
		</tr>
		
	</table>
</form:form>