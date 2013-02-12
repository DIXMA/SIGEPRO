 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.ArrayList;
import util.*;
import DTO.*;
/**
 *
 * @author CORTEX
 */
public class Venta_DAO {
 
    /**
     * Metodo que realiza la insercion de la venta y envia datos a realizar el item Venta
     * @param id_Mesero el mesero quien realiza la venta
     * @param costo el valor total de la venta
     * @param fecha la fecha en se realizo la venta
     * @param productos los productos que se vendieron
     * @return ture si se realizo la insercion o false si no la realizo
     * @throws Exception 
     */
    public boolean crearVenta(String id_Mesero,String costo,String fecha, String[]productos)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="INSERT INTO venta VALUES (?,?,?)";
        String param[]=new String[3];
        param[0]=id_Mesero;
        param[1]=costo;
        param[2]="V"+secuenciaIdVenta();
       return (BaseDeDatos.getInstance().ejecutarActualizacionSQL(sql,param));
        /*if(ver)
        {
            boolean result=false;
            for(int i=0;i<productos.length;i++)
            {
                RecetaProducto_DAO receta=new RecetaProducto_DAO();//creo la receta vaicaDAO para realizar consulta
                String datos[]=productos[i].split("-");//obtengo los datos de los prod vedidos en un array
                Producto_DTO p=new Producto_DTO();//creo un productoDTO vacio
                ProductoVenta_DTO pv=new ProductoVenta_DTO();//creo prodcutoVenta_DTO vacio
                p.setId_Produto(datos[0]);//asigno el id al productoDTO 
                p.setNombre_Producto(datos[1]);//asigno nombre al ProductoDTO
                p.setPrecio_Producto(Float.parseFloat(datos[2]));//asigno precio al productoDTO
                pv.setCantidadProd(Integer.parseInt(datos[3]));//asigno la cantidad solicitada del productoDTO
                Venta_DTO v=new Venta_DTO();//creo una VentaDTO vacia
                v.setId_Venta(param[2]);//asigno el id a la venta vacia
                String con="SELECT id_receta FROM producto WHERE id_producto=?";//creo la consulta de la receta para realizarla en la RecetaProductoDAO
                String pa[]=new String[1];//creo el array para consula parametrizada
                pa[0]=p.getId_Produto();//asigo el id del producto a un array para hacer la cnsulta parametrizada en la RecetaProductoDAO para obtener la receta del Products
                Receta_DTO r=receta.getRecetaProducto(con, pa);//creo la recetaDTO con los datos que me devuelve la consulta en la RecetaPrdoutoDAO
                p.setReceta_Producto(r);//asigno la receta al productoDTO
                pv.getProd().add(p);//asigno el productoDTO al productoVentaDTO                
                ItemVenta_DAO itV=new ItemVenta_DAO();
                result=itV.insertarItemVenta(p.getId_Produto(),param[2],fecha,r.getId_Receta(),String.valueOf(pv.getCantidadProd()));
            }
            
            return result;
        }
        return false;*/
    }
    
    /**
     * Metodo que permite continuar la secuencia del id  de las ventas que se registran
     * @return el consecutivo para el ide de la nueva venta
     * @throws Exception 
     */
    private int secuenciaIdVenta()throws Exception
    {
        String sql="SELECT COUNT(id_venta) FROM venta";
        ArrayList<String> x=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        String w[]=x.get(0).split("-");
        System.err.println("adicional de idventa x."+x.get(0)+" w."+w[0]);
        return (Integer.parseInt(w[0]));
    }
    
    
    
    /**
     * Metodo que permite obtener el id de la ultima venta registrada en el sistema
     * @return id de la ultima venta registrada en el sistema
     * @throws Exception 
     */
    public String obtenerIdUltimaVenta() throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        String sql="SELECT id_venta FROM venta order by id_venta DESC limit 1";
        ArrayList<String> v=BaseDeDatos.getInstance().getConsultaSQL(sql, null);
        String vent[]=v.get(0).split("-");
        return vent[0];
    }
    
   
 
  
   
}
