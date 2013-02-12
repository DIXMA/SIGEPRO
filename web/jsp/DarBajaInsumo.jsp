<%-- 
    Document   : DarBajaInsumo
    Created on : 11/02/2013, 01:56:56 AM
    Author     : CORTEX
--%>

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
            
            
           
       </script> 
    </head>
    <body>
        
    </body>
</html>
