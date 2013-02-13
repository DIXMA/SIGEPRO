/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.*;
import DTO.*;
/**
 *
 * @author CORTEX
 */
public class Business_ConsolidadoVentasDia {
    
    /**
     * Metodo que permite llamar a la adicion de una apertura de caja
     * @param cant canridad de dinero con la que se inicia el dia
     * @param fech fecha actual
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean añadirAperturaCaja(String cant,String fech)throws Exception
    {
        return (new consolidado_ventasDiarias_DAO().adicionarAperturaCaja(cant, fech));
    }
 
    /**
     * Metodo que permite llamar la verificacion si hay o no caja abierta para 
     * registrar venta
     * @return true= si no se puede realizar venta o false= si se puede realizar la venta
     * @throws Exception 
     */
    public boolean verificarAperturaCaja()throws Exception
    {
        String ret=(new consolidado_ventasDiarias_DAO().verSiHayAperturaCaja());
        if(ret!=null)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Metodo que permite obtener el id de la ultima apertura de caja registrada que no se ha cerrado
     * @return id de la apertura de caja
     * @throws Exception 
     */
    public String getIdAperturaUltim()throws Exception
    {
        return (new consolidado_ventasDiarias_DAO().obtenerIdUltimoRegistro());
    }
    
    
    /**
     * Metodo que permite llamar a actualizar el valor del total de las ventas consolidadas
     * @param idCon id de la apertura de caja
     * @param ret valor que se debe adcionar para actualizar la BD el consolidado de ventas
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean actualizarTotalVentasRegistradas(String idCon,String ret)throws Exception
    {
       return (new consolidado_ventasDiarias_DAO().actualizarValorVentasConsolidado(idCon, ret));
    }
    
    /**
     * Metodo que realiza el cierre de caja
     * @return concatenado el valor consolidado Ventas y valor inicial en caja
     * @throws Exception 
     */
    public String realizarCierreDeCaja()throws Exception
    {
        return (new consolidado_ventasDiarias_DAO().registrarCierreDeCaja());
    }
    
    /**
     * Metodo que permite llamar a actualizar el valor del total de las ventas consolidadas por pago a proveedor
     * @param idCon id de la apertura de caja
     * @param ret valor que se debe adcionar para actualizar la BD el consolidado de ventas
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean actualizarPagoProveedor(String idCon,String ret)throws Exception
    {
       return (new consolidado_ventasDiarias_DAO().actualizarValorPagoDeuConsolidado(idCon, ret));
    }
    
    
}
