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
        <div class="w3-content w3-display-container" style="max-width:400px">
            <img class="mySlides" src="css-and-pictures/billed.jpg" style="width:100%">
            <img class="mySlides" src="css-and-pictures/billed1.jpg" style="width:100%">
            <div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%">
                <div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
                <div class="w3-right w3-hover-text-khaki" onclick="plusDivs(1)">&#10095;</div>
                <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
                <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
            </div>
        </div>

        <script>
            var slideIndex = 1;
            showDivs(slideIndex);

            function plusDivs(n) {
                showDivs(slideIndex += n);
            }

            function currentDiv(n) {
                showDivs(slideIndex = n);
            }

            function showDivs(n) {
                var i;
                var x = document.getElementsByClassName("mySlides");
                var dots = document.getElementsByClassName("demo");
                if (n > x.length) {
                    slideIndex = 1
                }
                if (n < 1) {
                    slideIndex = x.length
                }
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" w3-white", "");
                }
                x[slideIndex - 1].style.display = "block";
                dots[slideIndex - 1].className += " w3-white";
            }
        </script>
    <center>
        <div class="row">
            <div class="column">
                <table >
                    <td>
                        <h4> Login </h4>
                        <form name="login" action="FrontController" method="POST"
                              data-fv-framework="bootstrap"
                              data-fv-icon-valid="glyphicon glyphicon-ok"
                              data-fv-icon-invalid="glyphicon glyphicon-remove"
                              data-fv-icon-validating="glyphicon glyphicon-refresh">
                            <input type="hidden" name="command" value="login">
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Email</label>
                                <div class="col-xs-5">
                                    <input type="text" class="form-control" name="email"
                                           required
                                           data-fv-notempty-message="Email is required" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3 control-label">Password</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control" name="password"
                                           required
                                           data-fv-notempty-message="Password price is required" />
                                </div>
                            </div>
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Submit</button>
                        </form>
                        <script>
                            $(document).ready(function () {
                                $('#login').formValidation();
                            });
                        </script>
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

                        <form name="register" action="FrontController" method="POST"

                              <input type="hidden" name="command" value="register"                              data-fv-framework="bootstrap"
                               data-fv-icon-valid="glyphicon glyphicon-ok"
                               data-fv-icon-invalid="glyphicon glyphicon-remove"
                               data-fv-icon-validating="glyphicon glyphicon-refresh">
                            <input type="hidden" name="command" value="login">
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Email</label>
                                <div class="col-xs-5">
                                    <input type="text" class="form-control" name="email"
                                           required
                                           data-fv-notempty-message="Email is required" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Phone</label>
                                <div class="col-xs-5">
                                    <input type="phone" class="form-control" name="phone"
                                           required
                                           data-fv-notempty-message="Phone is required" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-3 control-label">Password</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control" name="password1"
                                           required
                                           data-fv-notempty-message="Password price is required" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Password</label>
                                <div class="col-xs-5">
                                    <input type="password" class="form-control" name="password2"
                                           required
                                           data-fv-notempty-message="Password price is required" />
                                </div>
                            </div>
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Submit</button>
                        </form>
                        <script>
                            $(document).ready(function () {
                                $('#register').formValidation();
                            });
                        </script>
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
