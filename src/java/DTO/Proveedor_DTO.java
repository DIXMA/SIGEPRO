/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CORTEX
 */
public class Proveedor_DTO extends Persona_DTO{
    private String id_Proveedor;
    private String nit_Proveedor;
    
    public Proveedor_DTO(String id_Proveedor, String Direccion_Persona, String nombre_Persona, int telefono, String nit) {
        super(Direccion_Persona, nombre_Persona, telefono);
        this.id_Proveedor = id_Proveedor;
        this.nit_Proveedor=nit;
    }   

    public String getNit_Proveedor() {
        return nit_Proveedor;
    }

    public void setNit_Proveedor(String nit_Proveedor) {
        this.nit_Proveedor = nit_Proveedor;
    }

    public Proveedor_DTO() {
    }

    public String getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(String id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }
    
    public String getNombre_IDproveedor()
    {
        return (this.getId_Proveedor()+"_"+this.getNombre_Persona());
    }
    
    
}
