<%-- 
    Document   : employeepage.jsp
    Created on : 23-04-2018, 13:34:44
    Author     : tobbe
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
        <title>Employee home page</title>
    </head>
    <body>
        
        <h1>Hello <%=user.getEmail()%> </h1>
        
        <form name="viewordersemp" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewordersemp">
            <input type="submit" value="View Orders">
        </form>
        
        <form name="lougout" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
