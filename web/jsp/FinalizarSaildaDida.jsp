<%-- 
    Document   : FinalizarSaildaDida
    Created on : 12/02/2013, 04:13:25 AM
    Author     : CORTEX
--%>

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
            Date fecha_actual=new Date(); 
            int dia_actual = fecha_actual.getDate(); 
            int mes_actual = fecha_actual.getMonth()+1; 
            int anio_actual = fecha_actual.getYear()+1900;
            String fech=dia_actual+"/"+mes_actual+"/"+anio_actual;
            String hora=fecha_actual.getHours()+":"+fecha_actual.getMinutes();
            String msj="Fecha de Salida-> "+fech+"\n"+"Hora-> "+hora+"\n"+"INSUMOS:"+"\n";
            for(int i=0;i<insumos.length;i++)
             {
                 String pas[]=insumos[i].split("-");
                 msj+="Id Insumo-> "+pas[0]+" Cantidad-> "+pas[1]+"\n";
             }
            boolean z=false;
             Facade f=new Facade();
             boolean w=false;
             boolean x=f.realizarSalidaConsumDia(insumos, fech, hora);
             if(x){z=f.restarUnidadesInsumoSalidaDia(insumos, fech);}
             if(z){w=f.restarInventPorSalidaDia(insumos, fech);}
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
            if(z&&w)
            {

                if(x)
                {%>
                    <center><label>Salida realizada con Exito</label>  
                    <a href="../jsp/ScarConsumoDiario.jsp" id="button4" class="buttonText4">Realizar otra Salida</a></center>
                <%}
                  else
                  { %>
                        <center><label>Salida No realizada...FALLO!!!!</label>  
                        <a href="../jsp/ScarConsumoDiario.jsp" id="button4" class="buttonText4">Realizar de nuevo</a></center>
                  <%}
      }else{%>
        <script>alert("No se pudo actualizar el inventario");</script>
      <%}
        %>
        
            </div>
            <div id="PieVaildarUser">  
            </div>
     </div>
   </body>
</html>
