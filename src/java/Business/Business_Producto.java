/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.Producto_DAO;
import DTO.Producto_DTO;
import java.util.ArrayList;

/**
 *
 * @author CORTEX
 */
public class Business_Producto {
    
    public ArrayList<String> getPrecioYnombreProducto(String caracter)
    {
         ArrayList<String> cad=new ArrayList<String>();
         Producto_DAO x=new Producto_DAO();
         try {
             ArrayList<Producto_DTO> p=x.listarNombreyPrecioProductos(caracter);
             for(int i=0;i<p.size();i++)
            {
             cad.add(p.get(i).nombreYprecioProducto());
            }
         }catch(Exception e){
             System.err.println(e.toString());
         }
         
       return cad;  
    }
    
}
