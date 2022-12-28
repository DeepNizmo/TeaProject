<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 26-12-22
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <title>Cart</title>
</head>
<body>
    <div class="container mx-auto mt-4">
        <c:forEach items="${items}" var="item">
                <div class="card mx-auto mt-4">
                    <div class="row">
                        <div class="col-md-4">
                            <img class="img-fluid rounded-start" src="<spring:url value='/images/greenTeaCategory.png'/>" alt="Card image cap">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${item.getName()}</h5>
                                <p class="card-text">Price : ${item.getUnitPrice()} €</p>
                                <form:form id="setQuantity"
                                           method="POST"
                                           action="/teaProject/cart/setQuantity"
                                           modelAttribute="cartItem">
                                    <form:input path="id" type="hidden" value="${item.getId()}"/>
                                    <form:input path="quantity" value="${item.getQuantity()}"/>
                                    <form:button class="btn btn-primary">Update</form:button>
                                </form:form>
                                <form:form id="removeItem"
                                           method="POST"
                                           action="/teaProject/cart/removeItem"
                                           modelAttribute="cartItem">
                                    <form:input path="id" type="hidden" value="${item.getId()}"/>
                                    <form:button class="btn btn-primary">Remove</form:button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
        </c:forEach>
        <h5>Total : ${currentCart.getTotalPrice()} €</h5>
    </div>
</body>
</html>
