<%-- 
    Document   : productlist
    Created on : 09-05-2018, 15:25:07
    Author     : tobbe
--%>

<%@page import="FunctionLayer.Materials"%>
<%@page import="FunctionLayer.RenderMaterials"%>
<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
ArrayList<Materials> materials = (ArrayList<Materials>) request.getAttribute("materials");
User user = (User) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>         
        <title>Productlist</title>
    </head>
    <body>
        <div>
        <h1>Productlist</h1>
        
         <div class="container">
            <table class="table table-bordered">

                <%=RenderMaterials.materialToProductListHtml(materials)%>
                
                
                
            </table>
                <br>
                <h4> Total price : <%=RenderMaterials.materialTotalPrice(materials)%> kr</h4>
            
           <%if (user.getRole().equals("customer")){%>
           <form action="FrontController" method="Post">
           <input type="hidden" name="command" value="vieworderscustomer">
           <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Back">
           </form>
           
           <%} else {%>
        
           <form action="FrontController" method="Post">
           <input type="hidden" name="command" value="viewordersemp">
           <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Back">
           </form>
        <%}%>
        </div>
        </div>
    </body>
</html>
