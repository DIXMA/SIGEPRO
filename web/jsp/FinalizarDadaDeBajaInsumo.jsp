<%-- 
    Document   : FinalizarDadaDeBajaInsumo
    Created on : 12/02/2013, 11:43:01 AM
    Author     : CORTEX
--%>

<%@page import="java.util.Date"%>
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
            String msj="INSUMOS:"+"\n";
            for(int i=0;i<insumos.length;i++)
             {
                 String pas[]=insumos[i].split("-");
                 msj+="Id Insumo-> "+pas[0]+" Cantidad-> "+pas[1]+"\n";
             }
            boolean z=false;
             Facade f=new Facade();
             boolean w=false;
             boolean x=f.darBajaInsumo(insumos);
             
         %>
    </head>
    <body id="bodyPricipal">
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoIiSecion">
                 <center><label>Registro de Ventas</label>
        <textarea readonly="" id="textVenta"><%=msj%></textarea></center>       
           <%
           

                if(x)
                {%>
                    <center><label>Salida realizada con Exito</label>  
                        <a href="../jsp/DarBajaInsumo.jsp" id="button4" class="buttonText4">Realizar otra Salida</a></center>
                <%}
                  else
                  { %>
                        <center><label>Salida No realizada...FALLO!!!!</label>  
                        <a href="../jsp/DarBajaInsumo.jsp" id="button4" class="buttonText4">Realizar de nuevo</a></center>
                  <%}
      
        %>
        
            </div>
            <div id="PieVaildarUser">  
            </div>
     </div>
          
    </body>
</html>
