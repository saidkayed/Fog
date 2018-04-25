<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    User user = (User) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=user.getEmail()%> </h1>

        <form name="orderpage" action="FrontController" method="POST">
            <input type="hidden" name="command" value="orderpage">
            <input type="submit" value="Order Page">
        </form>

        <form name="vieworderscustomer" action="FrontController" method="POST">
            <input type="hidden" name="command" value="vieworderscustomer">
            <input type="submit" value="View Orders">
        </form>

        <form name="logout" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
