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
        <title>Customer Choice</title>
    </head>
    <body>
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

    <center>

        <table>
            <tr>
                <td>

                    <form name="viewsvg" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="viewsvg">
                        Length in cm:<br>
                        <select name="length" class="form-control" data-style="btn-success">
                            <option type="number" value="390" >390</option>
                            <option type="number" value="450" >450</option>
                            <option type="number" value="480" >480</option>
                            <option type="number" value="510" >510</option>
                        </select>
                        <br>
                        Width in cm:<br>
                        <select name="width" class="form-control" data-style="btn-success">
                            <option type="number" value="280">280</option>
                            <option type="number" value="300">300</option>
                        </select>
                        <br>
                        Height in cm:<br>
                        <select name="height" class="form-control" data-style="btn-success">
                            <option type="number" value="280">280</option>
                            <option type="number" value="300">300</option>
                        </select>
                        <br>
                        Roof type:<br>
                        <select name="roof" class="form-control" data-style="btn-success">
                            <option value="fladt" name="fladt">Carport med fladt</option>
                            <option value="rejsning" name="rejsning">Carport med rejsning</option>
                        </select>
                        <br>
                        Shed:<br>
                        <select name="roof" class="form-control" data-style="btn-success">
                            <option value="withshed" name="withshed">uden skur</option>
                            <option value="withoutshed" name="withoutshed">med skur</option>
                        </select>
                        <br>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">View Plan</button>
                    </form>
                    <br>            
                    <form action="FrontController" method="Post">
                        <input type="hidden" name="command" value="home">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Back</button>
                    </form>

                </td>
            </tr>
        </table>


        <%if (message != null) {%>

        <%=message%>

        <%}%>

    </center>
</body>
</html>
