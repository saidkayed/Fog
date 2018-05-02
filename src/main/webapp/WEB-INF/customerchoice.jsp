<%-- 
    Document   : customerchoice
    Created on : 23-04-2018, 13:34:44
    Author     : tobbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String message = (String) request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="viewsvg" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewsvg">
            Length in cm: (must be at least 200)<br>
            <input type="number" name="length" value="0">
            <br>
            Width in cm: (must be at least 200)<br>
            <input type="number" name="width" value="0">
            <br>
            <input type="submit" value="View Plan">
        </form>
        <%if (message != null) {%>

        <%=message%>

        <%}%>

        <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="home">
            <input type="submit" value="Back">   
        </form>

    </body>
</html>
