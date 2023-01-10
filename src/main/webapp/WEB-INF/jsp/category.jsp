<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 09-11-22
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <title>Tea categories</title>
</head>
<body>
    <div class="container mx-auto mt-4">
        <div class="row">
            <c:forEach items="${categoryList}" var="category">
                <a class="nav-link" href="<spring:url value="/tea-product/${category.getCategoryId()}"/>"/>
                    <div class="col-md-4">
                        <div class="card" style="width: 18rem;">
                            <img src="<spring:url value='/images/greenTeaCategory.png'/>" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"><c:out value="${category.getTranslation()}"/></h5>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>

</body>
</html>
