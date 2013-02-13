<%-- 
    Document   : GestionarVentas
    Created on : 11/02/2013, 01:11:19 AM
    Author     : CORTEX
--%>
<%
HttpSession sesionOk = request.getSession();
%>
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
        <%if (sesionOk.getAttribute("rol").equals("Cajero")){%>  
        <fieldset>
            <legend>Registrar Venta</legend>
            <a target="_blank" href="../jsp/RegistrarVenta.jsp"  class="a-btn">
               <span class="a-btn-text">RegistrarVenta</span>
               <span class="a-btn-slide-text">Ventas</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Cajero")){%>  
        <fieldset>
            <legend>Movimientos de Caja</legend>
            <a target="algoX" href="AperturaCaja.jsp"  class="a-btn">
               <span class="a-btn-text">Apertura de</span>
               <span class="a-btn-slide-text">Caja</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
            <a target="_blank" href="CierreDeCaja.jsp"  class="a-btn">
               <span class="a-btn-text">Cierre de</span>
               <span class="a-btn-slide-text">Caja</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
            <fieldset>
                <legend>Retornar Venta</legend>
                <a target="_blank" href="RetornarVenta.jsp"  class="a-btn">
                   <span class="a-btn-text">Retornar</span>
                   <span class="a-btn-slide-text">Venta</span>
                   <span class="a-btn-icon-right">
                   <span></span>
                   </span>
                </a>
            </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
            <fieldset>
                <legend>Ingreso a Caja</legend>
                <a target="algoX" href="IngresoCaja.jsp"  class="a-btn">
                   <span class="a-btn-text">Ingreso</span>
                   <span class="a-btn-slide-text">Caja</span>
                   <span class="a-btn-icon-right">
                   <span></span>
                   </span>
                </a>
            </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
            <fieldset>
                <legend>Pago Proveedor</legend>
                <a target="algoX" href="PagoProveedor.jsp"  class="a-btn">
                   <span class="a-btn-text">Pago</span>
                   <span class="a-btn-slide-text">Proveedor</span>
                   <span class="a-btn-icon-right">
                   <span></span>
                   </span>
                </a>
            </fieldset> 
        <%}%>
        
    </body>
</html>
