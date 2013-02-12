/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author CORTEX
 */
public class Venta_DTO {
    private String id_Venta;
    private ArrayList<ProductoVenta_DTO> productos_Venta;
    private Date fecha_Venta;
    private double costo_Venta;
    private Empleado_DTO mesero_Venta;
    private Receta_DTO receta_Venta;

    public Venta_DTO(String id_Venta, ArrayList<ProductoVenta_DTO> productos_Venta, Date fecha_Venta, double costo_Venta, Empleado_DTO mesero, Receta_DTO rec) {
        this.id_Venta = id_Venta;
        this.productos_Venta = productos_Venta;
        this.fecha_Venta = fecha_Venta;
        this.costo_Venta = costo_Venta;
        this.mesero_Venta=mesero;
        this.receta_Venta=rec;
    }

    public Receta_DTO getReceta_Venta() {
        return receta_Venta;
    }

    public void setReceta_Venta(Receta_DTO receta_Venta) {
        this.receta_Venta = receta_Venta;
    }

    public Venta_DTO() {
    }

    public String getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(String id_Venta) {
        this.id_Venta = id_Venta;
    }

    public ArrayList<ProductoVenta_DTO> getProductos_Venta() {
        return productos_Venta;
    }

    public void setProductos_Venta(ArrayList<ProductoVenta_DTO> productos_Venta) {
        this.productos_Venta = productos_Venta;
    }

    public Date getFecha_Venta() {
        return fecha_Venta;
    }

    public void setFecha_Venta(Date fecha_Venta) {
        this.fecha_Venta = fecha_Venta;
    }

    public double getCosto_Venta() {
        return costo_Venta;
    }

    public void setCosto_Venta(double costo_Venta) {
        this.costo_Venta = costo_Venta;
    }

    public Empleado_DTO getMesero_Venta() {
        return mesero_Venta;
    }

    public void setMesero_Venta(Empleado_DTO mesero_Venta) {
        this.mesero_Venta = mesero_Venta;
    }
    
}
