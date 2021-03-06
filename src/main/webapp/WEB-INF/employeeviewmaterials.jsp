<%-- 
    Document   : employeviewmaterials
    Created on : May 7, 2018, 12:44:19 PM
    Author     : Sercan
--%>

<%@page import="FunctionLayer.RenderMaterials"%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>        
        <title>employeeviewmaterials</title>
    </head>
    <body>
    <center>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
              
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0"></ul>
                <form name="logout" action="FrontController" method="POST">
                    <%=user.getEmail()%>
                    <input type="hidden" name="command" value="logout">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </div>
        </nav>
        <div class="container">
             <table class="table table-bordered">
                <%=RenderMaterials.empMaterialeToHtml()%>
            </table>
        </div>
        <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="addmaterialnavigation">
            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Add Material">
        </form>
        <form action="FrontController" method="Post">
            <input type="hidden" name="command" value="home">
            <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Back">
        </form>
    </center>
</body>
</html>

