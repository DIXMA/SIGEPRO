<%-- 
    Document   : AperturaCaja
    Created on : 12/02/2013, 01:59:05 PM
    Author     : CORTEX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">              
            <%@include file = "../css/estio.css"%> 
        </style>
    </head>
    <body>
        <fieldset>
            <legend>Apertura de Caja</legend>
            <form action="../jsp/FinalizarAperturaCaja.jsp">
                <label>Cantidad de Dienro Inicial</label><input type="text" name="canDiero" value="0">
                <input type="submit" value="Registrar" >
             </form>              
       </fieldset>
    </body>
</html>
