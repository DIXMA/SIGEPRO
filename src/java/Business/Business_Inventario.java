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
public class Business_Inventario {
    
    /**
     * Metodo que invoca la actualizacion de la informacion en el inventario por Compra de insumos
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean actualizarInentario()throws Exception
    {
        boolean ret=false;
        String idCompra=(new Compra_DAO().obtenerIdUltimaCompra());
        ArrayList<Insumo_DTO> insumos=(new CompraInsumo_DAO().insumosComprados(idCompra));
        for(int i=0;i<insumos.size();i++)
        {
            Insumo_DTO ins=insumos.get(i);
            ret=(new Inventario_DAO().actualizarInventarioCompra(ins.getId_Insumo(), String.valueOf(ins.getContenido_Insumo())));
        }
        return ret;
    }
    
    /**
     * Metodo que permite obtener los datos necesarios para la actualizacion del 
     * la cantidad de existencias del insumo en el inventario
     * @param insumos array con la informacion de los insumos que se dean
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean setInventarioPosSalidaDia(String []insumos)throws Exception
    {
        boolean ret=false;
        for(int i=0;i<insumos.length;i++)
        {
            String dtoIns[]=insumos[i].split("-");
            Insumo_DTO is=(new Insumo_DAO().getInsumoExisteCantidad(dtoIns[0]));
            float cantidadInsumo=is.getContenido_Insumo();
            float unidadesInsumo=is.getUnidades_Insumo();
            float actualizar=cantidadInsumo*unidadesInsumo;
            System.err.println("!!!!!!!!!!!1Aqui calculo lo dle inventario "+actualizar);
            ret=(new Inventario_DAO().actualizaInventaioProSalidaDIa(dtoIns[0], String.valueOf(actualizar)));
        }
        return ret;
    }
    
    
}
