<%-- 
    Document   : GestionarProductos
    Created on : 11/02/2013, 01:11:57 AM
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
        <%if (sesionOk.getAttribute("rol").equals("Propietario")){%>  
        <fieldset>
            <legend>Listar Productos</legend>
            <a href="ListarProductos.jsp" target="algoXXX" class="a-btn">
               <span class="a-btn-text">Listar</span>
               <span class="a-btn-slide-text">Produtos</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Propietario")){%>  
        <fieldset>
            <legend>Agregar Productos</legend>
            <a href="AñadirInsumo.jsp" target="algoXXX" class="a-btn">
               <span class="a-btn-text">Registrar</span>
               <span class="a-btn-slide-text">Insumo</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
            <a href="RegistrarReceta.jsp" target="algoXXX" class="a-btn">
               <span class="a-btn-text">Registrar</span>
               <span class="a-btn-slide-text">Receta</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Propietario")){%>  
        <fieldset>
            <legend>Modificar Productos</legend>
            <a href="ModicarProductos.jsp" target="algoXXX" class="a-btn">
               <span class="a-btn-text">Modifiacr</span>
               <span class="a-btn-slide-text">Productos</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}
        if (sesionOk.getAttribute("rol").equals("Propietario")){%>  
        <fieldset>
            <legend>Desactivar Productos</legend>
            <a href="DesactivarProducto.jsp" target="algoXXX" class="a-btn">
               <span class="a-btn-text">Desactivar</span>
               <span class="a-btn-slide-text">Productos</span>
               <span class="a-btn-icon-right">
               <span></span>
               </span>
            </a>
        </fieldset> 
        <%}%>
        
    </body>
</html>
