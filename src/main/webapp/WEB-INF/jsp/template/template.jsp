<%--
  Created by IntelliJ IDEA.
  User: Gage
  Date: 06-10-22
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
    <title>Tea</title>
    <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link  type="image/icon" rel="icon" href="<spring:url value='/images/logo.png' />" >
    <link
        type="text/css" href="<spring:url value='/css/first.css' />"
        rel="stylesheet">

    <!-- LANGUAGES -->
    <spring:url value="" var="LocaleFr">
        <spring:param name="locale" value="fr" />
    </spring:url>
    <spring:url value="" var="LocaleEn">
        <spring:param name="locale" value="en" />
    </spring:url>

</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="home">
            <img src="<spring:url value='/images/logo4.png'/>" width="35" height="35" class="d-inline-block align-top" alt="">
            TEA
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="home">
                        <spring:message code="navbar_home"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tea-category">
                        <spring:message code="navbar_tea"/>
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart">
                        <spring:message code="navbar_cart"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<spring:url value="/about"/>">
                        <spring:message code="navbar_aboutUs"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">
                        <spring:message code="navbar_login"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register">
                        <spring:message code="navbar_register"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${LocaleFr}">
                        <img class="flag-img" src="<spring:url value="/images/flag/fr_flag.png"/>" alt="fr flag"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${LocaleEn}">
                        <img class="flag-img" src="<spring:url value="/images/flag/uk_flag.png"/>" alt="en flag"/>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <div>
        <!-- **************** BANNER ***************** -->
        <!-- <img src="<spring:url value='/images/banner.png'/>"> -->
    </div>
    <div>
        <!-- ************** LEFT MENU **************** -->
        …
    </div>
    <div>
        <!-- ************* MAIN CONTENT ************* -->
        <div class="integrated">
            <tiles:insertAttribute name="main-content" />
        </div>
    </div>
    <div>
        <!-- ****************** FOOTER ***************** -->
        …
    </div>
</body>
</html>
