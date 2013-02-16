<%-- 
    Document   : RegistrarVenta
    Created on : 19/01/2013, 11:03:45 AM
    Author     : CORTEX
--%>

<%@page import="Business.Facade"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Venta</title>
        <style type="text/css">              
            <%@include file = "../css/estio.css"%> 
        </style>  
       
      
        <script language="javascript">
                      
                       
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
                            document.myForm.totalVenta.value="0";
                            document.myForm.ocultosValores.value="";
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
                var mul=document.myForm.cantiProd;
                var y=document.myForm.valProd;
                if(y.length==undefined)
                {
                    aux=parseFloat(y.value);
                    total=aux*parseFloat(mul.value);
                    document.myForm.totalVenta.value = total;
                }
                else
                {   
                    for(var i=0;i<document.myForm.valProd.length;i++)
                    {         
                              total=suma;
                              suma += (parseFloat(y[i].value)*parseFloat(mul[i].value));
                              if (isNaN(suma)) suma = total;                              
                    }
                    document.myForm.totalVenta.value = suma;
                }
                
            }
            var cad ;
            function cocatenarVender()
            {
                var nombres=document.myForm.nomProd;
                var precios=document.myForm.valProd;
                var id=document.myForm.idProd;
                var cant=document.myForm.cantiProd;
                if(nombres.length==undefined && precios.length==undefined && id.length==undefined)
                {
                    cad=id.value+"-"+nombres.value+"-"+precios.value+"-"+cant.value+"%";
                    document.myForm.ocultosValores.value=cad;
                }
                else
                {
                    
                    for(var i=0;i<document.myForm.idProd.length;i++)
                    {  
                        if(i==0)cad=id[0].value+"-"+nombres[0].value+"-"+precios[0].value+"-"+cant[i].value+"%";
                        else
                        cad+=id[i].value+"-"+nombres[i].value+"-"+precios[i].value+"-"+cant[i].value+"%";
                    }
                    document.myForm.ocultosValores.value=cad;
                }
            }
            
            
            function verificarValor(valor, id, fila)
            {
              if(fila>1)
              {  
                  //alert("aqui va en el if row->"+fila)
                  var comun=document.myForm.idProd;
                  
                  //alert("tamaño w ->"+comun.length);
                  if(document.myForm.idProd.length==undefined)
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
            
           
            
         
        </script>
        
          <%
             Facade dc=new Facade();
             boolean siP=dc.verificarSiCajaAbierta();
          %>
        
    </head>    
    <body id="bodyPricipal">
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoIiSecion">
             <%if(siP){%>
                
                 <form name="myForm" action="RealizarVenta.jsp" method="post">
            <input type="text"  id="valoresOcultos" name="ocultosValores">             
            <center><label><h1>Pedido:</h1></label></center> 
               <fieldset>  
                   <legend>Productos</legend>
                <center>
                    <br>
                    <br>
                    <br>
                    <a href="#openModal" class="buttonXX azul" >___</a>
                    <a href="#openModal1" class="buttonXX rojo" >___</a>
                    <a href="#openModalxx" class="buttonXX beige" >___</a>
                    <br>
                    <br>
                    <br>
                    <br>
                    <label>Realizado Por:</label>
                    <select id="IdNombMesero" name="cmbMesero" size=1 >
                        <%
                            Facade xz=new Facade();
                            ArrayList<String> dto=xz.cargarMesero();
                            if(dto.size()>0){
                                for(int i=0;i<dto.size();i++)
                                {%>
                                    <option><%=dto.get(i)%></option>  
                                <%}
                            }
                        %>
                    </select> 
                    <br>
                    <br>
                    <input type="submit" name="" value="realizar Venta" id="button3" class="buttonTex3t" onclick="">
                  
                </center>
               </fieldset> 
               <fieldset> 
                   <legend>Listado</legend>
                <br>
                <center>
                    <INPUT type="button" class="botonAddCols" value="Eliminar Producto" onclick="deleteRow('TBprodVenta');" />
                    <center><label>Total Venta:</label><input type="text" name="totalVenta" id="costoVenta" readonly = "" value="0"></center>
                    <table id="TBprodVenta" width="350px" border="1">
                        <tr>
                            <th scope="col">Selec</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Producto</th>
                            <th scope="col">Nombre Producto</th>
                            <th scope="col">Precio Producto</th>
                        </tr>  
                        
                    </table>
                    
                </center>
                <br>
                    <br>
               </fieldset>
                
                
                <%--<a href="#openModal">Open Modal</a>    "document.orderform.products.value+='Product 3 \n'" --%>
                <div id="openModal" class="modalDialog">
                   <div>
                        
                       <a href="#close" title="Close" class="close" onclick="">X</a>
                            <center>                  
                            <%
                             Facade x=new Facade();
                             ArrayList<String> ad=x.nombreYprecioProducto("A");
                             for(int i=0;i<ad.size();i++){
                                  String dat[]=ad.get(i).split("%"); %>
                                  <input class="button azulAdicional" type="button" name="Dar de Baja" id="shot" value="<%=dat[1] %>" onclick="addRow('TBprodVenta','<%=dat[1] %>','<%=dat[2] %>','<%=i%>','<%=dat[0] %>')" >
                            <%}%>
                                
                            </center>
                       
                    </div>
                  
               </div>
                        
               <div id="openModal1" class="modalDialog1">
                   <div>
                        
                       <a href="#close" title="Close" class="close" onclick="">X</a>
                            <center>                  
                                <%
                                Facade w=new Facade();
                                ArrayList<String> ot=w.nombreYprecioProducto("C");
                                 for(int i=0;i<ot.size();i++){
                                      String d[]=ot.get(i).split("%");%>
                                     <input class="button rojoAdicional" type="button" name="Dar de Baja" id="shot" value="<%=d[1] %>" onclick="addRow('TBprodVenta','<%=d[1] %>','<%=d[2] %>','<%=i%>','<%=d[0] %>')">
                                <%}%>
                            </center>
                    </div> 
               </div>             
                            
                
                <div id="openModalxx" class="modalDialogxx">
                   <div>
                        
                       <a href="#close" title="Close" class="close" onclick="">X</a>
                            <center>                  
                                <%
                                 Facade q=new Facade();
                                 ArrayList<String> wd=q.nombreYprecioProducto("S");
                                 for(int i=0;i<wd.size();i++){
                                        String a[]=wd.get(i).split("%"); %>
                                     <input class="button beigeAdicional" type="button" name="Dar de Baja" id="shot" value="<%=a[1] %>" onclick="addRow('TBprodVenta','<%=a[1] %>','<%=a[2] %>','<%=i%>','<%=a[0] %>')">
                                <%}%>
                            </center>
                    </div> 
               </div>               
                            
                <a href="#"><img src="../img/arriba.png" title="Ir arriba" style="position: fixed; bottom: 10px; left: 2%;" /></a>            
                <a href="http://ingsistemas.ufps.edu.co/ingsistemas/"><img src="../img/u.png" title="Ir arriba" style="position: fixed; bottom: 10px; right: 2%;" id="u"/></a>  
                      
         </form>
                            <br>                
                <hr>
                <center>
                        <destacar><a href="../jsp/PrincipalPlayShots.jsp">Volver a la Página Inicial</a></destacar>
                        <center><label>Copyright &copy; 2013 grupo Analisis y Diseño de Sistemas ufps IIsem 2012</label></center>  
                     
                </center>
                <%}
                 else{%> 
                 <h1>Debe realizar Apertura de Caja para Poder Vender</h1>
                 <%}%>
            </div>
           <br>
            <br>         
          <div id="PieVaildarUser">
           
            </div>
        </div>
        
        
       
    </body>
</html>
