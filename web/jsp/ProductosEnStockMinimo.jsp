<%-- 
    Document   : ProductosEnStockMinimo
    Created on : 11/02/2013, 01:53:58 AM
    Author     : CORTEX
--%>

<%@page import="java.util.ArrayList"%>
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
        <script language="javascript">
                      
                       
            function addRow(tableID,id_insumo,nombre_insumo,contenido_insumo,unidades_insumo) 
            {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);
                    var cell1 = row.insertCell(0);
                    var element1 = document.createElement("input");
                    element1.type = "text";
                    element1.readonly = "";
                    element1.value=id_insumo;
                    cell1.appendChild(element1);
                    var cell2 = row.insertCell(1);
                    var element2 = document.createElement("input");
                    element2.type = "text";
                    element2.readonly = "";
                    element2.value=nombre_insumo;
                    cell2.appendChild(element2); 
                    var cell3 = row.insertCell(1);
                    var element3 = document.createElement("input");
                    element3.type = "text";
                    element3.value=contenido_insumo;
                    element3.readonly = "";
                    cell3.appendChild(element3);
                    var cell4 = row.insertCell(1);
                    var element4 = document.createElement("input");
                    element4.type = "text";
                    element4.readonly = "";
                    element4.value=unidades_insumo;
                    cell4.appendChild(element4);
                    
                }
          
          
        </script>
    </head>
    <body id="bodyPricipal">
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoIiSecion">
                <fieldset> 
                    <legend>Listado de Productos</legend>
                  
                    
                <center>
                    <table id="TBprodVenta" width="350px" border="1">
                        <tr>
                            <th scope="col">id_insumo</th>
                            <th scope="col">nombre_insumo</th>
                            <th scope="col">contenido</th>
                            <th scope="col">unidades</th>
                        </tr>  
                        
                    </table>
                    
                    <%
                        Facade f=new Facade();
                        ArrayList<String> datos=f.getInsumosStokMinimo();
                        if(datos.size()>0){
                            for(int i=0;i<datos.size();i++)
                            {
                                
                                String dto[]=datos.get(i).split("/");
                                String sx="<script type='text/javascript'>addRow('TBprodVenta','"+dto[0]+"','"+dto[1]+"','"+dto[2]+"','"+dto[3]+"');</script>";
                               %>
                               
                               <%=sx%>
                               
                            <%}
                        }
                    %>
                        

                </center>
                </fieldset>
                <center>
                        <destacar><a href="../jsp/PrincipalPlayShots.jsp">Volver a la Página Inicial</a></destacar>
                        <center><label>Copyright &copy; 2013 grupo Analisis y Diseño de Sistemas ufps IIsem 2012</label></center>  
            
                </center>
            </div>
            
                     
            <div id="PieVaildarUser">
           
           
            </div>
        </div>
    </body>
</html>
