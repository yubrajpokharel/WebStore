<%--
  Created by IntelliJ IDEA.
  User: yubraj
  Date: 7/19/16
  Time: 2:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-
1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1> ${greeting} </h1>
            <p> ${tagline} </p>
        </div>
    </div>
</section>
<section>
    <div class="row">
        <div class="col-lg-6">
            <ul class="list-group">
                <li class="list-group-item"><a href="http://localhost:8080/products">Products</a></li>
            </ul>
        </div>

        <div class="col-lg-6">
            <ul class="list-group">
                <li class="list-group-item"><a href="http://localhost:8080/customers">Products</a></li>
            </ul>
        </div>
    </div>
</section>
</body>
</html>
