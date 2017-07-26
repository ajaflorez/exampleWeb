<%-- 
    Document   : newjsp01
    Created on : Jul 25, 2015, 9:13:57 PM
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
        <jsp:useBean id="encuesta" scope="request" class="pe.kamachi.web01.model.Encuesta" />
        <h1>Gracias por llenar los datos</h1>
        <p>
            <jsp:getProperty name="encuesta" property="fullName" /> 
            <%= encuesta.getFullName() %>
            Nos has indicado que estas familiarizado con los siguientes lenguajes:
        </p>
        <%
            String[] langProg = encuesta.getLangProg();
            if(langProg != null) {
        %>
        <ul>
            <%
                for(int i = 0; i < langProg.length; i++) {
            %>
            <li>
                <%= langProg[i]%>
            </li>
            <%  }   %>
        </ul>
        <%  }   %>
    </body>
</html>
