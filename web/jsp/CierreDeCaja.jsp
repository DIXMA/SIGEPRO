<%-- 
    Document   : CierreDeCaja
    Created on : 12/02/2013, 10:02:36 PM
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
        <%
            Facade w=new Facade();
            String mensaje="";
            String s[]=w.registrarCierreDeCaja().split("&");
            mensaje="Total Ventas Dia: "+s[0]+"\nTotal Apertura en Caja: "+s[1];
        %>
        
    </head>
    <body>
        <body id="bodyPricipal">
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoIiSecion">
               <label>Caja cerrada......</label>
               <center><textarea readonly="" id="textVenta"><%=mensaje%></textarea></center>
            </div>
            
                     
            <div id="PieVaildarUser">
           <center><label>Copyright &copy; 2013 grupo Analisis y Diseño de Sistemas ufps IIsem 2012</label></center>  
            
            </div>
        </div>
        
        
        
    </body>
</html>
