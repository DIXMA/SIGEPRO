/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Insumo_DTO;
import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CORTEX
 */
public class Inventario_DAO {
    
    /**
     * Metodo que actualiza el valor dela canidad del insumo en el inventario
     * @param idInsum id del insumo par actualizar
     * @param cantActual cantidad que se compro del insumo en onz para sumar al inevntario
     * @return true=si lo logro o false= si no lo logro
     * @throws Exception 
     */
    public boolean actualizarInventarioCompra(String idInsum, String cantActual)throws Exception
    {
        float valorActualInsumo=this.obtenerValorActualInsumoInventario(idInsum);
        float valorAdicionar=Float.parseFloat(cantActual);
        float valorNuevo=valorActualInsumo+valorAdicionar;
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE inventario SET cantidad_total=? WHERE id_insumo=?";
        String param[]=new String[2];
        param[0]=String.valueOf(valorNuevo);
        param[1]=idInsum;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    
   /**
    * Metodo que devuelve el id del inventario de un insumo
    * @param idInsumo id del insumo a consultar el id del inventario
    * @return id del inventario dl insumo 
    * @throws Exception 
    */ 
   public String getIdInventarioDeInsumo(String idInsumo)throws Exception
   {
       BaseDeDatos.getInstance().conectar();
       String sql="SELECT id_inventario FROM inventario WHERE id_insumo=?";
       String param[]=new String[1];
       param[0]=idInsumo;
       ArrayList<String> datos=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
       if(datos.size()>0)
       {
           String z[]=datos.get(0).split("-");
           return z[0];
       }
     return null;        
   }
   
   /**
    * Metodo que devuelve la cantidad existente en onz del insumo en el inventario
    * @param idIns id del insumo para consultar
    * @return cantidad existente del insumo en el inventario
    * @throws Exception 
    */
   private float obtenerValorActualInsumoInventario(String idIns)throws Exception
   {
       BaseDeDatos.getInstance().conectar();
       String sql="SELECT cantidad_total FROM inventario WHERE id_insumo=?";
       float ret=0;
       String param[]=new String[1];
       param[0]=idIns;
       ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
       if(consulta.size()>0)
       {
           String dto[]=consulta.get(0).split("-");
           ret=Float.parseFloat(dto[0]);
           return ret;
       }
       return 0;
   }
   
   /**
    * Metodo que actualiza las existencias de un insumo en la BD por la salida dia
    * @param idInsum id del insumo que se desea actualizar
    * @param nuvaCantid cantidad que se va a actualzar en la BD
    * @return true=si lo logra o false=si no lo logra
    * @throws Exception 
    */
   public boolean actualizaInventaioProSalidaDIa(String idInsum, String nuvaCantid)throws Exception
   {
       BaseDeDatos.getInstance().conectar();
       String sql="UPDATE inventario SET cantidad_total=? WHERE id_insumo=?";
       String param[]=new String[2];
       param[0]=nuvaCantid;
       param[1]=idInsum;
       return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param));
   }
   
   
   
 }
    
    

