<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String last_name = request.getAttribute("last_name").toString();    
%>
<h1>Hello <%= last_name %></h1>

