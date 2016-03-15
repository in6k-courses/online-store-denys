<%@ page import="Shop.com.MainPageServlet" %>
<%@ page import="Shop.com.CategoryPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
<div>
    <h1 class="alert-info text-center">Categories</h1>
</div>
   <%= CategoryPage.getCategoriesList() %>

</body>
</html>
