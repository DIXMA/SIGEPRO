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
public class Insumo_DAO {
    
    /**
     * Metodo que consulta el id y el nombre de los insumos existentes en el sistema y los devuelve en un array
     * @return Array de insumoDTO sol con id y nombre
     * @throws Exception 
     */
    public ArrayList<Insumo_DTO> returnInsumos_IsNomb()throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        ArrayList<Insumo_DTO> insumos=new ArrayList<Insumo_DTO>();
        String sql="SELECT id_insumo, nombre_insumo FROM insumo WHERE estado=?";
        String param[]=new String[1];
        param[0]="A";
        ArrayList<String> datos=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(datos.size()>0)
        {
            for(int i=0;i<datos.size();i++)
            {
                Insumo_DTO insu=new Insumo_DTO();
                String dto[]=datos.get(i).split("-");
                insu.setId_Insumo(dto[0]);
                insu.setNombre_Insumo(dto[1]);
                insumos.add(insu);
            }
            if(insumos.size()>0)
            { 
                return insumos;
            }
        }
        return null;
    }
    
    /**
     * Metodo que devuelve un insumo dependiendo su id con info el contedo y las uidades de c/u
     * @param id el id del insumo que se necesita
     * @return Onjeto insumo solo con el contenido en las unidades
     * @throws Exception 
     */ 
    public Insumo_DTO getInsumoExisteCantidad(String id) throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT contenido,unidades FROM insumo WHERE id_insumo=?";
        String param[]=new String[1];
        param[0]=id;
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {   Insumo_DTO ret=new Insumo_DTO();
            for(int i=0;i<consulta.size();i++)
            {   
                String aa[]=consulta.get(i).split("-");
                ret.setContenido_Insumo(Float.parseFloat(aa[0]));
                System.err.println("aqui va actualizando valor del contenido="+aa[0]);
                ret.setUnidades_Insumo(Float.parseFloat(aa[1]));
            }
            return ret;
        }
        return null;
    }
    
    
    /**
     * Metodo que permite conocer los insumos utilizados en la venta
     * @param fcha fecha en que se realiza la venta
     * @param idVentaRec id de la venta
     * @return
     * @throws Exception 
     */
    public ArrayList<Insumo_DTO> insumosConsumidosEnVenta(String fcha, String idVentaRec)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT receta_producto.id_insumo1 AS receta_producto_id_insumo1,receta_producto.cantidad_insumo1 AS receta_producto_cantidad_insumo1,venta.id_venta AS venta_id_venta,item_venta.id_receta AS item_venta_id_receta,item_venta.id_venta AS item_venta_id_venta,item_venta.fecha_venta AS item_venta_fecha_venta,item_venta.cantidad AS item_venta_cantidad FROM public.venta venta INNER JOIN public.item_venta item_venta ON venta.id_venta = item_venta.id_venta INNER JOIN public.receta_producto receta_producto ON item_venta.id_receta = receta_producto.id_receta";
        ArrayList<String> p=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        System.err.println("cantconsultagrandota-"+p.size());
        ArrayList<Insumo_DTO> dto=new ArrayList<Insumo_DTO>();
        for(int i=0;i<p.size();i++)
        {
            Insumo_DTO j=new Insumo_DTO();
            String x[]=p.get(i).split("-");
            String idInsumo=x[0];
            String cantEnRecetaInsumo=x[1];
            String idVenta=x[2];
            String idReceta=x[3];
            String cantidadVendido=x[6];
            String fechaVenta=x[5];
            //System.err.println("compara fechas ->"+"fechaQuellega-"+fcha+" con fecha que traigoConsultas"+fechaVenta);
            //System.err.println("compara idVenta->"+"idVentaqueConsulto-"+idVenta+" con IdVentaquellega "+idVentaRec);
            if(fcha.equals(fechaVenta)&&idVenta.equals(idVentaRec))
            {
                //System.out.println("idInsumo=x[0] "+x[0]+" cantEnRecetaInsumo=x[1] "+x[1]+" idVenta=x[2]"+x[2]+" idReceta=x[3]"+x[3]+" cantidadVendido=x[6] "+x[6]+" fechaVenta=x[5]"+x[5]);
                j.setId_Insumo(idInsumo);
                float cant=Float.parseFloat(cantEnRecetaInsumo)*Float.parseFloat(cantidadVendido);
                j.setContenido_Insumo(cant);
                //System.out.println("Antes de agregar j="+j.getId_Insumo()+j.getContenido_Insumo());
                dto.add(j);
            }
            
        }
        
        return dto;
    }
    
    /**
     * Metodo que realiza la actualizacon de las unidades del insumo por compra
     * @param idInd 
     * @param adcionar
     * @return true=si lo logra o fasle=si no lo logra
     * @throws Exception
     */ 
    public boolean actualizarUnidadesPorCompra(String idInd, float adcionar)throws Exception
    {
        float valorAhora=this.obtenerUnidadActual(idInd);
        float actualizar=valorAhora+adcionar;
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE insumo SET unidades=? WHERE id_insumo=?";
        String param[]=new String[2];
        param[0]=String.valueOf(actualizar);
        param[1]=idInd;
        return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param));
    }
    
    /**
     * Metodo que devuelve el valor actual de las unidades del insumo en el sistema
     * @param id ide del insuomo a consultar
     * @return unidades existentes del insumo
     * @throws Exception 
     */
    private float obtenerUnidadActual(String id)throws Exception
    {
        float ret=0;
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT unidades FROM insumo WHERE id_insumo=?";
        String param[]=new String[1];
        param[0]=id;
        ArrayList<String> consulta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)
        {
            String dto[]=consulta.get(0).split("-");
            ret=Float.parseFloat(dto[0]);
        }
        
        return ret;
    }
    
    /**
     * Metodo que permite obtener la informacion de los insumos que estan en stock minimo
     * @return Array Insumo_DTO con la informacion de los insumos en stok minimo
     * @throws Exception 
     */
    public ArrayList<Insumo_DTO> getListarInsumoStockMinimo()throws Exception
    {
        ArrayList<Insumo_DTO> ww=new ArrayList<Insumo_DTO>();
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT * FROM insumo WHERE unidades=? OR unidades=?";
        String []param=new String[2];
        param[0]=String.valueOf(1);
        param[1]=String.valueOf(0);
        ArrayList<String> consulta = BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        if(consulta.size()>0)  
        {
            for(int i=0; i<consulta.size(); i++)
            {
                Insumo_DTO ins=new Insumo_DTO();
                String dto[]=consulta.get(i).split("-");
                ins.setId_Insumo(dto[0]);
                ins.setNombre_Insumo(dto[1]);
                ins.setContenido_Insumo(Float.parseFloat(dto[2]));
                ins.setUnidades_Insumo(Float.parseFloat(dto[3]));                
                ww.add(ins);
            }
        }
        
        return ww;
    }
    
    /**
     * Metodo que realiza la actualizacon de las unidades del insumo por salida consumo Dia
     * @param idInd 
     * @param adcionar
     * @return true=si lo logra o fasle=si no lo logra
     * @throws Exception
     */ 
    public boolean actualizarUnidadesPorSalidaDia(String idInd, float adcionar)throws Exception
    {
        float valorAhora=this.obtenerUnidadActual(idInd);
        float actualizar=valorAhora-adcionar;
        if(actualizar<1)
        {
            return false;
        }
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE insumo SET unidades=? WHERE id_insumo=?";
        String param[]=new String[2];
        param[0]=String.valueOf(actualizar);
        param[1]=idInd;
        return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param));
    }
   
   /**
    * Metodo que permite actualizar el estado del insumo de activado 'A' a desactivado 'D'
    * para dar baja al insumo
    * @param idinsumo id del insumo que se desea desactivar
    * @return true=si lo logra o false=si no lo logra
    * @throws Exception 
    */
    public boolean actualizarEstadoInsumoDarBaja(String idinsumo)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE insumo SET estado=? WHERE id_insumo=?";
        String param[]=new String[1];
        param[0]="D";
        return BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
    }
    
    
}