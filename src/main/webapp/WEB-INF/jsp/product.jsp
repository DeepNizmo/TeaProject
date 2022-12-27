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
            <c:forEach items="${productsList}" var="product">
                <div class="col-md-4">
                    <div class="card" style="width: 18rem;">
                        <img src="<spring:url value='/images/greenTeaCategory.png'/>" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${product.getName()}</h5>
                            <h6 class="card-title">${product.getCategory()}</h6>
                            <h6 class="card-title">${product.getUnitPrice()} €</h6>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
