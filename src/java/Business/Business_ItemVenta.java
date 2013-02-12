/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.ItemVenta_DAO;
import DAO.RecetaProducto_DAO;
import DAO.Venta_DAO;
import DTO.ProductoVenta_DTO;
import DTO.Producto_DTO;
import DTO.Receta_DTO;
import DTO.Venta_DTO;

/**
 *
 * @author CORTEX
 */
public class Business_ItemVenta {
    
    
    /**
     * Metodo que permite cargar los datos necesarios para realizar la insercion en itemVenta_DAO
     * @param id_Mesero id del mesero que hace la venta
     * @param costo costo de la vena
     * @param fecha fecha de la venta
     * @param productos array de productos vendidos
     * @return ture=si lo logra, o , false= si no lo logra
     * @throws Exception 
     */
    public boolean insertarItemVenta(String id_Mesero,String costo,String fecha, String[]productos)throws Exception
    {
            String var=(new Venta_DAO().obtenerIdUltimaVenta());
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
                v.setId_Venta(var);//asigno el id a la venta vacia
                String con="SELECT id_receta FROM producto WHERE id_producto=?";//creo la consulta de la receta para realizarla en la RecetaProductoDAO
                String pa[]=new String[1];//creo el array para consula parametrizada
                pa[0]=p.getId_Produto();//asigo el id del producto a un array para hacer la cnsulta parametrizada en la RecetaProductoDAO para obtener la receta del Products
                Receta_DTO r=receta.getRecetaProducto(con, pa);//creo la recetaDTO con los datos que me devuelve la consulta en la RecetaPrdoutoDAO
                p.setReceta_Producto(r);//asigno la receta al productoDTO
                pv.getProd().add(p);//asigno el productoDTO al productoVentaDTO                
                ItemVenta_DAO itV=new ItemVenta_DAO();
                result=itV.insertarItemVenta(p.getId_Produto(),var,fecha,r.getId_Receta(),String.valueOf(pv.getCantidadProd()));
            }
            
            return result;
        
    }
    
}
