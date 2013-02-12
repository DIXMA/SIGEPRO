/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.Compra_DAO;

/**
 *
 * @author CORTEX
 */
public class Business_Compra {
    
    public boolean regitrarCompraALProveedor(String proveedor,String total)throws Exception
    {
        return (new Compra_DAO().registrarCompra(total, proveedor));
    }
    
}
