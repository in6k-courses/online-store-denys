<%@ page import="java.sql.Connection" %>
<%@ page import="Shop.db.dao.MySQLDAOFactory" %>
<%@ page import="Shop.db.dao.DAOFactory" %>
<%@ page import="Shop.CompletedOrder" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% DAOFactory<Connection> factory = new MySQLDAOFactory(); %>
<% Connection connection = factory.getContext();%>
<% List<CompletedOrder> completedOrders = factory.getDAO(connection, CompletedOrder.class).getAll();%>

<%@ include file="templates/template_head.jsp" %>
<div style="margin-top: 80px;">
    <h1 align="center">Orders</h1>
    <table class="table">
        <tr>
            <th>Order ID</th>
            <th>Date</th>
            <th>Total Price</th>
            <th>Customer</th>
            <th>Telephone</th>
            <th>Status</th>
        </tr>
        <% for (CompletedOrder co : completedOrders) { %>
        <tr>
            <td><%= co.getOrderId()%>
            </td>
            <td><%= co.getDate()%>
            </td>
            <td><%= co.getTotalPrice()%>
            </td>
            <td><%= co.getNameAndSurname()%>
            </td>
            <td><%= co.getTelephone()%>
            </td>
            <td>
                <form action="/ChangeStatusToOrder" method="post">
                    <input type="hidden" name="id_order" value="<%= completedOrders.indexOf(co) %>">
                    <input type="submit" value="<%= co.isStatus() %>">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</div>

<%@ include file="templates/template_footer.jsp" %>