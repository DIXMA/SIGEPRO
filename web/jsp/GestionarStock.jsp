<%-- 
    Document   : GestionarStock
    Created on : 11/02/2013, 01:12:15 AM
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
        <%
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
        <fieldset>
            <legend>Consultar Productos en Stock Minimo</legend>
            <a href="ProductosEnStockMinimo.jsp" target="algoXXX" class="a-btn">
               <span class="a-btn-text">Stock</span>
               <span class="a-btn-slide-text">Minimo</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
        <fieldset>
            <legend>Entrada de Insumos</legend>
            <a href="RegistrarCompraProveedor.jsp" target="algoXXX" class="a-btn">
               <span class="a-btn-text">Registrar</span>
               <span class="a-btn-slide-text">Compra</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
        <fieldset>
            <legend>Añadir Proveedor</legend>
            <a href="RegistrarProveedor.jsp" target="algoX" class="a-btn">
               <span class="a-btn-text">Añadir</span>
               <span class="a-btn-slide-text">Proveedor</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
            <fieldset>
                <legend>Dar Baja a Insumo</legend>
                <a href="DarBajaInsumo.jsp" target="algoX" class="a-btn">
                   <span class="a-btn-text">Dar Baja</span>
                   <span class="a-btn-slide-text">Insumo</span>
                   <span class="a-btn-icon-right">
                   <span></span>
                   </span>
                </a>
            </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Administrador")){%>  
            <fieldset>
                <legend>Asignar Consumo Diario</legend>
                <a href="ScarConsumoDiario.jsp" target="_blank" class="a-btn">
                   <span class="a-btn-text">Sacar Consumo</span>
                   <span class="a-btn-slide-text">Diario</span>
                   <span class="a-btn-icon-right">
                   <span></span>
                   </span>
                </a>
            </fieldset> 
        <%}%>
    </body>
</html>
