/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CORTEX
 */
public class Producto_DTO {
    private String id_Produto;
    private Receta_DTO receta_Producto;
    private float precio_Producto;
    private String tipo_Producto; 
    private String nombre_Producto;

    public Producto_DTO(String id_Produto, Receta_DTO receta_Producto, float precio_Producto, String tipo_Producto, String nm) {
        this.id_Produto = id_Produto;
        this.receta_Producto = receta_Producto;
        this.precio_Producto = precio_Producto;
        this.tipo_Producto = tipo_Producto;
        this.nombre_Producto=nm;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public Producto_DTO() {
    }

    public String getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(String id_Produto) {
        this.id_Produto = id_Produto;
    }

    public Receta_DTO getReceta_Producto() {
        return receta_Producto;
    }

    public void setReceta_Producto(Receta_DTO receta_Producto) {
        this.receta_Producto = receta_Producto;
    }

    public float getPrecio_Producto() {
        return precio_Producto;
    }

    public void setPrecio_Producto(float precio_Producto) {
        this.precio_Producto = precio_Producto;
    }

    public String getTipo_Producto() {
        return tipo_Producto;
    }

    public void setTipo_Producto(String tipo_Producto) {
        this.tipo_Producto = tipo_Producto;
    }
    
    public String nombreYprecioProducto()
    {
        return this.getId_Produto()+"%"+this.getNombre_Producto()+"%"+this.getPrecio_Producto();
    }
    
    public String getDatos()
    {
        return this.getId_Produto()+"%"+this.getReceta_Producto().getId_Receta()+"%"+this.getTipo_Producto()+"%"+this.getPrecio_Producto()+"%"+this.getNombre_Producto();
    }
}
