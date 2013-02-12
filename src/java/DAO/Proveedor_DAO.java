/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Proveedor_DTO;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CORTEX
 */
public class Proveedor_DAO {
    
    /**
     * Metodo que realiza la consulta de los proveedores existentes en la BD 
     * y los concatena en proveedores DTO
     * @return Array con proveedoresDTO solo con su nombre o null si no encuentra registro...
     */
    public ArrayList<Proveedor_DTO> getProveedoresNombre()throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT id_proveedor,nombre_proveedor FROM proveedor";
        ArrayList<String> datos=BaseDeDatos.getInstance().getConsultaSQL(sql,null);
        ArrayList<Proveedor_DTO> proveedor=new ArrayList<Proveedor_DTO>();
        if(datos.size()>0)
        {
            for(int i=0;i<datos.size();i++)
            {
                String d[]=datos.get(i).split("-");
                Proveedor_DTO prove=new Proveedor_DTO();
                prove.setId_Proveedor(d[0]);
                prove.setNombre_Persona(d[1]);                
                proveedor.add(prove);
            }
            if(proveedor.size()>0)
            {
                return proveedor;
            }
        }
        return null;
    }
    
    /**
     * Metodo que devuelve el nit de un provededor
     * @param idP id del proveedor que necesita el nit
     * @return nit del proveedor
     * @throws Exception 
     */
    public Proveedor_DTO nitProveedor(String idP)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT nit FROM proveedor WHERE id_proveedor=?";
        String param[]=new String[1];
        param[0]=idP;
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {
            String datos[]=consulta.get(0).split("-");
            Proveedor_DTO pro=new Proveedor_DTO();
            String d=datos[0];
            String s=datos[1];
            String t=d+"-"+s;
            pro.setId_Proveedor(t);
            return pro;
        }
        return null;
    }
    
    /**
     * Metodo que permite adicionar la indormacion de un nuevo proveedor a la BD
     * @param idP id del  nuevo proveedor
     * @param nomP nombre del nuevo proveedor
     * @param nitP nit del nuevo proveedor
     * @param dirP direccion del nuevo proveedor
     * @param telP teledono del nuevo proveedor
     * @return true= si lo logra o false si no lo logra
     * @throws Exception 
     */
    public boolean registrarNuevoProveedor(String idP,String nomP,String nitP,String dirP,String telP)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="INSERT INTO proveedor VALUES (?,?,?,?,?)";
        String param[]=new String[5];
        param[0]=idP;
        param[1]=nomP;
        param[2]=nitP;
        param[3]=dirP;
        param[4]=telP;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }        
    
}
