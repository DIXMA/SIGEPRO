/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CORTEX
 */
public class Empleado_DAO {
    
    /**
     * Metedo que devuelve los meseros registrados en el sistema
     * @return Array con los meseros que hay en el sistema
     * @throws Exception 
     */
    public ArrayList<Empleado_DTO> verificarMeseroVenta()throws Exception
    {
        ArrayList<Empleado_DTO> ret=new ArrayList<Empleado_DTO>();
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT id_empleado, nombre_empleado FROM empleado WHERE cargo_empleado=?";
        String param[]=new String[1];
        param[0]="mesero";
        ArrayList<String> dat=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(dat.size()>1)
        {
            for(int i=0;i<dat.size();i++)
            {
                Empleado_DTO mesero=new Empleado_DTO();
                String z[]=dat.get(i).split("-");
                mesero.setId(z[0]);
                mesero.setNombre_Persona(z[1]);
                ret.add(mesero);
                System.err.println("Va cargando"+mesero.getId_Nombre_Empleado());
            }
            if(ret.size()>0)
            {
                return ret;
            }
        }       
        return null;
    }
    
   
    
}
