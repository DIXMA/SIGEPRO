/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import DTO.*;
import DAO.*;
import java.util.ArrayList;

/**
 *
 * @author CORTEX
 */
public class Business_Compra {
    
    /**
     * Metodo que registra la compra a un proveedor
     * @param proveedor id del proveedor que se compor
     * @param total el total de la compra
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean regitrarCompraALProveedor(String proveedor,String total)throws Exception
    {
        return (new Compra_DAO().registrarCompra(total, proveedor));
    }
    
    /**
     * Metodo que concatena la informacion de las compras q no se han cancelado
     * @return array con la informacion de las compras que se deben
     */
    public ArrayList<String> getcompraDebe()throws Exception
    {   
        ArrayList<String> ret=new ArrayList<String>();
        ArrayList<Compra_DTO> comp=(new Compra_DAO().getIfoCompraDebe());
        if(comp.size()>0)
        {
            for(int i=0;i<comp.size();i++)
            {
                ret.add(comp.get(i).getInfoCompraDeuda());
            }
        }
        return ret;
    }
    
    /**
     * Metodo que permite editar la inforacion del estado de la deuda  a paga
     * @param dto array con informacion de la deuda
     * @return true=si lo ogra o false=si no lo logra
     * @throws Exception 
     */
    public boolean pagarDeudaProveedor(String dto[])throws Exception
    {
        return (new Compra_DAO().cambiarEstadoPagoDeuda(dto[0]));
    }
}
