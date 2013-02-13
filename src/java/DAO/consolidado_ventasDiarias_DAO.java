/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import util.BaseDeDatos;

/**
 *
 * @author CORTEX
 */
public class consolidado_ventasDiarias_DAO {
    
    /**
     * Metodo que permite agregar apertura de caja al sistema
     * @param cant cantidad de dinero con que se inicia el dia de labor
     * @param fech fecha actual
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean adicionarAperturaCaja(String cant,String fech)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        int num=this.consecutivoId();
        String sql="INSERT INTO \"consolidado_ventasDiarias\" (id_apertura,fecha,cantidad_inicio) VALUES (?,?,?)";
        String param[]=new String[3];
        param[0]="AP_"+num;
        param[1]=fech;
        param[2]=cant;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    /**
     * Metodo que permite obtener el id consecutivo en la apertura o cierre de caja
     * @return numero consecutivo para el id
     * @throws Exception 
     */
    private int consecutivoId()throws Exception
    {
        String sql="SELECT COUNT(id_apertura) FROM \"consolidado_ventasDiarias\"";
        ArrayList<String> x=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        if(x.size()>0)
        {
            String w[]=x.get(0).split("-");
            return (Integer.parseInt(w[0]));
        }else 
         {
             return 0;
         }
    }
    
    /**
     * Metodo que permite verificar si hay una apertura no cerrada para poder Vender
     * @return String que si es null ha oportunidad de realizar venta si es null lo contrari
     * @throws Exception 
     */
    public String verSiHayAperturaCaja()throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String ultimId=this.obtenerIdUltimoRegistro();
        String sql="SELECT id_cierre FROM \"consolidado_ventasDiarias\" WHERE id_apertura=?";
        String param[]=new String[1];
        param[0]=ultimId;
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {
            
            String dto[]=consulta.get(0).split("-");
            System.err.println("!!!!!!!!!!!!Aqui encuentra cierre->"+dto[0]);
            String ver=dto[0];
            System.err.println("!!!!!!!!!!!!Aqui encuentra VARIABLEcierre->"+ver);
            if(ver.equalsIgnoreCase("null"))
            {
                System.err.println("!!!!!!!!!!!!Aqui encuentra cierre  NULLLLL");
                return "algo";
            }
            
        }
        System.err.println("!!!!!!!!!!!!Aqui  NOOOO encuentra cierre");
        return null;
    }
    
    /**
     * Metodo que retorna el id de la ultima apertura de caja registrada
     * @return id de la apertura de caja
     * @throws Exception 
     */
    public String obtenerIdUltimoRegistro()throws Exception
    {
        String sql="SELECT id_apertura FROM \"consolidado_ventasDiarias\" order by id_apertura DESC limit 1";
        ArrayList<String> v=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        String vent[]=v.get(0).split("-");
        return vent[0];
    }
    
    /**
     * Metodo que permite actualizr el valor del consolidado cada vez que se hace una venta
     * @param idCons id de la apertura de caja
     * @param ret valor a actualizar
     * @return
     * @throws Exception 
     */
    public boolean actualizarValorVentasConsolidado(String idCons, String ret)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE \"consolidado_ventasDiarias\" SET \"total_Ganancia\"=? WHERE id_apertura=?";
        String param[]=new String[2];
        param[0]=this.obtenerValor(idCons, ret);
        param[1]=idCons;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    /**
     * Metodo que permite obtener el valor que se debe actualizar en la bd
     * como nuevo consolidado
     * @param idCons id de la apertura de caja
     * @param ret valor de la ultima venta registrada
     * @return valor que se debe eactualizar en la BD
     * @throws Exception 
     */
    private String obtenerValor(String idCons,String ret)throws Exception
    {
        int valCon=this.verValorConsolidado(idCons);
        int nuevo=Integer.parseInt(ret);
        int tot=valCon+nuevo;
        return (String.valueOf(tot));
    }
    
    /**
     * Metodo que permite obtener el valor actual del consolidado de ventas
     * @param idCon id de la apertura de caja
     * @return valor actual conslidado de ventas
     * @throws Exception 
     */
    private int verValorConsolidado(String idCon)throws Exception
    {
        int ret=0;
        String sql="SELECT \"total_Ganancia\" FROM \"consolidado_ventasDiarias\" WHERE id_apertura=?";
        String param[]=new String[1];
        param[0]=idCon;
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {
            String dto[]=consulta.get(0).split("-");
            if(!dto[0].equalsIgnoreCase("null"))
            {
                ret=Integer.parseInt(dto[0]);
            }
        }
        return ret;
    }
    
    /**
     * Meodo que permite registrar el cierre de caja
     * @return el valor consolidado que queda como ganancia
     * @throws Exception 
     */
    public String registrarCierreDeCaja()throws Exception
    {
        String idAp=this.obtenerIdUltimoRegistro();
        String idCie="CC_"+this.obtenerIdUltimoCierre();
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE \"consolidado_ventasDiarias\" SET \"id_cierre\"=? WHERE id_apertura=?";
        String param[]=new String[2];
        param[0]=idCie;
        param[1]=idAp;
        boolean x=BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
        if(x)
        {
            return this.verValorConsolidado(idAp)+"&"+this.getValorInicioApertura();
        }
        return null;
    }
    
     /**
     * Metodo que retorna el id del ultimo cierre de caja registrada
     * @return id del ultimo de caja
     * @throws Exception 
     */
    public String obtenerIdUltimoCierre()throws Exception
    {
        String sql="SELECT id_cierre FROM \"consolidado_ventasDiarias\" order by id_apertura DESC limit 1";
        ArrayList<String> v=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        String vent[]=v.get(0).split("-");
        return vent[0];
    }
    
    /**
     * Metodo que permite obtener el valor inicial de la apertura de caja
     * @return valor con el q se realizo la apertura de caja
     * @throws Exception 
     */
    private String getValorInicioApertura()throws Exception
    {
        String idAp=this.obtenerIdUltimoRegistro();
        String sql="SELECT \"cantidad_inicio\" FROM \"consolidado_ventasDiarias\" WHERE id_apertura=?";
        String param[]=new String[1];
        param[0]=idAp;
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {
            String dto[]=consulta.get(0).split("-");
            return dto[0];
        }
        return null;
    }
    
   /**
     * Metodo que permite actualizr el valor del consolidado cada vez que se hace paho a proveedor
     * @param idCons id de la apertura de caja
     * @param ret valor a actualizar
     * @return
     * @throws Exception 
     */
    public boolean actualizarValorPagoDeuConsolidado(String idCons, String ret)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE \"consolidado_ventasDiarias\" SET \"total_Ganancia\"=? WHERE id_apertura=?";
        String param[]=new String[2];
        param[0]=this.obtenerValorPagar(idCons, ret);
        param[1]=idCons;
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    /**
     * Metodo que permite obtener el valor que se debe actualizar en la bd
     * como nuevo consolidado por pago proveedor
     * @param idCons id de la apertura de caja
     * @param ret valor de la ultima venta registrada
     * @return valor que se debe eactualizar en la BD
     * @throws Exception 
     */
    private String obtenerValorPagar(String idCons,String ret)throws Exception
    {
        int valCon=this.verValorConsolidado(idCons);
        int nuevo=(int)Float.parseFloat(ret);
        int tot=valCon-nuevo;
        return (String.valueOf(tot));
    }
    
}
