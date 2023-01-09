<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 06-01-23
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <title>Order</title>
</head>
<body>
    <c:set var="currency" value="€"/>
    <div class="container mx-auto mt-4">
        <h1><spring:message code="confirm_order_check_message"/></h1>
        <br>
        <h3><spring:message code="confirm_order_products_label"/> : </h3>
        <br>
        <c:forEach items="${currentCart.getItems().values()}" var="item">
            <p>x${item.getQuantity()} ${item.getName()} ${item.getActualPrice()} ${currency}</p>
        </c:forEach>
        <br>
        <h5> total : ${currentCart.getTotalPrice()} ${currency}</h5>
        <br>
        <form:form
                id="conformOder"
                method="POST"
                action="/teaProject/order/confirmOrder"
                modelAttribute="order">
            <form:input path="paid" type="hidden" value="${false}"/>
            <form:button class="btn btn-primary"><spring:message code="confirm_order_label"/></form:button>
            <a class="btn btn-primary" href="<spring:url value="/cart"/>"><spring:message code="back_to_cart_label"/></a>
        </form:form>
    </div>
</body>
</html>
