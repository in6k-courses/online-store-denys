<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/template_head.jsp" %>

<div class="container">

    <div class="row">


        <div class="col-md-12" style="margin-top: 80px;">
            <span class="lead ">Cart</span>
            <p><a href="/"> Back to main page</a></p>
            <hr>
            <hr>
            <div class="list-group">
                <c:if test="${purchaseItems.size()} < 1">
                    <h2> You havn't choosen at list one item to buy</h2>
                </c:if>
                <h1>${purchaseItems.size}</h1>
                <span class="list-group-item-heading h4 col-md-7"> VAR </span>
                <span class="list-group-item-heading h4 col-md-1"> x VAR </span>
                <a href="ChangeProductAmount?up=1&product=VAR">
                    <span class="glyphicon glyphicon-chevron-up col-md-1" aria-hidden="true"></span>
                </a>
                <a href="ChangeProductAmount?down=1&product=VAR">
                    <span class="glyphicon glyphicon-chevron-down col-md-1" aria-hidden="true"></span>
                </a>
                <span class="list-group-item-heading h4 col-md-1"> $ VAR </span>
                <a href="DeleteProduct?id=VAR">
                    <button class="btn btn-danger">Delete</button>
                </a>
                <hr>

                <p class="text-center text-info h4 ">Total price $: VAR </p>

                <div style="margin: 0 auto; width: 70%;">
                    <p class="text-center bg-warning h3"> To order input next information</p>

                    <form action="OrderServlet" method="post">
                        <div class="form-group">
                            <label for="f_name">First name</label>
                            <input type="text" class="form-control" id="f_name" value="Name" name="f_name">
                        </div>
                        <div class="form-group">
                            <label for="l_name">Last name</label>
                            <input type="text" class="form-control" id="l_name" value="Surname" name="l_name">
                        </div>
                        <div class="form-group">
                            <label for="tel">Telephone</label>
                            <input type="text" class="form-control" id="tel" value="+0 000 000 0000" name="tel">
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Order">
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>


<%@ include file="templates/template_footer.jsp" %>