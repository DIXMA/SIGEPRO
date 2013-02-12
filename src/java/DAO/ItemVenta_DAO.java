/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.*;
import util.BaseDeDatos;
/**
 *
 * @author CORTEX
 */
public class ItemVenta_DAO 
{
    /**
     * Metodo que realiza la incercion de un itemVenta
     * @param id_Producto el id del producto 
     * @param idVenta el id de la venta que fue agregado
     * @param fecha la fecha en que se realiza la venta
     * @param idRec el id de la receta del prosucto que se vendio
     * @param cantidad la cantidad del producto que se vendio
     * @return true si realiza la incercion o false si no lo realiza
     * @throws Exception 
     */
    public boolean insertarItemVenta(String id_Producto, String idVenta, String fecha,String idRec, String cantidad)throws Exception
    {
        String insert="INSERT INTO item_venta VALUES (?,?,?,?,?)";//declaro la insercion parametrizada para el nuevo itemVenta en la BD
        String param[]=new String[5];
        param[0]=id_Producto;
        param[1]=idVenta;
        param[2]=fecha;
        param[3]=idRec;
        param[4]=cantidad;
        return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(insert, param));
    }
    
    
    
}
