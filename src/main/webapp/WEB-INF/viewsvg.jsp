<%-- 
    Document   : viewsvg
    Created on : 30-04-2018, 12:24:33
    Author     : tobbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int length = (Integer) request.getAttribute("length");
int width = (Integer) request.getAttribute("width");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <svg
            width=<%=width%> height=<%=length%>>
        <rect x="0" y="0" height=<%=length%> width=<%=width%>
                style="stroke:#000000; fill: yellow"/>

        </svg>
            <form>
            <form name="makeorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="makeorder">
            <input type="hidden" name="length" value=<%=length%>>
            <input type="hidden" name="width" value=<%=width%>>
            <input type="submit" value="Make Order">
        </form>
    </body>
</html>
