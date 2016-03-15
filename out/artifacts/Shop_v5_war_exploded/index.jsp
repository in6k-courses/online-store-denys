
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Shop.db.dao.MySQLDAOFactory" %>
<%@ page import="Shop.ShopBase.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Shop.db.dao.DAOFactory" %>
<%  DAOFactory<Connection> factory = new MySQLDAOFactory(); %>
<%  Connection connection = factory.getContext(); %>
<%  List<Category> categories = factory.getDAO(connection, Category.class).getAll(); %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
<div>
    <h1 class="alert-info text-center">Categories</h1>
</div>
    <form action="">
        <%
            for (Category c:
                 categories) {
                <%= c.getName() %>
            }

    %>
    </form>
</body>
</html>
