<%-- 
    Document   : newjspRealizarCompraProveedor
    Created on : 9/02/2013, 12:43:14 AM
    Author     : CORTEX
--%>

<%@page import="DAO.Venta_DAO"%>
<%@page import="java.util.*"%>
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
            String datos=request.getParameter("ocultosValores");
            String insumos[]=datos.split("%");
            String proveedor=request.getParameter("cmbProveedor");
            String datosProveedor[]=proveedor.split("_");
            String idProveedor=datosProveedor[0];
            Date fecha_actual=new Date(); 
            int dia_actual = fecha_actual.getDate(); 
            int mes_actual = fecha_actual.getMonth()+1; 
            int anio_actual = fecha_actual.getYear()+1900;
           String fech=dia_actual+"/"+mes_actual+"/"+anio_actual;
            String total=request.getParameter("totalVenta");
            
            String msj="Proveedor-> "+proveedor+"\nFecha-> "+fech+"\nTotal-> "+total+"\n";
            for(int i=0;i<insumos.length;i++)
            {
                String pas[]=insumos[i].split("-");
                msj+="id_Insumo-> "+pas[0]+" Nombre_Isumo-> "+pas[1]+" Precio_Insumo-> "+pas[2]+" Cantidad_Insumo-> "+pas[3]+"\n";
            }
            Facade cd=new Facade();
            boolean x=cd.registrarCompraProveedor(fech, idProveedor, total, insumos);
            boolean z=cd.actualizarInventario();
            
            
        %>
    </head>
    <body>
        <center><label>Registro de Ventas</label>
        <textarea readonly="" id="textVenta"><%=msj%></textarea></center>       
           <%
      if(z)
      {
          
            if(x)
            {%>
        <center><label>Compra realizada con Exito</label>  
        <a href="../jsp/RegistrarCompraProveedor.jsp" id="button4" class="buttonText4">Realizar otra Compra</a></center>
            <%}
                  else
                  { %>
        <center><label>Compra No realizada...FALLO!!!!</label>  
        <a href="../jsp/RegistrarCompraProveedor.jsp" id="button4" class="buttonText4">Realizar de nuevo</a></center>
                     <%}
      }else{%>
        <script>alert("No se pudo actualizar el inventario");</script>
      <%}
        %>
       <hr>
                <center>
                        <destacar><a href="../jsp/inicio.jsp">Volver a la Página Inicial</a></destacar>
                </center>
    </body>
</html>
