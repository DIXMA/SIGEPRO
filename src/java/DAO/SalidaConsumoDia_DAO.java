/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Insumo_DTO;
import java.util.*;
import util.BaseDeDatos;

/**
 *
 * @author CORTEX
 */
public class SalidaConsumoDia_DAO {
    
    public void addConsumoDia()
    {
    }
    
    /**
     * Metodo que resta de la venta del consummo dia los valores de la ultima registrada en la BD dependiendo de la fecha de hoy
     * @param fecha Fecha en la cual se regustra la ultima venta
     * @return true=si logra o false=si no lo logra
     * @throws Exception 
     */    
    public String restarVentaConsumoDia(String fecha)throws Exception
    {
        String idVenta=(new Venta_DAO().obtenerIdUltimaVenta());
        ArrayList<Insumo_DTO> insumDTO=(new Insumo_DAO().insumosConsumidosEnVenta(fecha, idVenta));
        boolean x=false;
        if(insumDTO.size()>0)
        {
            for(int i=0;i<insumDTO.size();i++)
            {
                BaseDeDatos.getInstance().conectar();
                Insumo_DTO insumodto=insumDTO.get(i);
                Insumo_DTO insumoSistema=(new Insumo_DAO().getInsumoExisteCantidad(insumodto.getId_Insumo()));
                float canConsumoDIa=cantidadInsumoEnsalidaConDia(insumodto.getId_Insumo(),fecha);
                if(canConsumoDIa==-1) 
                {
                    return "Insumo"+insumodto.getId_Insumo()+" agotado, Relizar nueva salida de Bodega";
                }
                float valorActual=this.calcularValorActualizaSalidaConDIa(insumodto.getContenido_Insumo(), insumoSistema.getContenido_Insumo(), canConsumoDIa,insumodto.getId_Insumo());
                x=this.realizarDescuentoConsumDia(valorActual,insumodto.getId_Insumo(),fecha);
                
            }  
            if(x) 
                {
                    return "ejecutado con exito";
                }
        }
        return null;
    }
   
    /**
     * Metodo que actualiza el valor de las existencias en salidaConsumoDia
     * @param v valor que se actualiza
     * @param idIn id del inventario
     * @param fecha fecha de la venta
     * @return true=silo logra o false=si no lo logra
     * @throws Exception 
     */
    private boolean realizarDescuentoConsumDia(float v, String idIn,String fecha)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="UPDATE \"salida_consumoDiario\" SET unidades=? WHERE id_insumo = ? AND fecha_salida=?";
        String []param=new String[3];
        param[0]=String.valueOf(v);
        param[1]=idIn;
        param[2]=fecha;
        return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param)); 
    }  
    
    /**
     * Metodo que devuelve la cantidad del insumo existente en la salidaConsumoDIa
     * @param idInsumo Id del insumo aconsultar
     * @param fecha fecha de la venta
     * @return 0 si no logra realiza la operacion, >0 si logra -1 existencia en stok minimo
     * @throws Exception 
     */
    private float cantidadInsumoEnsalidaConDia(String idInsumo, String fecha)throws Exception
    {
        Date fecha_actual=new Date(); 
            int dia_actual = fecha_actual.getDate(); 
            int mes_actual = fecha_actual.getMonth()+1; 
            int anio_actual = fecha_actual.getYear()+1900;
        String fech=dia_actual+"/"+mes_actual+"/"+anio_actual;
            int d=dia_actual+1;
        String masFecha=d+"/"+mes_actual+"/"+anio_actual;
        if(fecha.equals(fech) || fecha.equals(masFecha))
        {
            BaseDeDatos.getInstance().conectar();
            String sql="SELECT salida_consumoDiario.\"unidades\" AS salida_consumoDiario_unidades FROM \"public\".\"salida_consumoDiario\" salida_consumoDiario WHERE id_insumo=? ";
            String param[]=new String[1];
            param[0]=idInsumo;;
            ArrayList<String> conuslta=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
            if(conuslta.size()>0)
            {
                String q[]=conuslta.get(0).split("-");
                float dato=Float.parseFloat(q[0]);
                if(dato >1)
                {
                  return dato;
                }        
                return -1;
            }
        }
        return 0;
    }
    
    
    /**
     * Metodo que calcula el valor que se debe actualzar en la bd
     * @param valorDescontar cantidad del insumo en onz utilizado en la produccion del producto vendido
     * @param contInsumoOnz el contenido del insumo en onzas
     * @param cantidadConsumDia cantidad de insumo 
     * @param ghh 
     * @return
     * @throws Exception 
     */
    private float calcularValorActualizaSalidaConDIa(float valorDescontar, float contInsumoOnz, float cantidadConsumDia,String ghh)throws Exception
    {
        float totalOnz=(float)contInsumoOnz*cantidadConsumDia;
        float decuentoTotal=(float)totalOnz-valorDescontar;
        float actual=decuentoTotal/contInsumoOnz;
        return actual;
    }
    
    /**
     * Metodo que realiza la insercion de una nueva salida de consumo diario
     * @param idInsumo array con los isumos y unidades que se agrgan a la salida
     * @param fecha fecha en que se realiza la salida
     * @param hora hora en que se realiza la salida
     * @return true=si lo logra o false=si no lo logra
     * @throws Exception 
     */
    public boolean insertarNuevaSalidaDia(String idInsumo[],String fecha,String hora)throws Exception
    {
        boolean ret=false;
        BaseDeDatos.getInstance().conectar();
        String idScd=String.valueOf(this.secuenciaIdscd());
        String sql="INSERT INTO \"salida_consumoDiario\" VALUES (?,?,?,?,?,?)";
        String param[]=new String[6];
        System.err.println("!!!!!!!!llega insumod "+idInsumo.length);
        for(int i=0;i<idInsumo.length;i++)
        {
            String dto[]=idInsumo[i].split("-");
            String inv=(new Inventario_DAO().getIdInventarioDeInsumo(dto[0]));
            param[0]=dto[0];
            param[1]=inv;
            param[2]=fecha;
            param[3]=hora;
            param[4]=dto[1];
            param[5]=idScd;
           ret=BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql, param);
        }
        return ret;
    }    
    
    
     /**
     * Metodo que permite continuar la secuencia del id  de las salida dia que se registran
     * @return el consecutivo para el ide de la nueva salida consumo dia
     * @throws Exception 
     */
    private int secuenciaIdscd()throws Exception
    {
        String sql="SELECT COUNT(id_scd) FROM \"salida_consumoDiario\"";
        ArrayList<String> x=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        String w[]=x.get(0).split("-");
        return (Integer.parseInt(w[0]));
    }
    
}
