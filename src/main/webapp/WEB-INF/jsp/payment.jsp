<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 10-01-23
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post">
  <!-- Identify your business so that you can collect the payments. -->
  <input type="hidden" name="business" value="sb-qc9jp24839866@business.example.com">
  <!-- Specify a Buy Now button. -->
  <input type="hidden" name="cmd" value="_xclick">
  <!-- Specify details about the item that buyers will purchase. -->
  <input type="hidden" name="item_name" value="${currentCart.getItems().get(0).getName()}" />
  <input type="hidden" name="amount" value="5.95">
  <input type="hidden" name="currency_code" value="EUR">
  <!-- Display the payment button. -->
  <input type="image" name="submit" border="0" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" alt="Buy Now">
  <img alt="" border="0" width="1" height="1" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >
</form>
</body>
</html>
