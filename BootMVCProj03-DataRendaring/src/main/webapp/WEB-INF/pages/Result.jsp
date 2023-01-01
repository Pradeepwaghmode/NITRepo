<%@page isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!-- <b>Model Class Data ::</b> -->

<!-- <br> -->
<%-- <c:if test="${!empty prodData}"> --%>

<%-- 	<b>Id :: ${prodData.id} </b><br> --%>
<%-- 	<b>Product Name :: ${prodData.pname} </b><br> --%>
<%-- 	<b>Price  :: ${prodData.price} </b><br> --%>
<%-- 	<b>Quentity  :: ${prodData.qty} </b><br> --%>

<%-- </c:if> --%>
<br>
<b>List Of Model Class Data ::</b>
<br>
<c:if test="${!empty prodData}">
<table bgcolor="cyan"  align="center"  border="1" >
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product qty</th>

</tr>

<c:forEach var="prod" items="${prodData }">
	<tr>
	<td>${prod.id}</td>
	<td>${prod.pname}</td>
	<td>${prod.price}</td>
	<td>${prod.qty}</td>
	</tr>
</c:forEach>
</table>
</c:if>
