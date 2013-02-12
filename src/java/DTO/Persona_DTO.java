/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CORTEX
 */
public class Persona_DTO {
    private String Direccion_Persona;
    private String nombre_Persona;
    private int telefono;

    public Persona_DTO(String Direccion_Persona, String nombre_Persona, int telefono) {
        this.Direccion_Persona = Direccion_Persona;
        this.nombre_Persona = nombre_Persona;
        this.telefono = telefono;
    }

    public Persona_DTO() {
    }

    public String getDireccion_Persona() {
        return Direccion_Persona;
    }

    public void setDireccion_Persona(String Direccion_Persona) {
        this.Direccion_Persona = Direccion_Persona;
    }

    public String getNombre_Persona() {
        return nombre_Persona;
    }

    public void setNombre_Persona(String nombre_Persona) {
        this.nombre_Persona = nombre_Persona;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
