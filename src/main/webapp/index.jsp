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
        <link rel="stylesheet" type="text/css" href="css-and-pictures/logo.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Welcome page</title>
    </head>
    <body>
        
        <div class="container">
            <img src="css-and-pictures/flogo.jpg"  width="1000" height="300">
            <div class="topleft"></div>
        </div>
        <div class="w3-content w3-section" style="max-width:500px">
            <img class="mySlides" src="css-and-pictures/billed.jpg" style="width:70%">
            <img class="mySlides" src="css-and-pictures/billed1.jpg" style="width:70%">
        </div>

        <script>
            var myIndex = 0;
            carousel();

            function carousel() {
                var i;
                var x = document.getElementsByClassName("mySlides");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                myIndex++;
                if (myIndex > x.length) {
                    myIndex = 1
                }
                x[myIndex - 1].style.display = "block";
                setTimeout(carousel, 1000); // Change image every 2 seconds
            }
        </script>
        <center>
        <div class="row">
            <div class="column">
                <table >
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
                    </td>
                </table>
            </div>
            <div class="column">

                <table>
                    <td>
                        <h4>Test System</h4>
                        <form name="systemtest" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="systemtest">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Test System</button>
                        </form>


                    </td>
                </table>
            </div>
            <div class="column">
                <table>

                    <td>

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
                </table>
            </div>
        </div>
        </center>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>
</body>
</html>
