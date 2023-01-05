<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 20-12-22
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container mx-auto mt-4">
        <div class="row">
            <c:set var="currency" value="€"/>
            <c:forEach items="${productsList}" var="product">
                <a class="nav-link" href="tea-product/${product.getId()}"/>
                <div class="col-md-4">
                    <div class="card" style="width: 18rem;">
                        <img src="<spring:url value='/images/greenTeaCategory.png'/>" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${product.getName()}</h5>
                            <h6>${product.getCategory()}</h6>
                            <c:choose>
                                <c:when test="${product.getReducedPrice() != null}">
                                    <h6 style="text-decoration-line: line-through">${product.getUnitPrice()} ${currency}</h6>
                                    <h5>${product.getReducedPrice()} ${currency}</h5>
                                </c:when>
                                <c:otherwise>
                                    <h6>${product.getUnitPrice()} ${currency}</h6>
                                </c:otherwise>
                            </c:choose>
                            <form:form id="addToCart"
                                       method="POST"
                                       action="/teaProject/tea-product/addToCart"
                                       modelAttribute="cartItem">
                                <form:input path="id" type="hidden" value="${product.getId()}"/>
                                <form:input path="name" type="hidden" value="${product.getName()}"/>
                                <form:input path="unitPrice" type="hidden" value="${product.getUnitPrice()}"/>
                                <form:input path="details" type="hidden" value="${product.getDetails()}"/>
                                <form:input path="category" type="hidden" value="${product.getCategory()}"/>
                                <form:input path="quantity" type="hidden" value="${1}"/>
                                <c:if test="${product.getReducedPrice() != null}">
                                    <form:input path="reducedPrice" type="hidden" value="${product.getReducedPrice()}"/>
                                </c:if>
                                <form:button class="btn btn-primary">Add to cart</form:button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
