<%-- 
    Document   : index
    Created on : 23-04-2018, 13:34:44
    Author     : tobbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <title>Welcome page</title>
    </head>
    <body>
    <center>
        <h1>Welcome to Fog Carport</h1>

        <table>
            <tr>
                <td>
                    <h4> Login </h4>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input class="form-control mr-sm-2" type="text" name="email" placeholder="email">
                        <br>
                        Password:<br>
                        <input class="form-control mr-sm-2" type="password" name="password" placeholder="password">
                        <br>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Submit</button>
                    </form>
                    <br>
                    <h4> Register </h4>

                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input class="form-control mr-sm-2" type="text" name="email" placeholder="email">
                        <br>
                        Phone:
                        <input class="form-control mr-sm-2" type="number" name="phone" placeholder="12345678">
                        <br>
                        Password:<br>
                        <input class="form-control mr-sm-2" type="password" name="password1" placeholder="password">
                        <br>
                        Retype Password:<br>
                        <input class="form-control mr-sm-2" type="password" name="password2" placeholder="password">
                        <br>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Submit</button>
                    </form>
                </td>
            </tr>
        </table>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>
    </center>
</body>
</html>
