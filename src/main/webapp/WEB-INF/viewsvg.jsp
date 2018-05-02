<%-- 
    Document   : viewsvg
    Created on : 30-04-2018, 12:24:33
    Author     : tobbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int length = (Integer) request.getAttribute("length");
    int width = (Integer) request.getAttribute("width");
    
    double doublelength = length;
    double doublewidth = width;
    double square = doublelength*doublewidth/10000;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <svg
            width=<%=width + 20%> height=<%=length + 20%>>
        <rect x="20" y="20" height=<%=length + 20%> width=<%=width + 20%>
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
    <text x=<%=width / 2%> y=<%=length / 5%> font-family="sans-serif" font-size="20px" fill="blue"><%=square%> m2</text> 

    </svg>
    <form>
        <form name="makeorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="makeorder">
            <input type="hidden" name="length" value=<%=length%>>
            <input type="hidden" name="width" value=<%=width%>>
            <input type="submit" value="Make Order">
        </form>
    </body>
</html>
