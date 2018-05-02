<%-- 
    Document   : employeeorder
    Created on : 23-04-2018, 13:58:30
    Author     : tobbe
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = (User) request.getAttribute("searchUser");
    String message = (String) request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>All Orders in system:</h1><br>

            <form action="FrontController" method="Post">
                <input type="text" name="search" value="">
                <input type="hidden" name="command" value="search">
                <input type="submit" value="Search">
            </form>
            <% if (message != null) {%>
            <%=message%>
            <%}%>
            
            <form name="viewordersemp" action="FrontController" method="POST">
                <input type="hidden" name="command" value="viewordersemp">
                <input type="submit" value="View All Orders">
            </form>

            <%if (user != null) {%>


            <table>

                <%=Order.empOrderToHtmlByEmail(user.getEmail())%>
            </table>
            <%} else {%>
            <table>

                <%=Order.empOrderToHtml()%>
            </table>
            <%}%>
        </div>
        <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="home">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
