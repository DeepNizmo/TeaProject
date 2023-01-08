<%--
  Created by IntelliJ IDEA.
  User: Wangi
  Date: 04-01-23
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
  <title>Login</title>
</head>
<body>
<div class="form login" style="color:white">
  <form:form method="post" modelAttribute="userModel" cssClass="login-form">
    <form:label path="username"><spring:message code="username_label"/> : </form:label>
    <form:input path="username" cssClass="login-input" required="required" placeholder="Enter username here"/>
    <form:errors path="username" />
    <form:label path="password"><spring:message code="password_label"/> : </form:label>
    <form:input type="password" cssClass="login-input" path="password" required="required" placeholder="Enter password here"/>
    <form:errors path="password" />
    <c:catch var="errorLogin"><div class="login-error-msg">${errorLogin}</div></c:catch>
    <form:button><spring:message code="login_label"/></form:button>
  </form:form>
  <a href="<c:url value='/register' />"><spring:message code="sign_up_label"/></a>
  <a href="<c:url value='/home' />"><spring:message code="cancel_label"/></a>
</div>
</body>
</html>


