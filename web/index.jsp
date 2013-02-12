<%-- 
    Document   : index
    Created on : 15-ene-2013, 17:24:51
    Author     : JAVIER NUMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<head>
<title>Ingreso de Cuenta</title>
<link rel="stylesheet" href="css/login.css" />	
<!--script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script-->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>  
</head>

<body>
    
    <!--div id="popup" style="display: none;"-->
    <div class="content-popup">
        <div class="close"><a href="#" id="close"><!--img src="images/close.png"/--></a></div>
        <div>
            <div class="main">
		<div class="box">
			<h2>Inicio de Sesion</h2>
			<!--h3><a href="./register.php">Regístrate</a> o ingresa tu usuario y contrase&ntilde;a</h3-->
			
                        <form class="form" name="fvalida" action="./jsp/inicioSecion.jsp" method="post">
				<fieldset>
					<div class="row">
						<input type="text" class="login" name="nick" placeholder="Usuario" />
					</div>
					<div class="row">
						<input type="password" class="password" name="password" placeholder="Password"/>
						<a class="forgot" href="#">Olvide mi password</a>
					</div>	
					<div class="row">
			<!--input type="checkbox" class="remember" name="remember" id="remember"  />
						<label for="remember">Mantenerme logeado</label-->
                            <input type="submit" value="Ingresar" name="Ingresar" onclick="valida_envia()"/>
					</div>
				</fieldset>
			</form>	
                       
		</div>
                 
        </div>
            <article>
      <aside id="enlaces">
            

      </aside>
		</article>
    </div>
        
</div>
    <!--/div-->
    
    <!--<a href="#" id="open">click aqui</a>-->
	
		<span class="copy">Copyright &copy; 2013 grupo Analisis y Diseño de Sistemas ufps IIsem 2012</span>	
<script type="text/javascript">
$(document).ready(function(){
  $('#open').click(function(){
        $('#popup').fadeIn('slow');
        $('#content').css('opacity', '0.2');
    });

    $('#close').click(function(){
        $('#popup').fadeOut('slow');
        $('#content').css('opacity', '1');
    });
});
</script>

<script>

  function valida_envia(){


   	if (document.fvalida.nick.value.length==0)
        {
		alert("usuario no puede quedar en blanco")
		document.fvalida.nick.focus()
                document.fvalida.nick.value = ""
		return 0;
	}
        else{ 	if (document.fvalida.password.value.length==0)
                {
		alert("contraseña no puede quedar en blanco")
		document.fvalida.password.focus()
                document.fvalida.password.value = ""
		return 0;
                }
        }

    
    if (document.fvalida.password.value.length>0&&document.fvalida.nick.value.length>0)
    {
        document.form.submit();
    }

}


    </script>
             
   
    

</body>


</html>