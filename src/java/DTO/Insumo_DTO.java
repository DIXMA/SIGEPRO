/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CORTEX
 */
public class Insumo_DTO {
    private String id_Insumo;
    private String nombre_Insumo;
    private float contenido_Insumo;
    private float unidades_Insumo;
    private float valor_Insumo;

    public Insumo_DTO(String id_Insumo, String nombre_Insumo, float contenido_Insumo, float unidades_Insumo, float costoI) {
        this.id_Insumo = id_Insumo;
        this.nombre_Insumo = nombre_Insumo;
        this.contenido_Insumo = contenido_Insumo;
        this.unidades_Insumo = unidades_Insumo;
        this.valor_Insumo=costoI;
    }

    public Insumo_DTO() {
    }

    public String getId_Insumo() {
        return id_Insumo;
    }

    public void setId_Insumo(String id_Insumo) {
        this.id_Insumo = id_Insumo;
    }

    public String getNombre_Insumo() {
        return nombre_Insumo;
    }

    public void setNombre_Insumo(String nombre_Insumo) {
        this.nombre_Insumo = nombre_Insumo;
    }

    public float getContenido_Insumo() {
        return contenido_Insumo;
    }

    public void setContenido_Insumo(float contenido_Insumo) {
        this.contenido_Insumo = contenido_Insumo;
    }

    public float getUnidades_Insumo() {
        return unidades_Insumo;
    }

    public void setUnidades_Insumo(float unidades_Insumo) {
        this.unidades_Insumo = unidades_Insumo;
    }

    public float getValor_Insumo() {
        return valor_Insumo;
    }

    public void setValor_Insumo(float valor_Insumo) {
        this.valor_Insumo = valor_Insumo;
    }
    
    public String getIdNombreInsumo()
    {
        return (this.getId_Insumo()+"%"+this.getNombre_Insumo());
    }
    
}
