<%-- 
    Document   : PagoProveedor
    Created on : 11/02/2013, 01:36:43 AM
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
    </head>
    <body>
        <form action="../jsp/FinalizarPagoProveedor.jsp">
        <center>
                <label>Cuentas por Pagar</label>
                <select name="cmbDeudas" size=1 > 
                    <%
                    Facade p=new Facade();
                    ArrayList<String> deudas=p.cargarCompraDeudas();
                    int a=deudas.size();
                    String cad="";
                    if(a>0)
                    {
                        for(int i=0;i<a;i++)
                         {  String zzz[]=deudas.get(i).split("&");
                             cad="Venta-"+zzz[0]+"-Valor-"+zzz[1]+"-Proveedor-"+zzz[2];  %>
                        <option><%=cad%></option>      
                      <%}
                    }
                    %>
                </select> 
                    <input type="submit" value="Pagar">
                 </center>
        </form>
    </body>
</html>
