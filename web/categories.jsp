<%@ page import="java.sql.Connection" %>
<%@ page import="Shop.db.dao.MySQLDAOFactory" %>
<%@ page import="Shop.db.dao.DAOFactory" %>
<%@ page import="Shop.ShopBase.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="Shop.db.MySQLProductDAO" %>
<%@ page import="Shop.ShopBase.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int category_id = Integer.valueOf(request.getParameter("id")); %>

<% DAOFactory<Connection> factory = new MySQLDAOFactory(); %>
<% Connection connection = factory.getContext();%>
<% List<Category> categories = factory.getDAO(connection, Category.class).getAll(); %>
<% List<Product> products =  factory.getDAO(connection, Product.class).getAll();%>
<% Category curentCategory = (Category) factory.getDAO(connection, Category.class).getByPK(category_id); %>

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
        </div>
    </div>
</nav>
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="margin-top: 80px;">
                <small>It's Nice to Meet You in</small>
                Online Shop
            </h1>
        </div>
    </div>
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <a href="index.jsp"><p class="lead">Categories</p></a>
                <div class="list-group">
                    <% for (Category category: categories) {%>
                    <a href="categories.jsp?id=<%= category.getId()%>" class="list-group-item"> <%= category.getName() %> </a>
                    <%}%>
                </div>
            </div>

            <div class="col-md-9">
                <div class="col-lg-9">
                    <h2 class="page-header"><%= curentCategory.getName() %></h2>
                </div>

                <% for (Product pr : products) { %>
                    <% if (pr.getCategory() == category_id) { %>
                        <div class="col-sm-4 col-lg-4 col-md-4">

                            <div class="thumbnail">
                                <img src="http://placehold.it/320x150" alt="">
                                <div class="caption">
                                    <h4 class="text-left "> <%= pr.getName()%> </h4>
                                    <h5 class="text-left "> <%= pr.getCost()%> </h5>
                                    <form action="AddProduct" method="get">
                                        <input type="hidden" name="product_id" value="<%= pr.getId() %>">
                                        <input type="text" name="amount" value="1" class="form-control text-center">
                                        <input type="submit" value="Buy" class="form-control">
                                    </form>
                                </div>
                            </div>
                        </div>
                    <% } %>
                <% } %>
            </div>
        </div>


        <hr>
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p class="text-right">Copyright &copy; Online Shop 2016</p>
                </div>
            </div>
        </footer>
    </div>
</div>
</body>
</html>

