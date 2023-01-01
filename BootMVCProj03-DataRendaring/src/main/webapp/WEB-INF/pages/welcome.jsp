<%@page isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<b>Model Data(Array) ::</b>
<br>
<b>Name :: ${name}</b>
<br>
<c:if test="${!empty favColors}">
	<c:forEach var="color" items="${favColors }">
	${color},
</c:forEach>
</c:if>
<br>

<c:if test="${!empty nickName }">
<c:forEach var="nikname" items="${nickName }" >
	${nikname },
</c:forEach>
</c:if><br>

<c:if test="${!empty phoneNo }">
<c:forEach var="phone" items="${phoneNo }">
		${phone},
</c:forEach>
</c:if>
<br>
<c:if test="${!empty idDetails}">
<c:forEach var="id" items="${idDetails}">
	${id.key} <----> ${id.value} 
</c:forEach>
</c:if>

