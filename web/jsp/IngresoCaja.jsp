<%-- 
    Document   : IngresoCaja
    Created on : 11/02/2013, 01:35:39 AM
    Author     : CORTEX
--%>

<%@page import="Business.Facade"%>
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
            <legend>Ingreso a Caja</legend>
            <form action="../jsp/FinalizarInagresoAcaja.jsp">
                <label>Cantidad de Dienro Ingreso</label><input type="text" name="canDiero" value="0">
                <input type="submit" value="Registrar" >
             </form>              
       </fieldset>
    </body>
</html>
