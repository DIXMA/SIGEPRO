/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.util.ArrayList;
import util.*;

/**
 *
 * @author CORTEX
 */
public class Compra_DAO {
    
/**
 * Metodo que realiza el registro en el sistema de una nueva compra a proveedor
 * @param valorTot valor total de la compra
 * @param idProv id del proeedor al q se le hizo la compra
 * @return 
 * @throws Exception 
 */
 public boolean registrarCompra(String valorTot, String idProv)throws Exception
 {
    BaseDeDatos.getInstance().conectar();
    String nitProv=(new Proveedor_DAO().nitProveedor(idProv).getNit_Proveedor());
    String sql="INSERT INTO compra VALUES (?,?,?,?)";
    String param[]=new String[4];
    param[0]="CP"+this.consecuitovoIDcompra();
    param[1]=valorTot;
    param[2]=idProv;
    param[3]=nitProv;
    return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql,param));
 }
    
 /**
  * Metodo que permite obtener el consecutivo del ide la compra
  * @return numero consecutivo del ide de la compra
  * @throws Exception 
  */
 private int consecuitovoIDcompra()throws Exception
 {
        String sql="SELECT COUNT(id_compra) FROM compra";
        ArrayList<String> x=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        String w[]=x.get(0).split("-");
        return (Integer.parseInt(w[0]));
 }
 
 /**
     * Metodo que permite obtener el id de la ultima compra registrada en el sistema
     * @return id de la ultima compra registrada en el sistema
     * @throws Exception 
     */
    public String obtenerIdUltimaCompra() throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT id_compra FROM compra order by id_compra DESC limit 1";
        ArrayList<String> v=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        String vent[]=v.get(0).split("-");
        return vent[0];
    }
 
 
    /**
     * Metodo q retora las compras q se deben
     * @return array con las compras q se deben
     * @throws Exception 
     */
    public ArrayList<Compra_DTO> getIfoCompraDebe()throws Exception
    {
        ArrayList<Compra_DTO> compras=new ArrayList<Compra_DTO>();
        String sql="SELECT id_compra,valor_compra,id_proveedor FROM compra WHERE estado=?";
        String param[]=new String[1];
        param[0]="D";
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {
            for(int i=0;i<consulta.size();i++)
            {
                Proveedor_DTO pro=new Proveedor_DTO();
                Compra_DTO com=new Compra_DTO();
                String dto[]=consulta.get(i).split("-");
                com.setId_Compra(dto[0]);
                com.setCosto_Compra(Float.parseFloat(dto[1]));
                pro.setId_Proveedor(dto[2]);
                com.setProveedor_Compra(pro);
                compras.add(com);
            }
        }
        return compras;
    }
    
    /**
     * Metodo q permite actualizar el estado de una compra de 'D' a 'P' de deuda a paga
     * @param idComp id de la compra se va axtualizar
     * @return true=si lo logro o false=si no lo logro
     * @throws Exception 
     */
    public boolean cambiarEstadoPagoDeuda(String idComp)throws Exception
    {
        String sql="UPDATE compra SET estado=? WHERE id_compra=?";
        String param[]=new String[2];
        param[0]="P";
        param[1]=idComp;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
}
