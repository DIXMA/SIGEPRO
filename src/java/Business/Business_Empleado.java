/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.*;
import DTO.*;
import java.util.ArrayList;
/**
 *
 * @author CORTEX
 */
public class Business_Empleado {
    
    /**
     * Metodo que permite verificar el id ingreso pertenece a un mesero en el sistema
     * @return ArrayList String con los id's de los meseros regstrados en sistema
     * @throws Exception 
     */
    public ArrayList<String> verificarMesero()throws Exception
    {
        ArrayList<String> ret=new ArrayList<String>();
        ArrayList<Empleado_DTO> p= (new Empleado_DAO().verificarMeseroVenta());
        if(p.size()>1)
        {
            for(Empleado_DTO x:p)
            {
                ret.add(x.getId_Nombre_Empleado());
                System.out.println(x.getId_Nombre_Empleado());
            }
            if(ret.size()>0)
            {
                return ret;
            }
        }
        return null;
    }
    
    
}
