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
    User user1 = (User) session.getAttribute("user");
    String message = (String) request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>        
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0"></ul>
                <form name="logout" action="FrontController" method="POST">
                    <%=user1.getEmail()%>
                    <input type="hidden" name="command" value="logout">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </div>
        </nav>
        <div>
            <h1>All Orders in system:</h1><br>

            <form action="FrontController" method="Post">
                <input type="text" name="search" value="">
                <input type="hidden" name="command" value="search">
                <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search">
            </form>
            <% if (message != null) {%>
            <%=message%>
            <%}%>

            <form name="viewordersemp" action="FrontController" method="POST">
                <input type="hidden" name="command" value="viewordersemp">
                <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="View All Orders">
            </form>

            <%if (user != null) {%>

            <div class="container">
            <table class="table table-bordered">

                <%=Order.empOrderToHtmlByEmail(user.getEmail())%>
            </table>
            <%} else {%>
            <table class="table table-bordered">

                <%=Order.empOrderToHtml()%>
            </table>
            <%}%>
        </div>
        </div>
        <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="home">
            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Back">
        </form>
    </center>
    </body>
</html>
