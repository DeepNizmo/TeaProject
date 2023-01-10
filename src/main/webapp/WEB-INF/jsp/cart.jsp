<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 26-12-22
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <div class="container mx-auto mt-4">
        <c:choose>
            <c:when test="${currentCart.getItems().size() > 0}">
                <c:set var="currency" value="€"/>
                <c:forEach items="${items}" var="item">
                    <div class="card mx-auto mt-4">
                        <div class="row">
                            <div class="col-md-4">
                                <img class="img-fluid rounded-start" src="<spring:url value='/images/greenTeaCategory.png'/>" alt="Card image cap">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">${item.getName()}</h5>
                                    <c:if test="${item.getUnitPrice() != item.getActualPrice()}">
                                        <h6 style="text-decoration-line: line-through">${item.getUnitPrice()} ${currency}</h6>
                                    </c:if>
                                    <h5>${item.getActualPrice()} ${currency}</h5>
                                    <form:form id="setQuantity"
                                               method="POST"
                                               action="/teaProject/cart/setQuantity"
                                               modelAttribute="cartItem">
                                        <form:input path="id" type="hidden" value="${item.getId()}"/>
                                        <form:label path="quantity"><spring:message code="quantity_label"/> : </form:label>
                                        <form:input path="quantity" value="${item.getQuantity()}"/>
                                        <form:button class="btn btn-primary"><spring:message code="edit_label"/></form:button>
                                    </form:form>
                                    <form:form id="removeItem"
                                               method="POST"
                                               action="/teaProject/cart/removeItem"
                                               modelAttribute="cartItem">
                                        <form:input path="id" type="hidden" value="${item.getId()}"/>
                                        <form:button class="btn btn-primary"><spring:message code="remove_label"/></form:button>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <h5><spring:message code="total_label"/> : ${currentCart.getTotalPrice()} ${currency}</h5>
                <br>
                <a class="btn btn-primary" href="<spring:url value="/order"/>"><spring:message code="order_label"/></a>
            </c:when>
            <c:otherwise>
                <h1><spring:message code="empty_cart"/> !</h1>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
