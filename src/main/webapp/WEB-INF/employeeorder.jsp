<%-- 
    Document   : employeeorder
    Created on : 23-04-2018, 13:58:30
    Author     : tobbe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>All Orders in system:</h1><br>
            <table>

                <%=Order.empOrderToHtml()%>
            </table>
        </div>
    </body>
</html>
