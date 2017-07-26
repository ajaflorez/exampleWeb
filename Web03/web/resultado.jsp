<%-- 
    Document   : resultado
    Created on : Aug 7, 2015, 2:12:09 PM
    Author     : joao
--%>

<%@page import="pe.tsi.model.Employees"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
    </head>
    <body>
        <%  
            Employees empleado;
            Object objecto = request.getAttribute("enviado");
            empleado = (Employees)objecto;
            %>
        
        <h1>El resultado de procesar los datos  son: </h1>
        <div>
            ID: <%= empleado.getEmployee_id() %>
        </div>
        <div>
            Last name: <%= empleado.getLast_name() %>
        </div>
        <div>
            Description: <%= empleado.getDescription() %>
        </div>
        <div>
            JOB_ID: <%= empleado.getJob_id() %>
        </div>
        
    </body>
</html>
