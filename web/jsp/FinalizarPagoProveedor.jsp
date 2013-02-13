<%-- 
    Document   : FinalizarPagoProveedor
    Created on : 13/02/2013, 12:33:33 AM
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
            String datos=request.getParameter("cmbDeudas");
            String obj[]=datos.split("-");
            String msj="Deuda Proeedor Cancelada: "+"\n"+datos;;
            String s[]=new String[3];
            Facade f=new Facade();
            
            for(int i=0;i<obj.length;i++)
            {
                s[0]=obj[1];
                s[1]=obj[3];
                s[2]=obj[5];
            }
            boolean x=f.descontarPagoDeuda(s);
            boolean z=f.pagoProveedor(s);
        %>
    </head>
    <body>
        <center><label>Registro Paho Proveedor</label>
        <textarea readonly="" id="textVenta"><%=msj%></textarea></center>  
    </body>
</html>
