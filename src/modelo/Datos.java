/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author vicec
 */
public class Datos extends Conexion {

    private Connection cn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private String[] titulos;
    private Object[][] datos = null;

    public Datos() {
        cn = getConexion();
        try {
            st = cn.createStatement();
            rs = st.executeQuery("select * from user");

        } catch (SQLException ex) {
            System.out.println("Error " + ex.toString());
        }

    }

    public String[] getTitulos() {
        return titulos;
    }

    public Object[][] getDatos() {

        try {

            int cantColumnas = rs.getMetaData().getColumnCount();

            rs.last(); // va hasta el final
            int cantFilas = rs.getRow();
            rs.beforeFirst(); // va al comienzo;

            titulos = new String[cantColumnas];

            datos = new Object[cantFilas][cantColumnas];

            //cargar los titulos de la tabla
            for (int i = 0; i < titulos.length; i++) {
                titulos[i] = rs.getMetaData().getColumnLabel(i + 1);
            }

            //carga de filas y columnas en la matriz de objetos
            for (int filas = 0; filas < cantFilas; filas++) {
                rs.next();
                for (int columnas = 0; columnas < cantColumnas; columnas++) {
                    datos[filas][columnas] = rs.getString(columnas + 1);
 
                }
               

            }

        } catch (SQLException ex) {
            System.out.println("Error " + ex.toString());
        }
        return datos;

    }

}
