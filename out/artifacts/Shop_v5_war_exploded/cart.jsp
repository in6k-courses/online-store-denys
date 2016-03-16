<%@ page import="java.util.List" %>
<%@ page import="Shop.ShopBase.PurchaseItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<PurchaseItem> purchaseList =  (List<PurchaseItem>) session.getAttribute("purchaseList"); %>

<%@ include file="templates/template_head.jsp"%>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<div class="container">

    <div class="row">

        <div class="col-md-12" style="margin-top: 80px;">
            <span class="lead h2">Cart</span>
            <hr><hr>
            <div class="list-group">
                <% if(purchaseList == null){ %>
                    <h2> You havn't choosen at list one item to buy</h2>
                <% } else { %>
                    <%for (PurchaseItem pi: purchaseList) { %>
                            <span class="list-group-item-heading h4 col-md-9"> <%= pi.getProduct().getName() %> </span>
                            <span class="list-group-item-heading h4 col-md-1"> x<%= pi.getAmount() %> </span>
                            <span class="list-group-item-heading h4 col-md-1"> <%= pi.getPrice()%> </span>
                            <a href="DeleteProduct?id=<%=purchaseList.indexOf(pi)%>"><button class="btn btn-danger">Delete</button></a>
                        <hr>
                    <% } %>
                <% } %>
            </div>
        </div>

    </div>



<%@ include file="templates/template_footer.jsp"%>