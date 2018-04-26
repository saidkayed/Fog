<%-- 
    Document   : customerchoice
    Created on : 23-04-2018, 13:34:44
    Author     : tobbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="makeorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="makeorder">
            Length in cm:<br>
            <input type="number" name="length" value="0">
            <br>
            Width in cm:<br>
            <input type="number" name="width" value="0">
            <br>
            <input type="submit" value="Make Order">
        </form>

    </body>
</html>
