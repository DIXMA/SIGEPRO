/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.SalidaConsumoDia_DAO;

/**
 *
 * @author CORTEX
 */
public class Business_SalidaConsumoDia {
    
    /**
     * Metodo que busca descontar la cantidad de insumos que hay despues de la venta
     * @param fec La fecha actual en la q se realizo la venta
     * @throws Exception 
     */
    public String descontarCantidadPorVenta(String fec)throws Exception
    {
        SalidaConsumoDia_DAO s=new SalidaConsumoDia_DAO();
        return (s.restarVentaConsumoDia(fec));
    }
    
    /**
     * Metodo que invoca el registro una nueva salida de insumos para el consumo en el dia
     * @param idInsumo array con el ide y la cantidad de insumos que se desan para le consumo dia
     * @param fecha fecha de la salida
     * @param hora hora de la salida
     * @return true= si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean registrarNuevaSalidaDia(String idInsumo[],String fecha,String hora)throws Exception
    {
        return (new SalidaConsumoDia_DAO().insertarNuevaSalidaDia(idInsumo, fecha, hora));
    }    
    
}
