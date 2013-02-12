/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CORTEX
 */
public class Ingrediente_DTO {
    private Insumo_DTO insumo;
    private float cantidadInsumo;

    public Ingrediente_DTO(Insumo_DTO insumo, float cantidadInsumo) {
        this.insumo = insumo;
        this.cantidadInsumo = cantidadInsumo;
    }

    public Ingrediente_DTO() {
    }

    public Insumo_DTO getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo_DTO insumo) {
        this.insumo = insumo;
    }

    public float getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(float cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }
    
}
