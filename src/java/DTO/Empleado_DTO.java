/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author CORTEX
 */
public class Empleado_DTO extends Persona_DTO{
    private String id;
    private String cargo_Empleado;
    private boolean estado_Empleado;//true=habilitado empleado  &  false=desabilitado el empleado
    private Date fechaIngresoEmpleado;
    private Date fechaSalidaEmpleado;

    public Empleado_DTO(String id, String cargo_Empleado, boolean estado_Empleado, Date fechaIngresoEmpleado, String Direccion_Persona, String nombre_Persona, int telefono) {
        super(Direccion_Persona, nombre_Persona, telefono);
        this.cargo_Empleado = cargo_Empleado;
        this.estado_Empleado = estado_Empleado;
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
        this.id=id;
    }

    public Empleado_DTO() {
    }

    public String getCargo_Empleado() {
        return cargo_Empleado;
    }

    public void setCargo_Empleado(String cargo_Empleado) {
        this.cargo_Empleado = cargo_Empleado;
    }

    public boolean isEstado_Empleado() {
        return estado_Empleado;
    }

    public void setEstado_Empleado(boolean estado_Empleado) {
        this.estado_Empleado = estado_Empleado;
    }

    public Date getFechaIngresoEmpleado() {
        return fechaIngresoEmpleado;
    }

    public void setFechaIngresoEmpleado(Date fechaIngresoEmpleado) {
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
    }

    public Date getFechaSalidaEmpleado() {
        return fechaSalidaEmpleado;
    }

    public void setFechaSalidaEmpleado(Date fechaSalidaEmpleado) {
        this.fechaSalidaEmpleado = fechaSalidaEmpleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    public String getId_Nombre_Empleado()
    {
        return (this.getId()+"_"+this.getNombre_Persona());
    }
    
}
