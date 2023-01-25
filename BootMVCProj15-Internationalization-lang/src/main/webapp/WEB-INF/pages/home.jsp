<%@ page isELIgnored="false"  contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<h1 style="color: red;text-align: center;"><c:message code="home.title"></c:message></h1>
<br><br>
<h1>Current Locale:: ${pageContext.response.locale}</h1>
<br><br>
<jsp:useBean id="dt" class="java.util.Date"></jsp:useBean>
<fmt:formatDate var="fdt" value="${dt}" type="date" dateStyle="Full"/>
Formated date is :: ${fdt}
<br>
<fmt:formatDate var="tdt" value="${dt}" type="time" dateStyle="Full"/>
Formated time is :: ${tdt}

<br>
<fmt:formatNumber var="no" value="1000" type="number"  />
Formated number is :: ${no}
<br>

<fmt:formatNumber var="cur" value="1000" type="currency"  />
Formated currency is :: ${cur}
<br>

<fmt:formatNumber var="per" value="0.5" type="percent"  />
Formated currency is :: ${per}
<br>

<h1 style="color:red;text-align: center;"><a href="register"><c:message code="home.link"></c:message></a></h1>
<br><br>
<p align="center">
<a href="?lang=gu_IN">ગુજરાતી</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=hi_IN">हिंदी</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=mar_IN">मराठी</a>&nbsp;&nbsp;&nbsp;
<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;
</p>