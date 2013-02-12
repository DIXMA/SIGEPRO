<%-- 
    Document   : inicioSecion
    Created on : 3/02/2013, 10:50:41 AM
    Author     : CORTEX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validar Datos</title>
        <style type="text/css">              
            <%@include file = "../css/estio.css"%> 
        </style>
    </head>
    <body id="bodyPricipal">
        <div id="contenedorVaildarUser">
            <div id="CabeceraVaildarUser">                
            </div>
            <div id="contenidoIiSecion">
                <h2><center><label>Validacion de Usuario</label></center></h2>
                 <%
                            DAO.Usuario_DAO p= new DAO.Usuario_DAO();
                            String user=request.getParameter("nick");
                            p.setUsuario(user);
                            p.setContrasena(request.getParameter("password"));
                            String res=p.validarUser();
                                if(res.equals("-1")) {
                                    out.print("<label>entraste clic aqui para entrar</label>");
                %>
                                    <a href="../jsp/PrincipalPlayShots.jsp"><h1>Entrar ya</h1></a>
                                                                        
                <%             HttpSession sesionOk = request.getSession();
                               sesionOk.setAttribute("rol",p.getRol());
                               
                                }

                               else if (res.equals("1")){
                                       out.print("<label>fallo la autentificacion</label> ");
                %>
                                       <a href="../index.jsp"><h1>Regresar</h1></a>
                <%             }
                                    else{
                                        out.print("algo pasa ");
                                    }

                 %>
            </div>
            
                     
            <div id="PieVaildarUser">
           <center><label>Copyright &copy; 2013 grupo Analisis y Diseño de Sistemas ufps IIsem 2012</label></center>  
            
            </div>
        </div>
    </body>
</html>
