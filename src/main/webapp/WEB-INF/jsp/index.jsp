
<%@ page import="java.sql.Connection" %>
<%@ page import="Shop.db.dao.DAOFactory" %>
<%@ page import="Shop.db.dao.MySQLDAOFactory" %>
<%@ page import="Shop.core.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% DAOFactory<Connection> factory = new MySQLDAOFactory(); %>
<%  Connection connection = factory.getContext();%>
<%   List<Category> categories = factory.getDAO(connection, Category.class).getAll();%>


<%@ include file="templates/template_head.jsp"%>

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
                    <h2 class="page-header">Categories</h2>
                </div>

                <% for (Category category: categories) {%>
                <a href="categories.jsp?id=<%= category.getId() %>">
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                             <img src="http://placehold.it/320x150" alt="">
                            <div class="caption">
                                <h4 class="text-center"> <%= category.getName()%> </h4>
                            </div>
                        </div>
                    </div>
                </a>
            <% } %>
            </div>
        </div>

<%@ include file="templates/template_footer.jsp"%>