<%-- 
    Document   : customerorder
    Created on : 23-04-2018, 14:09:27
    Author     : tobbe
--%>

<%@page import="FunctionLayer.RenderOrder"%>
<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css-and-pictures/logo.css">
        <title>customerorder</title>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <img src="css-and-pictures/flogo.jpg"  width="300" height="75">
                <div class="topleft"></div>
            </div>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0"></ul>
                <form name="logout" action="FrontController" method="POST">
                    <%=user.getEmail()%>
                    <input type="hidden" name="command" value="logout">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </div>
        </nav>
    <center>
        <div class="container">
            <h1>All orders made by <%=user.getEmail()%> </h1><br>
            <table class="table table-bordered">
                <%=RenderOrder.userOrderToHtml(user)%>
            </table>
        </div>
        <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="home">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Back</button>
        </form>
    </center>
</body>
</html>
