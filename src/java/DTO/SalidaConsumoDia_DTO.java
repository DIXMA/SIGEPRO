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
public class SalidaConsumoDia_DTO {
    private String id_Scd;
    private ArrayList<Insumo_DTO> insumos;
    private Date fecha;
    private String hora;

    public SalidaConsumoDia_DTO(String id_Scd, ArrayList<Insumo_DTO> insumos, Date fecha, String hora) {
        this.id_Scd = id_Scd;
        this.insumos = insumos;
        this.fecha = fecha;
        this.hora = hora;
    }

    public SalidaConsumoDia_DTO() {
    }

    public String getId_Scd() {
        return id_Scd;
    }

    public void setId_Scd(String id_Scd) {
        this.id_Scd = id_Scd;
    }

    public ArrayList<Insumo_DTO> getInsumos() {
        return insumos;
    }

    public void setInsumos(ArrayList<Insumo_DTO> insumos) {
        this.insumos = insumos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
