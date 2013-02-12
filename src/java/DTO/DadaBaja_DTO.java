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
public class DadaBaja_DTO {
    private String id_DadaBaja;
    private Date fecha_DadaBaja;
    private ArrayList<Producto_DTO> productos_DadaBaja;

    public DadaBaja_DTO(String id_DadaBaja, Date fecha_DadaBaja, ArrayList<Producto_DTO> productos_DadaBaja) {
        this.id_DadaBaja = id_DadaBaja;
        this.fecha_DadaBaja = fecha_DadaBaja;
        this.productos_DadaBaja = productos_DadaBaja;
    }

    public DadaBaja_DTO() {
    }

    public String getId_DadaBaja() {
        return id_DadaBaja;
    }

    public void setId_DadaBaja(String id_DadaBaja) {
        this.id_DadaBaja = id_DadaBaja;
    }

    public Date getFecha_DadaBaja() {
        return fecha_DadaBaja;
    }

    public void setFecha_DadaBaja(Date fecha_DadaBaja) {
        this.fecha_DadaBaja = fecha_DadaBaja;
    }

    public ArrayList<Producto_DTO> getProductos_DadaBaja() {
        return productos_DadaBaja;
    }

    public void setProductos_DadaBaja(ArrayList<Producto_DTO> productos_DadaBaja) {
        this.productos_DadaBaja = productos_DadaBaja;
    }
    
}
