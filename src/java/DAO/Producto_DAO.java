/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.*;
import java.util.ArrayList;
import util.*;
/**
 *
 * @author CORTEX
 */
public class Producto_DAO {
    
    public ArrayList<Producto_DTO> listarNombreyPrecioProductos(String caracter) throws Exception
    {
        ArrayList<Producto_DTO> productos=new ArrayList<Producto_DTO>();
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT id_producto,nombre_producto,precio FROM producto WHERE id_producto LIKE '"+caracter+"%'";
       //String sql = "SELECT nombre_producto,precio FROM producto WHERE id_producto LIKE ?";
         
        ArrayList<String> prod =BaseDeDatos.getInstance().getConsultaSQL(sql,null);
        if(prod.size()>0)
        {
            for(int i=0,j=1;i<prod.size();j++,i++)
            {
               String datos[]=prod.get(i).toString().split("-"); 
               Producto_DTO p=new Producto_DTO();
               p.setId_Produto(datos[0]);
               p.setNombre_Producto(datos[1]);
               p.setPrecio_Producto(Float.parseFloat(datos[2]));
               productos.add(p);
            }
        }
        
        return productos;
    }
    
    /**
     * Metodo que lista todos los productos de la bd
     * @return arra con los productos
     * @throws Exception 
     */
    public ArrayList<Producto_DTO> listarProductos()throws Exception
    {
        ArrayList<Producto_DTO> x=new ArrayList<Producto_DTO>();
        String sql="SELECT * FROM producto";
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        if(consulta.size()>0)
        {
            for(int i=0;i<consulta.size();i++)
            {
                Receta_DTO r=new Receta_DTO();
                Producto_DTO pro=new Producto_DTO();
                String dto[]=consulta.get(i).split("-");
                pro.setId_Produto(dto[0]);
                r.setId_Receta(dto[1]);
                pro.setReceta_Producto(r);
                pro.setTipo_Producto(this.nombreTipPro(dto[2]));;
                pro.setPrecio_Producto(Float.parseFloat(dto[3]));
                pro.setNombre_Producto(dto[4]);
                x.add(pro);
            }
        }
        return x;
    }
    
    
   private String nombreTipPro(String num)
   {
       if(num.equals("1"))
       {
           return "Coctel";
       }
       
       if(num.equals("2"))
       {
           return "Shot";
       }
       
       if(num.equals("3"))
       {
           return "Adicional";
       }
       
       return null;
   }
}
