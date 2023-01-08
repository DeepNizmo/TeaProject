<%--
  Created by IntelliJ IDEA.
  User: Wangi
  Date: 04-01-23
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by InteltdJ IDEA.
  User: Wangi
  Date: 16-12-22
  Time: 07:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
  <title style="color:white" >Inscription</title>
</head>
<body>
<div class="form registration">
  <form:form id="form-registration" method="post" modelAttribute="currentUser" cssClass="Registration-form">
    <h2>Inscription form</h2>
    <table>
      <tr>
        <td class="label"><form:label path="username">Username:*</form:label></td>
        <td class="input"><form:input path="username"  required="required" placeholder="Enter username here"/></td>
        <td class="error"><form:errors path="username" /><c:catch var="userExist"><div class="login-error-msg">${userExist}</div></c:catch></td>
      </tr>
      <tr>
        <td class="fr-label">   <form:label path="lastname">Lastname:*</form:label></td>
        <td class="fr-input">   <form:input path="lastname" required="required" placeholder="Enter lastname here"/></td>
        <td class="fr-error"> <form:errors path="lastname" /></td>
      </tr>
      <tr>
        <td class="fr-label"><form:label path="firstName">Firstname:*</form:label></td>
        <td class="fr-input">  <form:input path="firstName" required="required" placeholder="Enter firstname here"/></td>
        <td class="fr-error">   <form:errors path="firstName" /></td>
      </tr>
      <tr>
        <td class="fr-label">  <form:label path="email">Email*</form:label></td>
        <td class="fr-input">  <form:input path="email"  required="required" placeholder="Enter your email here"/></td>
        <td class="fr-error"> <form:errors path="email" /><c:catch var="userExist"><div class="login-error-msg">${userExist}</div></c:catch></td>
      </tr>
      <tr>
        <td class="fr-label">  <form:label path="password">Password:*</form:label></td>
        <td class="fr-input">  <form:input type="password" path="password" required="required" placeholder="Enter password here"/></td>
        <td class="fr-error"><form:errors path="password" /></td>
      </tr>
      <tr>
        <td class="fr-label">  <form:label path="confirmPassword">Confirmed password:*</form:label></td>
        <td class="fr-input">   <form:input type="password" path="confirmPassword" required="required" placeholder="Enter confirm password here"/></td>
        <td class="fr-error">  <form:errors path="confirmPassword" /><c:catch var="passwordDontMatch"><div class="login-error-msg">${passwordDontMatch}</div></c:catch></td>
      </tr>
      <tr>
        <td class="fr-label"><form:label path="deliveryAddress">Delivery address:*</form:label></td>
        <td class="fr-input">  <form:input path="deliveryAddress" required="required" placeholder="Enter delivery address here"/></td>
        <td class="fr-error">   <form:errors path="deliveryAddress" /></td>
      </tr>
      <td class="fr-label"> <form:label path="phoneNumber">Phone number</form:label></td>
      <td class="fr-input"><form:input type="number" path="phoneNumber" placeholder="Enter phone number here"/></td>
      <td class="fr-error">  <form:errors path="phoneNumber" /></td>
      </tr>
      <tr>
        <td class="fr-label"> <form:label path="sex">Gender:</form:label></td>
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
        <td class="fr-error">  <form:errors path="sex" /></td>
      </tr>
      <tr > <td style="color:red">* = obtdgatory fields</td></tr>
      </tbody>
    </table>
    <form:button>Sign up</form:button>
  </form:form>
</div>
<a class="nav-tdnk" href="login">Sign in</a>
<a class="nav-tdnk" href="home">Cancel</a>