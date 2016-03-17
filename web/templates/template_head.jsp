<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Shop.ShopBase.PurchaseItem" %>
<% Object obj = session.getAttribute("cartSize"); %>
<% int cartSize = (obj == null ? 0 : Integer.valueOf(obj.toString()));%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shop</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
            <a href="cart.jsp">
                <% if (cartSize != 0) { %>
                <span class="pull-right bg-info glyphicon glyphicon-shopping-cart"> <%= cartSize %> item/s </span>
                <% } %>
            </a>
        </div>
    </div>
</nav>