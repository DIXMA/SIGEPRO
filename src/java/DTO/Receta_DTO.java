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
public class Receta_DTO {
    private String id_Receta;
    private String nombre_Receta;
    private ArrayList<Ingrediente_DTO> ingredientes_Receta;

    public Receta_DTO(String id_Receta, String nombre_Receta, ArrayList<Ingrediente_DTO> ingredientes_Receta) {
        this.id_Receta = id_Receta;
        this.nombre_Receta = nombre_Receta;
        this.ingredientes_Receta = ingredientes_Receta;
    }

    public Receta_DTO() {
    }

    public String getId_Receta() {
        return id_Receta;
    }

    public void setId_Receta(String id_Receta) {
        this.id_Receta = id_Receta;
    }

    public String getNombre_Receta() {
        return nombre_Receta;
    }

    public void setNombre_Receta(String nombre_Receta) {
        this.nombre_Receta = nombre_Receta;
    }

    public ArrayList<Ingrediente_DTO> getIngredientes_Receta() {
        return ingredientes_Receta;
    }

    public void setIngredientes_Receta(ArrayList<Ingrediente_DTO> ingredientes_Receta) {
        this.ingredientes_Receta = ingredientes_Receta;
    }
        
}
