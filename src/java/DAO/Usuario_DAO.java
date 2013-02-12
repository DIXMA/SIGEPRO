/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import util.BaseDeDatos;
/**
 *
 * @author CORTEX
 */
public class Usuario_DAO {
    private String usuario;
    private String contrasena;
    private String rol;
    



   
    
      public String validarUser()throws Exception
      {
            if ((verificau(usuario,contrasena)==true))
            {
                return "-1";
            }
      return "1";
      }
      
      public boolean verificau(String us,String key)throws Exception
      {
          BaseDeDatos.getInstance().conectar();
          //String sql="SELECT nombre_usuario,pass_usuario,rol_usuario From usuario where nombre_usuario='"+us.toString()+"' AND pass_usuario='"+key.toString()+"'";
          String sql = "SELECT nombre_usuario,pass_usuario,rol_usuario FROM usuario WHERE nombre_usuario=? AND pass_usuario=?";
          Object[] param = new Object[2];
          param[0]=us;
          param[1]=key;
          ArrayList<String> usu =BaseDeDatos.getInstance().getConsultaSQL(sql, param);
          System.out.println("aqui valida la consulta usuario..."+usu.size());
          
          
                    if (usu.size() > 0)
                    {
                        String datos[]=usu.get(0).toString().split("-");
                        System.out.println("aqui valida la consulta usuario...PASO----"+datos.length);
                        this.setRol(datos[2]);
                        return true;
                    }
          System.out.println("aqui valida la consulta usuario...no paso");
          return false;
       }
      
       
      
        public String getUsuario()
        {
        return usuario;
        }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }


    public String getContrasena() 
    {
        return contrasena;
    }

    public void setContrasena(String contrasena) 
    {
        this.contrasena = contrasena;
    }

    public String getRol() 
    {
        return rol;
    }

    public void setRol(String rol) 
    {
        this.rol = rol;
    }
    
    
}

