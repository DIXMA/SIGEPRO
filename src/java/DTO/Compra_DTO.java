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
public class Compra_DTO {
    private String id_Compra;
    private Proveedor_DTO proveedor_Compra;
    private ArrayList<Insumo_DTO> insumos_Compra;
    private float costo_Compra;
    private String nit;

    public Compra_DTO(String id,Proveedor_DTO proveedor_Compra, ArrayList<Insumo_DTO> insumos_Compra, float costo_Compra, String nit) {
        this.id_Compra=id;
        this.proveedor_Compra = proveedor_Compra;
        this.insumos_Compra = insumos_Compra;
        this.costo_Compra = costo_Compra;
        this.nit=nit;
    }

    public Compra_DTO() {
    }

    public Proveedor_DTO getProveedor_Compra() {
        return proveedor_Compra;
    }

    public void setProveedor_Compra(Proveedor_DTO proveedor_Compra) {
        this.proveedor_Compra = proveedor_Compra;
    }

    public ArrayList<Insumo_DTO> getInsumos_Compra() {
        return insumos_Compra;
    }

    public void setInsumos_Compra(ArrayList<Insumo_DTO> insumos_Compra) {
        this.insumos_Compra = insumos_Compra;
    }

    public float getCosto_Compra() {
        return costo_Compra;
    }

    public void setCosto_Compra(float costo_Compra) {
        this.costo_Compra = costo_Compra;
    }

    public String getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(String id_Compra) {
        this.id_Compra = id_Compra;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public String getInfoCompraDeuda()
    {
        return this.getId_Compra()+"&"+this.getCosto_Compra()+"&"+this.getProveedor_Compra().getId_Proveedor();
    }
    
}
