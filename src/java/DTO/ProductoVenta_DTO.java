/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author CORTEX
 */
public class ProductoVenta_DTO {
    
    Venta_DTO venta;
    ArrayList<Producto_DTO> prod=new ArrayList<Producto_DTO>(); 
    int cantidadProd;

    public ProductoVenta_DTO(Producto_DTO prod, int cantidadProd,Venta_DTO v) {
        this.prod.add(prod);
        this.cantidadProd = cantidadProd;
        this.venta=v;
    }

    public ProductoVenta_DTO() {
    }

    public Venta_DTO getVenta() {
        return venta;
    }

    public void setVenta(Venta_DTO venta) {
        this.venta = venta;
    }

    public int getCantidadProd() {
       return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public ArrayList<Producto_DTO> getProd() {
        return prod;
    }

    public void setProd(ArrayList<Producto_DTO> prod) {
        this.prod = prod;
    }
    
    
    
}
