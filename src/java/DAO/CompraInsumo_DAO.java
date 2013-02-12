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
public class CompraInsumo_DAO {
    
    /**
     * Metodo que inserta los datos de los insumos comprados
     * @param idInsumo id del insumo a insertar
     * @param idCompra
     * @param fechaCompra
     * @param idProvedo
     * @param cantComp
     * @param contenido
     * @param idInventario
     * @return
     * @throws Exception 
     */
    public boolean insertarInsumoCompra(String idInsumo, String idCompra, String fechaCompra, String idProvedo, String cantComp, String contenido, String idInventario)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="INSERT INTO \"compraInsumo\" VALUES (?,?,?,?,?,?,?)";
        String param[]=new String[7];
        param[0]=idInsumo;
        param[1]=idCompra;
        param[2]=fechaCompra;
        param[3]=idProvedo;
        param[4]=cantComp;
        param[5]=contenido;
        param[6]=idInventario;
        return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param));
    }
    
    /**
     * Metodo que devuelve los insumos comprados al proveedor 
     * @param idCom is de la comrpa realizada
     * @return array con los insumosDTO que se compraron
     * @throws Exception 
     */
    public ArrayList<Insumo_DTO> insumosComprados(String idCom)throws Exception
    {
        ArrayList<Insumo_DTO> insumos=new ArrayList<Insumo_DTO>();
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT id_insumo, cant_compra, contenido FROM \"compraInsumo\" WHERE id_compra=?";
        String param[]=new String[1];
        param[0]=idCom;
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {
            for(int i=0;i<consulta.size();i++){
                Insumo_DTO ins=new Insumo_DTO();
                String datos[]=consulta.get(i).split("-");
                ins.setId_Insumo(datos[0]);
                int ww=(int)Float.parseFloat(datos[1]);
                ins.setUnidades_Insumo(ww);
                ins.setContenido_Insumo(Float.parseFloat(datos[2]));
                insumos.add(ins);
            }
            if(insumos.size()>0)
            {
                return insumos;
            }
        }
        
        return null;
    }
    
}
