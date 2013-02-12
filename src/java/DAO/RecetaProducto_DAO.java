/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.util.ArrayList;
import util.*;
/**
 *
 * @author CORTEX
 */
public class RecetaProducto_DAO 
{
    /**
     * Metodo que devuelve la Receta de un producto
     * @param sql la consulta arametrizada
     * @param param los parametros para realizar la consulta parametrizada
     * @return si existe la receta la retora si no retora null
     * @throws Exception 
     */
    public Receta_DTO getRecetaProducto(String sql,String []param)throws Exception
    {
        BaseDeDatos.getInstance().conectar();
        ArrayList<String>z=BaseDeDatos.getInstance().getConsultaSQL(sql, param);
        Receta_DTO a=new Receta_DTO();
        String q[]=z.get(0).split("-");
        a.setId_Receta(q[0]);
        return a;
    }
    
}
