<%-- 
    Document   : verificarInformes
    Created on : 31/01/2013, 09:49:09 AM
    Author     : CORTEX
--%>
<%@page import="Business.Facade"%>
<%
HttpSession sesionOk = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.GeneradorReportes"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informes</title>
        <style type="text/css">              
            <%@include file = "../css/estio.css"%> 
        </style> 
        <!-- Necesario para el Caledario -->
	<link rel="stylesheet" type="text/css" href="../css/tcal.css" />
	<script type="text/javascript" src="../css/tcal.js"></script> 
        <%Facade x=new Facade();%>
    </head>
    <body >
        
        <form>
            <fieldset>
                <legend>Rago de Fecha</legend>
                <label>Fecha Desde<input type="text" readonly="" name="date" class="tcal" value="" id="FechaDesde"/></label><label>Fecha Hasta<input type="text" readonly="" name="date" class="tcal" value="" id="FechaDesde"/></label>
            </fieldset>
           <%
            if (sesionOk.getAttribute("rol").equals("Administrador")){%> 
            <fieldset>
                <legend>Informes Administrador</legend>
                    <center>
                        <a href="#" class="enlace boton" onclick="">VentasDiarias</a> 
                        <a href="#" class="enlace boton" onclick="">Existencias en Bodega</a> 
                    </center>
            </fieldset>
            <%}
            if (sesionOk.getAttribute("rol").equals("Propietario")){%> 
            <fieldset>
                <legend>Informes Propietario</legend>
                    <center>
                        <a href="#" class="enlace boton" onclick="">Venta de Shots y Cocteles</a> 
                        <a href="#" class="enlace boton" onclick="">Insumos Utilizados</a> 
                        <a href="#" class="enlace boton" onclick="">Ventas Vs Produccion</a> 
                        <a href="#" class="enlace boton" onclick="<% x.informeCompraInsumo(); %>">Compra de Insumos</a> 
                        <a href="#" class="enlace boton" onclick="">Dadas de Baja</a> 
                    </center>
            </fieldset>
            <%}%>
        </form>
        <hr>
                <center>
                        <destacar><a href="../jsp/PrincipalPlayShots.jsp">Volver a la Página Inicial</a></destacar>
                </center>
            
    </body>
</html>
