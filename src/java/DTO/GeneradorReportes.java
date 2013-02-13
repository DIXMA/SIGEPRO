
package DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class GeneradorReportes {
    
    
    
    //Metodo que Genera el Reporte  Dados Baja
    public static void generadorReporteDadosBaja(){
        Date hoy = new Date();
        String fecha =""+ hoy.getDay() + hoy.getMonth() + hoy.getYear()+ hoy.getHours()+hoy.getMinutes();
        try
        {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("reportedadosdebaja.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            System.out.println(fecha);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./src/Reportes/"+"DadosBaja"+fecha+".pdf"));
            exporter.exportReport();
        }
        catch(JRException e)
        {
        }  
    }    
    
        //Metodo que Genera el Reporte Inventario
    public static void generadorReporteInventario(){
        Date hoy = new Date();
        String fecha =""+ hoy.getDay() + hoy.getMonth() + hoy.getYear()+ hoy.getHours()+hoy.getMinutes();
        try
        {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("reporteinventario.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            System.out.println(fecha);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./src/Reportes/"+"Inventario"+fecha+".pdf"));
            exporter.exportReport();
        }
        catch(JRException e)
        {
        }  
    }   
    
    public void generadorReporteCompraInsumo() throws SQLException, ClassNotFoundException{
        Date hoy = new Date();
        String fecha =""+ hoy.getDay() + hoy.getMonth() + hoy.getYear()+ hoy.getHours()+hoy.getMinutes();
        try
        {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("reportecomprasdeinsumos.jasper");
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:postgresql://sandbox2.ufps.edu.co/SIGEPRO","postgres", "ufps_f9");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, connection);
            connection.close();
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./src/Reportes/"+"CompraInsumo"+fecha+".pdf"));
            exporter.exportReport();
        }
        catch(JRException e)
        {
        }  
    }
        
}
