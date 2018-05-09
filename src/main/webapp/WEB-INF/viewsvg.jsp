<%-- 
    Document   : viewsvg
    Created on : 30-04-2018, 12:24:33
    Author     : tobbe
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("user");

    int length = (Integer) request.getAttribute("length");
    int width = (Integer) request.getAttribute("width");
    int height = (Integer) request.getAttribute("height");
    String shed = (String) request.getAttribute("shed");
    String roof = (String) request.getAttribute("roof");

    double doublelength = length;
    double doublewidth = width;
    double square = doublelength * doublewidth / 10000;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
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
        <br><br><br>
        <svg
            width="1000" height="1000">
        <rect x="20" y="20" height=<%=length%> width=<%=width%>
              style="stroke:#000000; fill: lightgray"/>
        <defs>
        <marker id="beginArrow" 
                markerWidth="9" markerHeight="9" 
                refX="0" refY="4" 
                orient="auto">
            <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
        </marker>
        <marker id="endArrow" 
                markerWidth="9" markerHeight="9" 
                refX="8" refY="4" 
                orient="auto">
            <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
        </marker>
        </defs>
        <line x1="20" y1="20" x2=<%=width + 20%> y2="20" 
              style="stroke:black;
              marker-start: url(#beginArrow);
              marker-end: url(#endArrow);"/>


        <line stroke-dasharray="5, 5" x1=<%=width + 20%> y1=<%=length + 20%> x2="20" y2="20"
              style="stroke:rgb(0,0,255);stroke-width:2" />

        <line stroke-dasharray="5, 5" x1=<%=width + 20%> y1="20" x2="20" y2=<%=length + 20%>
              style="stroke:rgb(0,0,255);stroke-width:2" />


        <defs>
        <marker id="beginArrow" 
                markerWidth="9" markerHeight="9" 
                refX="0" refY="4" 
                orient="auto">
            <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
        </marker>
        <marker id="endArrow" 
                markerWidth="9" markerHeight="9" 
                refX="8" refY="4" 
                orient="auto">
            <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
        </marker>
        </defs>
        <line x1="20" y1="20" x2="20" y2=<%=length + 20%> 
              style="stroke:black;
              marker-start: url(#beginArrow);
              marker-end: url(#endArrow);"/>

              <text x=<%=width / 2%> y="15" font-family="sans-serif" font-size="20px" fill="red"><%=width%> cm</text>
        <text writing-mode="tb" x="10" y=<%=length / 2%> font-family="sans-serif" font-size="20px" fill="red"><%=length%> cm</text>
        <text x=<%=width / 2%> y=<%=length / 5 + 20%> font-family="sans-serif" font-size="20px" fill="blue"><%=square%> m2</text> 

        <%if(shed != null){
            if(shed.equals("withshed1x1")){%>
            <rect x=<%=width - 80%> y=<%=length - 80%> height="100" width="100"
                style="stroke:#000000; fill: grey"/>
            <text x=<%=width - 75%> y=<%=length - 50%> font-family="sans-serif" font-size="20px" fill="blue">1mx1m</text>
            <text x=<%=width - 75%> y=<%=length - 30%> font-family="sans-serif" font-size="20px" fill="blue">shed</text>
                <%}
            if(shed.equals("withshed2x2")){%>
            <rect x=<%=width - 180%> y=<%=length - 180%> height="200" width="200"
                style="stroke:#000000; fill: grey"/>
            <text x=<%=width - 120%> y=<%=length - 120%> font-family="sans-serif" font-size="20px" fill="blue">2mx2m Shed</text>
                <%}
        }%>
        </svg>
        <br><br><br>
        <form>
            <form name="makeorder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="makeorder">
                <input type="hidden" name="length" value=<%=length%>>
                <input type="hidden" name="width" value=<%=width%>>
                <input type="hidden" name="height" value=<%=height%>>
                <input type="hidden" name="roof" value=<%=roof%>>
                <input type="hidden" name="shed" value=<%=shed%>>
                


                <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Make Order">
            </form>
    </center>
</body>
</html>
