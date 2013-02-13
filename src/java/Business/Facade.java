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
public class Facade 
{
    
    /**
     * Metodo que devuelde los datos de los porductos que inician por un caracter
     * @param caracter el caracter por el que inicia el id del Producto que se desea listar
     * @return ArrayList<String> con la informacion de cada uno de los productos que inician por ese caracter
     */
    public ArrayList<String> nombreYprecioProducto(String caracter)throws Exception
    {
         return (new Business_Producto().getPrecioYnombreProducto(caracter));
    }
 
    /**
     * Metodo que inicia el registro de una venta
     * @param id_Meser el id del mesero quien hizo la venta
     * @param fecha fecha en que se realiza la Venta
     * @param costo valor total de la venta
     * @param porductos informacion de los productos que se vendieron
     * @return true si se pudo realizar la venta o False si no se llevo a vabo
     */
    public boolean realizarVenta(String id_Meser, String fecha, String costo, String []porductos)throws Exception
    {
         boolean z=false;
         boolean x=(new Business_Venta().realizarLaVenta(porductos, costo, fecha, id_Meser));
         if(x)
         {
             z=(new Business_ItemVenta().insertarItemVenta(id_Meser, costo, fecha, porductos));
         }
         return (z);
    }
    
 
    /**
     * Metodo que verifica el id del Mesero que realiza la venta en el Sistema
     * @param id_Meser el id del mesero que realiza la venta y se desea verificar
     * @return true si existe el mesero o false si no se encuentra registrado en sistema
     */
    public ArrayList<String> verificarMeseroParaVenta()throws Exception
    {
        return (new Business_Empleado().verificarMesero());
    }   

    /**
     * Metodo que reune el id y el nombre de los proveedores que esten en el sistema y los concatena para llenar
     * el combobox
     * @return Array con nombres de los proveedores
     */
    public ArrayList<String> cargarProveedor()throws Exception
    {
        return (new Business_Proveedor().getNombresProveedor());
    }
    
    /**
     * Metodo que devuelve en un array el id y el nombre de los meseros registrados
     * @return Array con el id y el nombre de cada mesero registrado
     * @throws Exception 
     */
    public ArrayList<String> cargarMesero()throws Exception
    {
        return (new Business_Empleado().verificarMesero());
    }
    
    /**
     * Metodo que retorna un array con el id y el nombre de los insumos registrados
     * @return Array con el id y el nombre de los insumos existentes
     * @throws Exception 
     */
    public ArrayList<String> cargarInsumos()throws Exception
    {
        return (new Business_Insumo().getId_NombreInsumos());
    }
    
   /**
    * Metodo que llama a actualizar los valores de los insumos en el consumiDia con la venta realizada
    * @param fecha la fecha actual en la que se realiza la venta
    * @return String con mensaje o null si o  logra hacer lo debido
    * @throws Exception 
    */
    public String restarConsumoDiaPorVenta(String fecha)throws Exception
   {
       Business_SalidaConsumoDia x=new Business_SalidaConsumoDia();
       return (x.descontarCantidadPorVenta(fecha));
   }
    
    /**
     * Metodo que permite envar informacion para  registrar la compra a un nuevo proveedor
     * @param fec fecha de la compra al proveedor
     * @param proveedor id del proveedor al que se compro   
     * @param total total facturado de la compra
     * @param productos array con la informacion de los productos comprados
     * @throws Exception 
     */
   public boolean registrarCompraProveedor(String fec,String proveedor,String total, String []productos)throws Exception
   {
       boolean z=false;
       boolean x=(new Business_Compra().regitrarCompraALProveedor(proveedor, total));
       if(x)
       {
           z=(new Business_CompraInsumo().insertarItemcompra(productos, fec, proveedor));
       }
      return z;
   } 
   
   /**
    * Metodo que actualiza el inventario por la ralizacion de una compra
    * @return true=si lo logra false=si no lo logra
    */
   public boolean actualizarInventario()throws Exception
   {
       boolean z=false;
       boolean x=(new Business_Inventario().actualizarInentario());
       if(x)
       {
           z=(new Business_Insumo().actualizaUnidadesInsumoPorCompra());
       }
       return z;
   }
    
   /**
    * Metodo que invoca la concatenacion de la informacion de los insumos en stok minimo
    * @return Array con la informacion de los insumos en stok minimo
    * @throws Exception 
    */
   public ArrayList<String> getInsumosStokMinimo()throws Exception
   {
       return (new Business_Insumo().listarInsumoStokMinimo());
   }
   
   /**
    * Metodo que permite invovar para q se adicione un nuevo proveedor al sistema
    * @param idP id del proveedor
     * @param nomP nombre del proveedor
     * @param nitP nit del proveedor
     * @param dirP direccin del proveedor
     * @param telP telefono del proveedor
     * @return true=si lo logra i false = si no logra
    * @throws Exception 
    */
   public boolean registrarProveedor(String idP,String nomP,String nitP,String dirP,String telP)throws Exception
   {
       return (new Business_Proveedor().añadirProveedor(idP, nomP, nitP, dirP, telP));
   }
   
   /**
     * Metodo que invoca el registro una nueva salida de insumos para el consumo en el dia
     * @param idInsumo array con el ide y la cantidad de insumos que se desan para le consumo dia
     * @param fecha fecha de la salida
     * @param hora hora de la salida
     * @return true= si lo logra o false=si no lo logra
     * @throws Exception 
     */
   public boolean realizarSalidaConsumDia(String id_insumo[], String fecha, String hora)throws Exception
   {
       return (new Business_SalidaConsumoDia().registrarNuevaSalidaDia(id_insumo, fecha, hora));
   }
   
   /**
    * Metodo que permite actualizar las unidades de los insumos debido a la salida de consumo dia
    * @param id_insumo arra con la info de los insumos que se desean actualizar unidades
    * @param fecha fecha actual
    * @return true=si lo logra o false=si no lo logra
    * @throws Exception 
    */
   public boolean restarUnidadesInsumoSalidaDia(String id_insumo[], String fecha)throws Exception
   {
       return (new Business.Business_Insumo().actualizaUnidadesInsumoPorSalidaDia(id_insumo));
   }
   
   
   /**
    * Metodo que permite actualizar el inventario por salida de consumo dia
    * @param insumos array con los insumos q se deben actualizar en el inentario
    * @param fecha fecha actual
    * @return
    * @throws Exception 
    */
   public boolean restarInventPorSalidaDia(String insumos[], String fecha)throws Exception
   {
       return (new Business_Inventario().setInventarioPosSalidaDia(insumos));
   }
   
   /**
    * Metodo que permite invocar la desactivacion de los insumos
    * @param insumos array con la informacion de los insumos a desactivar
    * @return
    * @throws Exception 
    */
   public boolean darBajaInsumo(String []insumos)throws Exception
   {
       return (new Business_Insumo().darBajaInsumoP(insumos));
   }
 
   /**
    * Metodo q realiza la invocacion para el registro de una nueva apertura de caja
    * @param cantidadIni cantidad inicial de dinero con la que se inicia en caja
    * @param fech fecha actual
    * @return true si lo logra o false si no lo logra
    * @throws Exception 
    */
   public boolean realizarAperturaCaja(String cantidadIni,String fech)throws Exception
   {
        return (new Business_ConsolidadoVentasDia().añadirAperturaCaja( cantidadIni, fech));
   }
   
   /**
    * Metodo que permite verificar si hay apertura de caja para permitir
    * registrar ventas
    * @return true= si no se puede realizar venta o false= si se puede realizar la venta
    * @throws Exception 
    */
   public boolean verificarSiCajaAbierta()throws Exception
   {
       return (new Business_ConsolidadoVentasDia().verificarAperturaCaja());
   }
   
   /**
    * Metodo que permite invocar la actualizacion del consoldado de ventas
    * @return true=si lo logra o false=si no lo logra
    * @throws Exception 
    */
   public boolean actualizarConsolidadoVentas()throws Exception
   {
       String totVent=String.valueOf(new Business_Venta().getValorUltimaVenta());
       String aper=(new Business_ConsolidadoVentasDia().getIdAperturaUltim());
       return (new Business_ConsolidadoVentasDia().actualizarTotalVentasRegistradas(aper, totVent));
   }
   
   /**
    * Metodo que invoca a realizar el cierre de caja 
    * @return concatenacion de valor de ventas realizadas y valor con el se inicio en caja
    * @throws Exception 
    */
   public String registrarCierreDeCaja()throws Exception
   {
       return (new Business_ConsolidadoVentasDia().realizarCierreDeCaja());
   }
   
   /**
    * Metodo que permite invocar la actualizacion del consoldado por ingreso a caja
    * @return true=si lo logra o false=si no lo logra
    * @throws Exception 
    */
   public boolean ingreso_Caja(String ret)throws Exception
   {
       String aper=(new Business_ConsolidadoVentasDia().getIdAperturaUltim());
       return (new Business_ConsolidadoVentasDia().actualizarTotalVentasRegistradas(aper, ret));
   }
   
   /**
    * Metodo que invoca la concatenacion de la informacion de las compras en estado "D" debe
    * @return array con la informacion de las compras que se deben
    */
   public ArrayList<String> cargarCompraDeudas()throws Exception
   {
       return (new Business_Compra().getcompraDebe());
   }
   
   /**
    * Metodo que permite invocar la actualizacion del estado de la deuda a paragar
    * @param datos array con los datos de la deuda
    * @return true=si lo logra o false si no l logra
    * @throws Exception 
    */
   public boolean pagoProveedor(String datos[])throws Exception
   {
       return (new Business_Compra().pagarDeudaProveedor(datos));
   }
   
   public boolean descontarPagoDeuda(String dto[])throws Exception
   {
       String aper=(new Business_ConsolidadoVentasDia().getIdAperturaUltim());
       return (new Business_ConsolidadoVentasDia().actualizarPagoProveedor(aper, dto[1]));
   }
}
