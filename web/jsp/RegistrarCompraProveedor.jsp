<%-- 
    Document   : RegistrarCompraProveedor
    Created on : 30/01/2013, 02:52:42 PM
    Author     : CORTEX
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Business.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar Proveedor</title>
        <style type="text/css">              
            <%@include file = "../css/estio.css"%> 
        </style>
        
        <!-- Necesario para añadir y quitar filas a la tabla -->
        <SCRIPT language="javascript">
            function addRow(tableID,id,prec,valor,idProd) 
            {
               var table = document.getElementById(tableID);
               var rowCount = table.rows.length;
               var bool=verificarValor(valor, idProd, rowCount);
               if(bool==true)
                { 
                    var row = table.insertRow(rowCount);
                    var cell1 = row.insertCell(0);
                    var element1 = document.createElement("input");
                    element1.type = "checkbox";
                    cell1.appendChild(element1);
                    var cell2 = row.insertCell(1);
                    var element2 = document.createElement("input");
                    element2.type = "text";
                    element2.value=prec;
                    element2.readonly = "";
                    element2.name="valProd";
                    cell2.appendChild(element2); 
                    var cell3 = row.insertCell(1);
                    var element3 = document.createElement("input");
                    element3.type = "text";
                    element3.value=id;
                    element3.readonly = "";
                    element3.name="nomProd";
                    cell3.appendChild(element3);
                    var cell4 = row.insertCell(1);
                    var element4 = document.createElement("input");
                    element4.type = "text";
                    element4.value=idProd;
                    element4.readonly = "";
                    element4.name="idProd";
                    cell4.appendChild(element4);
                    var cell5 = row.insertCell(1);
                    var element5 = document.createElement("input");
                    element5.type = "text";
                    element5.value="1";
                    element5.readonly = "";
                    element5.name="cantiProd";
                    element5.id=idProd+valor;
                    cell5.appendChild(element5);
                }
               calcularValor()
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
               calcularValor()
          }
          
            var total = 0;
            function calcularValor()
            {
                var suma = 0;
                var aux;
                var mul=document.formCompra.cantiProd;
                var y=document.formCompra.valProd;
                if(y.length==undefined)
                {
                    aux=parseFloat(y.value);
                    total=aux*parseFloat(mul.value);
                    document.formCompra.totalVenta.value = total;
                }
                else
                {   
                    for(var i=0;i<document.formCompra.valProd.length;i++)
                    {         
                              total=suma;
                              suma += (parseFloat(y[i].value)*parseFloat(mul[i].value));
                              if (isNaN(suma)) suma = total;                              
                    }
                    document.formCompra.totalVenta.value = suma;
                }
                
            }
            
            var cad ;
            function cocatenarVender()
            {
                var nombres=document.formCompra.nomProd;
                var precios=document.formCompra.valProd;
                var id=document.formCompra.idProd;
                var cant=document.formCompra.cantiProd;
                if(nombres.length==undefined && precios.length==undefined && id.length==undefined)
                {
                    cad=id.value+"-"+nombres.value+"-"+precios.value+"-"+cant.value+"%";
                    document.formCompra.ocultosValores.value=cad;
                }
                else
                {
                    
                    for(var i=0;i<document.formCompra.idProd.length;i++)
                    {  
                        if(i==0)cad=id[0].value+"-"+nombres[0].value+"-"+precios[0].value+"-"+cant[i].value+"%";
                        else
                        cad+=id[i].value+"-"+nombres[i].value+"-"+precios[i].value+"-"+cant[i].value+"%";
                    }
                    document.formCompra.ocultosValores.value=cad;
                }
            }
            
            
            function verificarValor(valor, id, fila)
            {
              if(fila>1)
              {  
                  //alert("aqui va en el if row->"+fila)
                  var comun=document.formCompra.idProd;
                  
                  //alert("tamaño w ->"+comun.length);
                  if(document.formCompra.idProd.length==undefined)
                  {  
                      if(comun.value==id)
                      {
                        var d=parseFloat(document.getElementById(id+valor).value);
                        document.getElementById(id+valor).value=d+1;
                        return false;
                       }
                  }
                  //alert("else comon ->"+comun.length);
                        for(var x=0;x<comun.length;x++)
                        {
                            //alert("entra for compara "+comun[x].toString()+ " con "+id);
                             if(comun[x].value==id)
                             { 
                               var d=parseFloat(document.getElementById(id+valor).value);
                               document.getElementById(id+valor).value=d+1;
                               return false;
                             }
                        }
                  
              }
              return true;
                           
            }
            
           
            
            
            
    </SCRIPT>
     
     
    </head>
     <body id="bodyPricipal">
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoIiSecion">
                
                
        <form id="registroCompra" name="formCompra" action="RealizarCompraProveedor.jsp">
            <fieldset>
                <input type="text"  id="valoresOcultos" name="ocultosValores">             
                <legend>Compra Proveedor</legend>    
                <center>
                <label>Proveedor</label>
                <select name="cmbProveedor" size=1 > 
                    <%
                    Facade p=new Facade();
                    ArrayList<String> proveedores=p.cargarProveedor();
                    int a=proveedores.size();
                    if(a>0)
                    {
                        for(int i=0;i<a;i++)
                        {%>
                        <option><%=proveedores.get(i)%></option>      
                      <%}
                    }
                    %>
                </select>
                </center>
                <br>
                <br>
                <br>
            </fieldset>
            <fieldset>                
                <legend>Seleccion de Productos Comprados</legend>
                 <center>
                    <a href="#" id="button2" class="buttonText4" onclick="deleteRow('TBprodVenta');">Eliminar Insumo</a>
                    <a href="#openModal" id="button3" class="buttonText4" >Agregar Insumo</a>
                    <center><label>Total Venta:</label><input type="text" name="totalVenta" id="costoVenta" readonly = "" value="0"></center>
                    <table id="TBprodVenta" width="350px" border="1">
                        <tr>
                            <th scope="col">Selec</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">id_Insumo</th>
                            <th scope="col">Nombre Insumo</th>
                            <th scope="col">Precio Insumo</th>
                        </tr>  
                        
                    </table>
                    
                </center>
                  <br>
                  <br>
                  <br>
                <input type="submit" class="botonEnvio" id="enviarCompra" value="Registrar Compra" onclick="cocatenarVender();">
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
                                  <input class="button amarilloAdicional" type="button" name="Dar de Baja" id="adicional" value="<%=dat[1] %>" onclick="addRow('TBprodVenta','<%=dat[1] %>','0','<%=i%>','<%=dat[0] %>')" >
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
