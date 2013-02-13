<%-- 
    Document   : FinalizarInagresoAcaja
    Created on : 12/02/2013, 11:05:41 PM
    Author     : CORTEX
--%>

<%@page import="Business.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
    <%
    String ret=request.getParameter("canDiero");
    Facade f=new Facade();
    boolean x=f.ingreso_Caja(ret);
    String msj="Agrgado a Caja-> "+ret;
    %>
    </head>
    
    <body>
        <center><label>Registro de Apertura de Caja</label>
        <textarea readonly="" id="textVenta"><%=msj%></textarea></center>       
        <%if(x){%>
            <center><label>Apertura realizada con Exito</label>  
                    <a href="../jsp/IngresoCaja.jsp" id="button4" class="buttonText4">Retornar</a></center>
        <%}
           else{%>
           <label>Apertura no realizada Consulte al Administrador del sistema</label>
    <%}%>
    </body>
</html>
