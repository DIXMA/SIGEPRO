/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import DAO.*;
import DTO.*;

/**
 *
 * @author CORTEX
 */
public class Business_CompraInsumo {
    
    /**
     * Metodo que permite insertar en el sistema los insumos y valores que se compraron
     * @param productos array con la informacion de los insumos comprados
     * @param fecha fecha de la compra
     * @param prov id del proveedor
     */
    public boolean insertarItemcompra(String[] productos, String fecha, String prov)throws Exception
    {
        boolean result=false;
            for(int i=0;i<productos.length;i++)
            {
                Insumo_DTO in=new Insumo_DTO();//creo el insumo para agregarlo
                String datos[]=productos[i].split("-");//obtengo los datos de los prod vedidos en un array
                in.setId_Insumo(datos[0]);//asigno el id al productoDTO 
                in.setNombre_Insumo(datos[1]);//asigno nombre al ProductoDTO
                int j=(int)Float.parseFloat((datos[2]));
                in.setValor_Insumo(j);
                float cant=(Float.parseFloat(datos[3]));//asigno la cantidad solicitada del productoDTO
                Insumo_DAO obj=new Insumo_DAO();
                Insumo_DTO aux=obj.getInsumoExisteCantidad(in.getId_Insumo());
                float contenido=cant*aux.getContenido_Insumo();
                Compra_DAO v=new Compra_DAO();//creo una VentaDTO vacia
                String compra=v.obtenerIdUltimaCompra();//asigno el id a la venta vacia
                Inventario_DAO inv=new Inventario_DAO();
                String idInventario=inv.getIdInventarioDeInsumo(in.getId_Insumo());
                CompraInsumo_DAO itV=new CompraInsumo_DAO();
                result=itV.insertarInsumoCompra(in.getId_Insumo(), compra, fecha, prov, String.valueOf(cant), String.valueOf(contenido), idInventario);
            }
         return result;
    }
    
}
