/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.Proveedor_DAO;
import DTO.Proveedor_DTO;
import java.util.ArrayList;

/**
 *
 * @author CORTEX
 */
public class Business_Proveedor {
    
    /**
     * Metodo que concatena los nombres de los proveedores del sistema en un array
     * @return Array con los nombres de los proveedores escritos en el sistema o null sino encuentra ecistencia...
     */
    public ArrayList<String> getNombresProveedor()throws Exception
    {
        ArrayList<Proveedor_DTO> proveedor=new Proveedor_DAO().getProveedoresNombre();
        ArrayList<String> concatenado=new ArrayList<String>();
        if(proveedor.size()>0)
        {
            for(Proveedor_DTO px:proveedor)
            {
                concatenado.add(px.getNombre_IDproveedor());
            }
            
            if(concatenado.size()>0)
            {
                return concatenado;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite invocar la adicion de un nuevo proveedor a la BD
     * @param idP id del proveedor
     * @param nomP nombre del proveedor
     * @param nitP nit del proveedor
     * @param dirP direccin del proveedor
     * @param telP telefono del proveedor
     * @return true=si lo logra i false = si no logra
     * @throws Exception 
     */
    public boolean añadirProveedor(String idP,String nomP,String nitP,String dirP,String telP)throws Exception
    {
        return (new Proveedor_DAO().registrarNuevoProveedor(idP, nomP, nitP, dirP, telP));
    }
    
}
