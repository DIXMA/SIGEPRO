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
public class Business_Insumo {
    
    /**
     * Metodo que devuelve en un array concatenado el id y el nombre de c/u de los insumos existentes en el sistema
     * @return Array con el id y el nombre de los insumos existentes en el sistema
     * @throws Exception 
     */
    public ArrayList<String> getId_NombreInsumos()throws Exception
    {
        ArrayList<String> ret=new ArrayList<String>();
        ArrayList<Insumo_DTO> insumo=(new Insumo_DAO().returnInsumos_IsNomb());
        if(insumo.size()>0)
        {
            for(int i=0;i<insumo.size();i++)
            {
                ret.add(insumo.get(i).getIdNombreInsumo());
            }
            if(ret.size()>0)
            { 
                return ret;
            }
        }
        return null;
    }
    
    /**
     * Metodo que remite a la actualizacion de las unidades de los insumos comprados
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean actualizaUnidadesInsumoPorCompra()throws Exception
    {
        boolean ret=false;
        String idCompra=(new Compra_DAO().obtenerIdUltimaCompra());
        ArrayList<Insumo_DTO> insumos=(new CompraInsumo_DAO().insumosComprados(idCompra));
        if(insumos.size()>0)
        {
            for(int i=0;i<insumos.size();i++)
            {
                Insumo_DTO ins=insumos.get(i);
                ret=(new Insumo_DAO().actualizarUnidadesPorCompra(ins.getId_Insumo(), ins.getUnidades_Insumo()));
            }
        }
        return ret;
    }
    
    /**
     * Metodo que permite concatenar la informacion de los indumos en stok minimo
     * @return Array con los datos de los insumos en stok minimo
     * @throws Exception 
     */
    public ArrayList<String> listarInsumoStokMinimo()throws Exception
    {
        ArrayList<String> datos=new ArrayList<String>();
        ArrayList<Insumo_DTO> ins=(new Insumo_DAO().getListarInsumoStockMinimo());
        if(ins.size()>0)
        {
            for(int i=0;i<ins.size();i++)
            {
                Insumo_DTO insumo=ins.get(i);
                String añadir=insumo.getId_Insumo()+"/"+insumo.getNombre_Insumo()+"/"+insumo.getContenido_Insumo()+"/"+insumo.getUnidades_Insumo();
                System.out.print(añadir);
                datos.add(añadir);
            }
        }
        return datos;
    }

     /**
     * Metodo que remite a la actualizacion de las unidades de los insumos sacados para consumo dia
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean actualizaUnidadesInsumoPorSalidaDia(String []insumos)throws Exception
    {
        boolean ret=false;
        for(int i=0;i<insumos.length;i++)
        {
            String dto[]=insumos[i].split("-");
            ret=(new Insumo_DAO().actualizarUnidadesPorSalidaDia(dto[0], Float.parseFloat(dto[1])));
        }
        return ret;
    }
    
}
