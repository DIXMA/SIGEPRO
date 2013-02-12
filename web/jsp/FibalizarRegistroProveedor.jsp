<%-- 
    Document   : FibalizarRegistroProveedor
    Created on : 12/02/2013, 02:29:36 AM
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
        String idP=request.getParameter("id_proveedor");
        String nomP=request.getParameter("nombre_proveedor");
        String nitP=request.getParameter("nit_proveedor");
        String direcP=request.getParameter("direccion_proveedor");
        String telP=request.getParameter("telefono_proveedor");
        String mensaje="Datos Proveedor"+"\n"+"Id-Proveedor->"+idP+" Nombre_Proveedor->"+nomP+" Nit_Proveedor->"+nitP+" Direccion_Proveedor->"+direcP+" Telefono_Proveedor->"+telP;
        Facade f=new Facade();
        boolean x=f.registrarProveedor(idP, nitP, nomP, direcP, telP);
        %>
    </head>
    <body>
        <center><label>Registro de Ventas</label>
        <textarea readonly="" id="textVenta"><%=mensaje%></textarea></center>
         <%if(x){%>
        <center><label>Registro realizado con Exito</label>  
        <a href="RegistrarProveedor.jsp" id="button4" class="buttonText4">Reagistrar Nuevo</a></center>
        <%}else{%>
        <center><label>Registro No realizado...FALLO!!!!</label>  
        <a href="RegistrarProveedor.jsp" id="button4" class="buttonText4">Realizar de nuevo</a></center>
        <%}%>
        
        
           <hr>
                <center>
                        <destacar><a href="../jsp/PrincipalPlayShots.jsp">Volver a la Página Inicial</a></destacar>
                </center>
    </body>
</html>
