<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 10-01-23
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <c:set var="currency" value="€"/>
  <div class="container mx-auto mt-4">
    <h1><spring:message code="order_checked_message"/> !</h1>
    <br>
    <h3><spring:message code="confirm_order_products_label"/> : </h3>
    <br>
    <c:forEach items="${currentCart.getItems().values()}" var="item">
      <p>x${item.getQuantity()} ${item.getName()} ${item.getActualPrice()} ${currency}</p>
    </c:forEach>
    <br>
    <h5><spring:message code="total_label"/> : ${currentCart.getTotalPrice()} ${currency}</h5>
    <br>
    <form:form method="post"
               action="https://www.sandbox.paypal.com/cgi-bin/webscr"
               modelAttribute="cartItem">

      <input type="hidden" name="business" value="tea_project@shop.com" />
      <input type="hidden" name="cmd" value="_cart" />
      <input type="hidden" name="upload" value="1" />

      <c:forEach items="${currentCart.getItems().values()}" var="item" varStatus="status">
        <input type="hidden" name="quantity_${status.count}" value="${item.getQuantity()}" />
        <input type="hidden" name="amount_${status.count}" value="${item.getActualPrice()}" />
        <input type="hidden" name="item_name_${status.count}" value="${item.getName()}" />
      </c:forEach>
      <input type="hidden" name="return" value="http://localhost:8083/teaProject/order/paymentSuccess" />
      <input type="hidden" name="cancel_return" value="http://localhost:8083/teaProject/order/paymentFailed" />
      <input type="hidden" name="currency_code" value="EUR" />
      <input type="hidden" name="lc" value="${locale.getLanguage()}-${locale.getCountry()}" />

      <form:button class="btn"><spring:message code="buy_button"/></form:button>
      <a class="btn btn-primary" href="<spring:url value="/cart"/>"><spring:message code="back_to_cart_label"/></a>
    </form:form>
    <br>
  </div>
</body>
</html>
