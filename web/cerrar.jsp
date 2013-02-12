<%-- 
    Document   : cerrar
    Created on : 17-ene-2013, 3:13:33
    Author     : CORTEX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
HttpSession sesionOk = request.getSession();
sesionOk.setAttribute("usuario",null);
sesionOk.invalidate(); //destruye la sesion
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Secion</title>
    </head>
    <body>
        <h1>a abandonado la sesion, para ingresar nuevamente click <a href="./index.jsp">aqui</a></h1>
    </body>
</html>
