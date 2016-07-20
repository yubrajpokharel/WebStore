<%--
  Created by IntelliJ IDEA.
  User: yubraj
  Date: 7/19/16
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>Add products</p>
            <a href="<c:url value="/logout" />" class="btn btn-danger btn-mini pull-right">logout</a>
            <div class="pull-right" style="padding-right:50px">
                <a href="?language=en" >English</a>|<a href="?language=np" >Nepali</a>
            </div>
        </div>
    </div>
</section>
<section class="container">

    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
    <fieldset>
        <legend>Add new product</legend>
        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="productId"><spring:message code="addProduct.form.productId.label" /></label>
            <div class="col-lg-10">
                <form:input id="productId" path="productId" type="text" class="form-control"/>
                <form:errors path="productId" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="name">
                <spring:message code="addProduct.form.productName.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text" class="form-control" />
                <form:errors path="name" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                <spring:message code="addProduct.form.productPrice.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="unitPrice" path="unitPrice" type="text" class="form-control" />
                <form:errors path="unitPrice" cssClass="text-danger"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="category">
                <spring:message code="addProduct.form.productCategory.label" />
            </label>
            <div class="col-lg-10">
                <form:input path="category" id="category" type="text" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="manufacturer">
                <spring:message code="addProduct.form.productManufacture.label"/>
            </label>
            <div class="col-lg-10">
                <form:input path="manufacturer" id="manufacturer" type="text" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="description">
                <spring:message code="addProduct.form.productDesc.label"/>
            </label>
            <div class="col-lg-10">
                <form:textarea id="description" class="form-control" path="description" rows ="2"/>
            </div>
        </div>

        <%--<div class="form-group">--%>
            <%--<label class="control-label col-lg-2" for="discontinued">Discontinued</label>--%>
            <%--<div class="col-lg-10">--%>
                <%--<form:checkbox id="discontinued" path="discontinued"/>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <%--@declare id="condition"--%>
            <label class="control-label col-lg-2" for="condition">
                <spring:message code="addProduct.form.productCondition.label" />
            </label>
            <div class="col-lg-10">
                <form:radiobutton path="condition" value="New"/>New
                <form:radiobutton path="condition" value="Old"/>Old
                <form:radiobutton path="condition" value="Refurbished"/>Refurbished
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                <spring:message code="addProduct.form.productUnitInStock.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="unitsInStock" path="unitsInStock" type="text" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="productImage">
                <spring:message code="addProduct.form.productImage.label"/>
            </label>
            <div class="col-lg-10">
                <form:input path="productImage" id="productImage" class="form-control" type="file" />
            </div>
        </div>

        <%--<div class="form-group">--%>
            <%--<label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">Units--%>
                <%--In Order</label>--%>
            <%--<div class="col-lg-10">--%>
                <%--<form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form-control" />--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
            </div>
        </div>
    </fieldset>
    </form:form>

</section>
</body>
</html>