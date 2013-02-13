/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import DAO.*;
/**
 *
 * @author CORTEX
 */
public class Business_Venta {
    
    /**
     * Metodo que realiza la insercion de una nueva venta en el sistema
     * @param productos los productos que se vendieron 
     * @param costo el costo de la venta
     * @param fecha la fecha en que se realizo la venta
     * @param idMesero id del mesero quien realizo la venta
     * @return true= si reliza la insercion de la venta exitosamente o False= si no puede insertar la venta
     */
    public boolean realizarLaVenta(String[] productos, String costo, String fecha, String idMesero)throws Exception
    {
         return (new Venta_DAO().crearVenta(idMesero, costo, fecha, productos)); 
    }
    
    /**
     * Metodo que permite obtener el id de la ultima Venta
     * @return id de la ultma venta registrada
     * @throws Exception 
     */
     public String grtIdUltimVentatotal()throws Exception
     {
         return (new Venta_DAO().obtenerIdUltimaVenta());
     }
     
     public int getValorUltimaVenta()throws Exception
     {
         return (new Venta_DAO().valorUltimaVenta());
     }
     
}
