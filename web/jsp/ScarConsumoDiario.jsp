<%-- 
    Document   : ScarConsumoDiario
    Created on : 11/02/2013, 01:57:43 AM
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
        
        <!-- Necesario para añadir y quitar filas a la tabla -->
        <SCRIPT language="javascript">
            function addRow(tableID,id_insumo) 
            {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    var row = table.insertRow(rowCount);
                    //var bool=verificarValor(id_insumo, rowCount);
                            
                            
                        var cell1 = row.insertCell(0);
                        var element1 = document.createElement("input");
                        element1.type = "checkbox";
                        element1.readonly = "";
                        element1.name="Select";
                        cell1.appendChild(element1);    
                        var cell2 = row.insertCell(1);
                        var element2 = document.createElement("input");
                        element2.type = "text";
                        element2.readonly = "";
                        element2.name="IdInsu";
                        element2.value=id_insumo;
                        cell2.appendChild(element2);
                        var cell3 = row.insertCell(1);
                        var element3 = document.createElement("input");
                        element3.type = "text";
                        element3.value="1";
                        element3.name="cantInsumo";
                        element3.id=id_insumo;
                        cell3.appendChild(element3); 
                    
                    cocatenarVender();               
           }
               function deleteRow(tableID) 
                    {    total=0;
                         try 
                         {
                             var table = document.getElementById(tableID);                
                             var rowCount = table.rows.length;               
                                 for(var i=0; i<rowCount; i++) 
                                 {
                                      var row = table.rows[i];
                                      var chkbox = row.cells[0].childNodes[0];
                                          if(null != chkbox && true == chkbox.checked) 
                                          {
                                               table.deleteRow(i);
                                               rowCount--;
                                               i--;
                                          }
                                 }

                                 if(rowCount==1)
                                 {
                                      document.formCompra.totalVenta.value="0";
                                      document.formCompra.ocultosValores.value="";
                                 }else{
                                     cocatenarVender();
                                 }
                         }catch(e)
                         {
                              alert(e);
                         }
                    }
            var cad ;
            function cocatenarVender()
            {
                var nombres=document.formCompra.nomProd;
                var precios=document.formCompra.valProd;
                var id=document.formCompra.IdInsu;
                var cant=document.formCompra.cantInsumo;
                if(id.length==undefined)
                {
                    cad=id.value+"-"+cant.value+"%";
                    document.formCompra.ocultosValores.value=cad;
                }
                else
                {
                    
                    for(var i=0;i<document.formCompra.IdInsu.length;i++)
                    {  
                        if(i==0)cad=id[0].value+"-"+cant[0].value+"%";
                        else
                        cad+=id[i].value+"-"+cant[i].value+"%";
                    }
                    document.formCompra.ocultosValores.value=cad;
                }
                
                
             function verificarValor(id, fila)
            {
              if(fila>1)
              {  
                  alert("aqui va en el if row->"+fila)
                  var comun=document.formCompra.IdInsu;
                  
                  alert("tamaño w ->"+comun.length);
                  if(document.formCompra.IdInsu.length==undefined)
                  {  
                      if(comun.value==id)
                      {
                        var d=parseFloat(document.getElementById(id).value);
                        document.getElementById(id).value=d+1;
                        return false;
                       }
                  }
                  alert("else comon ->"+comun.length);
                        for(var x=0;x<comun.length;x++)
                        {
                            alert("entra for compara "+comun[x].toString()+ " con "+id);
                             if(comun[x].value==id)
                             { 
                               var d=parseFloat(document.getElementById(id).value);
                               document.getElementById(id).value=d+1;
                               return false;
                             }
                        }
                  
              }
              return true;
                           
            }
                
            }
      </script>
    </head>
    <body id="bodyPricipal">
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoIiSecion">
                
                
        <form id="registroCompra" name="formCompra" action="FinalizarSaildaDida.jsp">
            <input type="text" id="valoresOcultos" name="ocultosValores">        
            <fieldset>                
                <legend>Seleccion de Insumo</legend>
                 <center>
                    <a href="#" id="button2" class="buttonText4" onclick="deleteRow('TBprodVenta');">Eliminar Insumo</a>
                    <a href="#openModal" id="button3" class="buttonText4" >Agregar Insumo</a>
                    
                    <table id="TBprodVenta" width="350px" border="1">
                        <tr>
                            <th scope="col">select</th>
                            <th scope="col">id_Insumo</th>
                            <th scope="col">Cantidad</th>
                        </tr>  
                        
                    </table>
                    
                </center>
                  <br>
                  <br>
                  <br>
                  <input type="submit" class="botonEnvio" id="enviarCompra" value="Registrar Salida DIa" onclick="cocatenarVender();">
            </fieldset>
        </form>
                
           <div id="openModal" class="modalDialog">
                   <div>
                        
                       <a href="#close" title="Close" class="close" onclick="">X</a>
                            <center>                  
                            <%
                             Facade x=new Facade();
                             ArrayList<String> ad=x.cargarInsumos();
                             for(int i=0;i<ad.size();i++){
                                  String dat[]=ad.get(i).split("%"); %>
                                  <input class="button amarilloAdicional" type="button" name="Dar de Baja" id="adicional" value="<%=dat[1] %>" onclick="addRow('TBprodVenta','<%=dat[0] %>')" >
                            <%}%>
                                
                            </center>
                       
                    </div>
                  
               </div>
              
                
         <hr>
                <center>
                        <destacar><a href="../jsp/inicio.jsp">Volver a la Página Inicial</a></destacar>
                        <center><label>Copyright &copy; 2013 grupo Analisis y Diseño de Sistemas ufps IIsem 2012</label></center>  
                </center>
                
            </div>
            
                     
            <div id="PieVaildarUser">
           
            
            </div>
        </div>
        
    </body>
</html>
