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
    
    
    
}
