<%--
  Created by IntelliJ IDEA.
  User: Wangi
  Date: 16-12-22
  Time: 07:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <c:set var="currency" value="€"/>
        <div class="container mx-auto mt-4">
            <h1><spring:message code="product_details_label"/></h1>
            <img src="<spring:url value='/images/greenTeaCategory.png'/>" class="rounded" alt="..." style="width: 35rem;" >
            <h5 class="card-title"><spring:message code="reference_label"/> : ${productId}</h5>
            <h5 class="card-title"><spring:message code="name_label"/> : ${product.getName()}</h5>
            <h5 class="card-title"><spring:message code="category_label"/> : ${product.getCategory()}</h5>
            <c:if test="${product.getReducedPrice() != null}">
                <h5 style="text-decoration-line: line-through"><spring:message code="price"/> : ${product.getUnitPrice()} ${currency}</h5>
            </c:if>
            <h5><spring:message code="price"/> : ${product.getActualPrice()} ${currency}</h5>
            <h5 class="card-title"><spring:message code="details_label"/> : ${product.getDetails()}</h5>
            <form:form id="addToCart"
                       method="POST"
                       action="/teaProject/tea-product/details/addToCart"
                       modelAttribute="cartItem">
                <form:input path="id" type="hidden" value="${product.getId()}"/>
                <form:input path="name" type="hidden" value="${product.getName()}"/>
                <form:input path="unitPrice" type="hidden" value="${product.getUnitPrice()}"/>
                <form:input path="details" type="hidden" value="${product.getDetails()}"/>
                <form:input path="category" type="hidden" value="${product.getCategory()}"/>
                <form:input path="quantity" type="hidden" value="${1}"/>
                <form:input path="actualPrice" type="hidden" value="${product.getActualPrice()}"/>
                <c:if test="${product.getReducedPrice() != null}">
                    <form:input path="reducedPrice" type="hidden" value="${product.getReducedPrice()}"/>
                </c:if>
                <form:button class="btn btn-primary"><spring:message code="add_to_cart_label"/></form:button>
            </form:form>
        </div>
    </body>
</html>