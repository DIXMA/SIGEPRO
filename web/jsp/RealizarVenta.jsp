<%-- 
    Document   : RealizarVenta
    Created on : 5/02/2013, 09:41:19 PM
    Author     : CORTEX
--%>

<%@page import="Business.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "java.util.Date" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">              
            <%@include file = "../css/estio.css"%> 
        </style> 
        
        <% String datos=request.getParameter("ocultosValores");
           String costo=request.getParameter("totalVenta");
           String obj[]=datos.split("%");
           Date fecha_actual=new Date(); 
            int dia_actual = fecha_actual.getDate(); 
            int mes_actual = fecha_actual.getMonth()+1; 
            int anio_actual = fecha_actual.getYear()+1900;
           String fech=dia_actual+"/"+mes_actual+"/"+anio_actual;
           String idMeser=request.getParameter("cmbMesero");           
           String datosMesero[]=idMeser.split("_");
           String mensaje="costo->"+costo+"\nfecha-> "+fech+"\nMesero-> "+idMeser+"\n";
           for(int i=0;i<obj.length;i++)
           {
               String pas[]=obj[i].split("-");
               mensaje+="idProd-> "+pas[0]+" nomProd-> "+pas[1]+" precProd-> "+pas[2]+" cantProd-> "+pas[3]+"\n";
           }             
           
           Facade vent=new Facade();
           boolean x=vent.realizarVenta(datosMesero[0], fech, costo, obj);
           String z=vent.restarConsumoDiaPorVenta(fech);
        %>
        
    </head>
    <body>
        
    <center><label>Registro de Ventas</label>
        <textarea readonly="" id="textVenta"><%=mensaje%></textarea></center>
        <%
      if(z!=null)
      {
          
            if(x)
            {%>
        <center><label>Venta realizada con Exito</label>  
        <a href="RegistrarVenta.jsp" id="button4" class="buttonText4">Realizar otra venta</a></center>
            <%}
                  else
                  { %>
    <center><label>Venta No realizada...FALLO!!!!</label>  
        <a href="RegistrarVenta.jsp" id="button4" class="buttonText4">Realizar de nuevo</a></center>
                     <%}
      }else{%>
        <script>alert(<%=z%>);</script>
      <%}
        %>
       <hr>
                <center>
                        <destacar><a href="../jsp/inicio.jsp">Volver a la Página Inicial</a></destacar>
                </center>
    </body>
</html>
