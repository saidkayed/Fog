<%-- 
    Document   : addmaterial
    Created on : 07-05-2018, 20:27:46
    Author     : SA
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.Materials"%>
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
        <title>addmaterial</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
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
        <table>
            <tr>
                <td>
                    <form id="material" name="addmaterials" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="addmaterials">
                        
                        Material Name<br>
                        <input type="text" class="form-control" name="name" required/>

                        Material Price<br>
                        <input type="number" class="form-control" name="price" required/>

                        Material Length<br>
                        <input type="text" class="form-control" name="length" required/>

                        Material Description<br>
                        <input type="text" class="form-control" name="description" required/>
                        <br>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Add Material</button>
                    </form>
                    <form action="FrontController" method="Post">
                        <input type="hidden" name="command" value="backtoemployeviewmaterials">
                        <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Back">
                    </form>
                </td>
            </tr>
        </table>
    </center>
</body>
</html>
