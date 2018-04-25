<%-- 
    Document   : customerorder
    Created on : 23-04-2018, 14:09:27
    Author     : tobbe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Order> allOrders = (ArrayList<Order>) request.getAttribute("orderscustomer");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=allOrders.toString()%>
    </body>
</html>
