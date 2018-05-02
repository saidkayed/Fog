<%-- 
    Document   : customerchoice
    Created on : 23-04-2018, 13:34:44
    Author     : tobbe
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    User user = (User) session.getAttribute("user");
    String message = (String) request.getAttribute("message");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0"></ul>
                <form name="logout" action="FrontController" method="POST">
                    Hello <%=user.getEmail()%>
                    <input type="hidden" name="command" value="logout">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </div>
        </nav>        
    <center>
        
        <form name="viewsvg" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewsvg">
            Length in cm:<br>
            <input type="number" name="length" placeholder="must be at least 200">
            <br>
            Width in cm:<br>
            <input type="number" name="width" placeholder="must be at least 200">
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

    </center>
    </body>
</html>
