<%-- 
    Document   : mostrar.jsp
    Created on : 15/07/2016, 08:02:25 AM
    Author     : sistemas-16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // Se recepciona el objeto enviado por el Servlet
    Object obj = request.getAttribute("respuesta");
    // Convertir el objeto a string
    String texto = obj.toString();
    // convertir el string a int
    int valor = Integer.parseInt(texto);
    
    String num1 = request.getAttribute("num1").toString();
    String num2 = request.getAttribute("num2").toString();
%>    
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Operaciones Web</title>    
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
        <div class="row">
            <div class="col-md-4">izquierdo</div>
            <div class="col-md-4">
                
                <h3>Operaciones matemáticas</h3>    
                <p>EL resultado de <%=num1%> + <%=num2%> = <%=valor%></p>
            </div>
            <div class="col-md-4">derecho</div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>