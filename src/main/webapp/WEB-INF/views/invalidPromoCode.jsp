<%--
  Created by IntelliJ IDEA.
  User: yubraj
  Date: 7/20/16
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-
8859-1">
    <link
            rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/boo
tstrap.min.css">
    <title>Invalid promo code</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger">Invalid promo code</h1>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/products" />"class="btn btnprimary">
                <span class="glyphicon-hand-left glyphicon"></span>
                products
            </a>
        </p>
    </div>
</section>
</body>
</html>
