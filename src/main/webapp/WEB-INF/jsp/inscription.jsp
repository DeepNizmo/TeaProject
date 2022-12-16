<%--
  Created by IntelliJ IDEA.
  User: Wangi
  Date: 16-12-22
  Time: 07:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<form name="inscritionForm" >
  <h2>Inscription form</h2>
  <table>
    <tr>
      <td>Login*:</td>
      <td><input type="text" name="first" value="" size="20"/></td>
    </tr>
    <tr>
      <td>Last name*:</td>
      <td><input type="text" name="first" value="" size="20"/></td>
    </tr>
    <tr>
      <td>First name*:</td>
      <td><input type="text" name="first" value="" size="20"/></td>
    </tr>
    <tr>
      <td>E-mail*:</td>
      <td><input type="email" name="first" value="" size="20"/></td>
    </tr>
    <tr>
      <td>Delivery address:</td>
      <td><input type="text" name="first" value="" size="20"/></td>
    </tr>
    <tr>
      <td>Phone number:</td>
      <td><input type="tel" name="first" value="" size="20"/></td>
    </tr>
    <tr>
      <td>Sex:</td>
      <td>
          <div>
            <input type="radio" id="male" name="drone" value="male" checked>
            <label for="male">Male</label>
          </div>
          <div>
            <input type="radio" id="female" name="drone" value="female" checked>
            <label for="female">Female</label>
          </div>
          <div>
            <input type="radio" id="x" name="drone" value="x" checked>
            <label for="x">Genderfluid</label>
          </div>
      </td>
    </tr>
    </tbody>
  </table>
  <input type="button" value="Submit">
</form>

</body>
</html>
