<%-- 
    Document   : FinalizarAperturaCaja
    Created on : 12/02/2013, 03:21:15 PM
    Author     : CORTEX
--%>

<%@page import="Business.Facade"%>
<%@page import="java.util.Date"%>
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
            String valorIni=request.getParameter("canDiero");
            Date fecha_actual=new Date(); 
            int dia_actual = fecha_actual.getDate(); 
            int mes_actual = fecha_actual.getMonth()+1; 
            int anio_actual = fecha_actual.getYear()+1900;
            String fech=dia_actual+"/"+mes_actual+"/"+anio_actual;
            String msj="Apertura de Caja:"+"\nFecha:"+fech+"\nCantidad Inicial: "+valorIni;
            Facade f=new Facade();
            boolean x=f.realizarAperturaCaja(valorIni, fech);
        %>
    </head>
    <body>
        <center><label>Registro de Apertura de Caja</label>
        <textarea readonly="" id="textVenta"><%=msj%></textarea></center>       
        <%if(x){%>
            <center><label>Apertura realizada con Exito</label>  
                    <a href="../jsp/AperturaCaja.jsp" id="button4" class="buttonText4">Retornar</a></center>
        <%}
           else{%>
           <label>Apertura no realizada Consulte al Administrador del sistema</label>
    <%}%>
    </body>
</html>
