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
<div class="container mx-auto mt-4 form registration">
  <form:form id="form-registration" method="post" modelAttribute="currentUser" action="/teaProject/register/send" cssClass="Registration-form">
    <h2><spring:message code="registration_form_label"/></h2>
    <table>
      <tr>
        <td class="label"><form:label path="username"><spring:message code="username_label"/>* : </form:label></td>
        <td class="input"><form:input path="username"  required="required"/></td>
        <td class="error"><form:errors path="username" /><c:catch var="userExist"><div class="login-error-msg">${userExist}</div></c:catch></td>
      </tr>
      <tr>
        <td class="fr-label">   <form:label path="lastname"><spring:message code="lastname"/>* : </form:label></td>
        <td class="fr-input">   <form:input path="lastname" required="required"/></td>
        <td class="fr-error"> <form:errors path="lastname" /></td>
      </tr>
      <tr>
        <td class="fr-label"><form:label path="firstName"><spring:message code="firstname"/> : </form:label></td>
        <td class="fr-input">  <form:input path="firstName" required="required"/></td>
        <td class="fr-error">   <form:errors path="firstName" /></td>
      </tr>
      <tr>
        <td class="fr-label">  <form:label path="email"><spring:message code="email"/>* : </form:label></td>
        <td class="fr-input">  <form:input path="email"  required="required"/></td>
        <td class="fr-error"> <form:errors path="email" /><c:catch var="userExist"><div class="login-error-msg">${userExist}</div></c:catch></td>
      </tr>
      <tr>
        <td class="fr-label">  <form:label path="password"><spring:message code="password_label"/>* : </form:label></td>
        <td class="fr-input">  <form:input type="password" path="password" required="required"/></td>
        <td class="fr-error"><form:errors path="password" /></td>
      </tr>
      <tr>
        <td class="fr-label">  <form:label path="confirmPassword"><spring:message code="confirm_password"/>* : </form:label></td>
        <td class="fr-input">   <form:input type="password" path="confirmPassword" required="required"/></td>
        <td class="fr-error">  <form:errors path="confirmPassword" /><c:catch var="passwordDontMatch"><div class="login-error-msg">${passwordDontMatch}</div></c:catch></td>
      </tr>
      <tr>
        <td class="fr-label"><form:label path="deliveryAddress"><spring:message code="delivery_address"/>* : </form:label></td>
        <td class="fr-input">  <form:input path="deliveryAddress" required="required"/></td>
        <td class="fr-error">   <form:errors path="deliveryAddress" /></td>
      </tr>
      <td class="fr-label"> <form:label path="phoneNumber"><spring:message code="phone_number"/> : </form:label></td>
      <td class="fr-input"><form:input type="number" path="phoneNumber"/></td>
      <td class="fr-error">  <form:errors path="phoneNumber" /></td>
      </tr>
      <tr>
        <td class="fr-label"> <form:label path="sex"><spring:message code="gender"/> : </form:label></td>
        <td>
          <div>
            <input type="radio" id="male" name="drone" value="male" checked>
            <label for="male"><spring:message code="male"/></label>
          </div>
          <div>
            <input type="radio" id="female" name="drone" value="female" checked>
            <label for="female"><spring:message code="female"/></label>
          </div>
          <div>
            <input type="radio" id="x" name="drone" value="x" checked>
            <label for="x"><spring:message code="unspecified"/></label>
          </div>
        </td>
        <td class="fr-error">  <form:errors path="sex" /></td>
      </tr>
      <tr > <td style="color:red">* = <spring:message code="required_field"/></td></tr>
      </tbody>
    </table>
    <form:button><spring:message code="sign_up_label"/></form:button>
  </form:form>
</div>
<a class="nav-tdnk" href="login"><spring:message code="login_label"/></a>
<a class="nav-tdnk" href="home"><spring:message code="cancel_label"/></a>