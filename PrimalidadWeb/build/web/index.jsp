<%-- 
    Document   : index
    Created on : Dec 13, 2015, 10:56:56 AM
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            primalidad.Primalidad primo;
            primo = new primalidad.Primalidad(23);
        %>
        <%=primo.getValor()%>
        
        <%
        for(int i= 2; i <100; i++) {
            if(primo.esPrimo(i)) { 
        %>
                <%=i + ": Es primo <br>"%>
        <%  }  else  {%>
                <%=(i + ": No es primo<br>")%>
        <%} }%>
        
        <%="MCD: " + primo.mcd(120,30)%>
        
    </body>
</html>
