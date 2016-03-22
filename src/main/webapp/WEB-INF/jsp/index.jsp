<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



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
                    <c:forEach items="${categories}" var="category">
                    <a href="categories/${category.id}" class="list-group-item">${category.name}</a>
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-9">
                <div class="col-lg-9">
                    <h2 class="page-header">Categories</h2>
                </div>

                <c:forEach items="${categories}" var="category">
                <a href="categories/${category.id}">
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                             <img src="http://placehold.it/320x150" alt="">
                            <div class="caption">
                                <h4 class="text-center"> ${category.name} </h4>
                            </div>
                        </div>
                    </div>
                </a>
                </c:forEach>
            </div>
        </div>

<%@ include file="templates/template_footer.jsp"%>


