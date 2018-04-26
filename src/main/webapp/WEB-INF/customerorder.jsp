<%-- 
    Document   : customerorder
    Created on : 23-04-2018, 14:09:27
    Author     : tobbe
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
User user = (User) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    
     <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="home">
            <input type="submit" name="Back">
            
            
        </form>
    </head>
    <body>
        <div>
            <h1>All orders made by you</h1><br>
        <table>
            <%=Order.userOrderToHtml(user)%>
        </table>
        </div>
    </body>
</html>
