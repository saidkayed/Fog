<%-- 
    Document   : productlist
    Created on : 09-05-2018, 15:25:07
    Author     : tobbe
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.Materials"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        <h1>Productlist</h1>
        
         <table>

                <%=Materials.materialToProductListHtml(materials)%>
            </table>
            
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
    </body>
</html>
