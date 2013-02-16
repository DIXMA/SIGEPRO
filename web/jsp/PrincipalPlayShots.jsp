<%-- 
    Document   : PrincipalPlayShots
    Created on : 3/01/2013, 05:58:44 PM
    Author     : CORTEX
--%>
<%
HttpSession sesionOk = request.getSession();
String nombre=(String)sesionOk.getAttribute("rol");
if(nombre==null)
{%>
<a href="../index.jsp">Debe iniciar secion</a>
<%}
else{
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Play Shots</title>
        
         <style type="text/css">              
            <%@include file = "../css/estio.css"%> 
            <%@include file = "../css/style3.css"%>
        </style>
        
    </head>
    <body id="bodyPricipal"> 
   <a href="../cerrar.jsp" id="button2" class="buttonText">Cerrar Sesion</a>
  <a href="http://ingsistemas.ufps.edu.co/ingsistemas/"><img src="../img/u.png" title="Ir arriba" style="position: fixed; bottom: 10px; right: 2%;" id="u"/></a>
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoVaildarUser" >
                
                <iframe src="inicio.jsp" name="algoX" width = "820 " height = " 560 " id="nuevoIframs">
                    
                </iframe>	    
                             
                 
            </div>
            
            <div id="menuValUSer">
                <center>MENU
                    <%
                    
                    if (sesionOk.getAttribute("rol").equals("Administrador")||sesionOk.getAttribute("rol").equals("Cajero")){
                    %>
                    <a href="GestionarVentas.jsp" target="algoX" class="a-btn">
                        <span class="a-btn-text">Gestionar</span>
                        <span class="a-btn-slide-text">Ventas</span>
                        <span class="a-btn-icon-right">
                        <span></span>
                        </span>
                     </a>
                     <%}
                    if (sesionOk.getAttribute("rol").equals("Administrador")||sesionOk.getAttribute("rol").equals("Propietario")){%>
                     <a href="verificarInformes.jsp" target="algoX" class="a-btn">
                        <span class="a-btn-text">Consultar</span>
                        <span class="a-btn-slide-text">Informes</span>
                        <span class="a-btn-icon-right">
                        <span></span>
                        </span>
                     </a>
                    <%}
                    if (sesionOk.getAttribute("rol").equals("Propietario")){%>
                     <a href="GestionarProductos.jsp" target="algoX" class="a-btn">
                        <span class="a-btn-text">Gestionar</span>
                        <span class="a-btn-slide-text" >Productos</span>
                        <span class="a-btn-icon-right">
                        <span></span>
                        </span>
                     </a>  
                     <%}
                    if (sesionOk.getAttribute("rol").equals("Administrador")){%>
                      <a href="GestionarStock.jsp" target="algoX" class="a-btn">
                        <span class="a-btn-text">Gestionar</span>
                        <span class="a-btn-slide-text" >Stock</span>
                        <span class="a-btn-icon-right">
                        <span></span>
                        </span>
                      </a>
                    <%}%>
                    
                 </center>
            </div>
            
            <div id="PieVaildarUser">
                <center><label>Copyright &copy; 2013 grupo Analisis y Diseño de Sistemas ufps IIsem 2012</label></center>            
            </div>
        </div>
    </body>
</html>
<%}%>