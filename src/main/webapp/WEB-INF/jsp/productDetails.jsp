<%--
  Created by IntelliJ IDEA.
  User: Wangi
  Date: 16-12-22
  Time: 07:33
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
    <h1>Details of the product</h1>
    <img src="<spring:url value='/images/greenTeaCategory.png'/>" class="rounded" alt="..." style="width: 35rem;" >
    <h5 class="card-title">Reference: ${productId}</h5>
    <h5 class="card-title">Name: ${product.getName()}</h5>
    <h5 class="card-title">Category: ${product.getCategory()}</h5>
    <h5 class="card-title">Price: ${product.getUnitPrice()} €</h5>
    <h5 class="card-title">Details: ${product.getDetails()}</h5>
</div>
</body>
</html>