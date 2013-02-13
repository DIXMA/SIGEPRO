<%-- 
    Document   : RegistrarProveedor
    Created on : 11/02/2013, 01:55:46 AM
    Author     : CORTEX
--%>

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
            function limpiarDatos()
            {
                document.getElementById("RegProv").reset();
            }
            function validarDatos()  
             {
                  var formulario=document.getElementById("RegProv");
                  if(formulario.id_proveedor.value.length==0) 
                  { //comprueba que no esté vacío
                    formulario.id_proveedor.focus();   
                    alert('No has escrito el id_proveedor'); 
                    return false; //devolvemos el foco
                  }
                  if(formulario.nombre_proveedor.value.length==0) 
                  { //comprueba que no esté vacío
                    formulario.nombre_proveedor.focus();
                    alert('No has escrito el nombre_proveedor');
                    return false;
                  }
                  if(formulario.direccion_proveedor.value.length==0) 
                  {  //comprueba que no esté vacío
                    formulario.direccion_proveedor.focus();
                    alert('No has escrito la direccion_proveedor');
                    return false;
                  }
                  if(formulario.telefono_proveedor.value.length==0) 
                  {  //comprueba que no esté vacío
                    formulario.telefono_proveedor.focus();
                    alert('No has escrito el telefono_proveedor');
                    return false;
                  } 
                return true;
             }
            
        </script>
        <%
            Facade f=new Facade();
            boolean siP=false;
            
        %>
        
    </head>
    <body>
        
        
        <form name="RegProveedor" id="RegProv" action="FibalizarRegistroProveedor.jsp" method="post" onsubmit="return validarDatos();">
                    <fieldset>
                        <legend>Informacio Proveedor</legend>
                        <center>
                            <label>Id_Proveedor: </label>
                            <input type="text" name="id_proveedor" id="proveedor_id" value="">
                            <label>Nombre_Proveedor: </label>
                            <input type="text" name="nombre_proveedor" id="proveedor_nombre" value="">
                            <label>Nit_Proveedor: </label>
                            <input type="text" name="nit_proveedor" id="proveedor_nit" value="">
                            <label>Direccion_Proveedor: </label>
                            <input type="text" name="direccion_proveedor" id="proveedor_direccion" value="">
                            <label>Telefono_Proveedor: </label>
                            <input type="text" name="telefono_proveedor" id="proveedor_telefono" value="">
                            <br>
                            <input type="submit" value="Registrar" name="Sumbit" onclick="validarDatos()">
                            <input type="button" value="Limpiar" name="Limpiar" onclick="limpiarDatos()">
                        </center>
                    </fieldset>
                    
                </form>
                <hr>
                <center>
                        <destacar><a href="../jsp/PrincipalPlayShots.jsp">Volver a la Página Inicial</a></destacar>
                </center>
           
                
           
        </div>
    </body>
</html>
