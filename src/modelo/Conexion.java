/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author vicec
 */
import java.sql.*;


public class Conexion {

    private String host;
    private String usuario;
    private String pass;
    private String baseDeDatos;
    private int puerto;
    Connection cn = null;

    public Conexion() {
    }

    public Connection getConexion(String host, String usuario, String pass, String baseDeDatos, int puerto) {
        this.host = host;
        this.usuario = usuario;
        this.pass = pass;
        this.baseDeDatos = baseDeDatos;
        this.puerto = puerto;
        return cn;
    }

    public Connection getConexion() {

        this.host = "laboratorioderedes.ddns.net";
        this.usuario = "root";
        this.pass = "basededatos2020";
        this.baseDeDatos = "db_septimo";
        this.puerto = 3306;
        String url = "jdbc:mysql://" + host + "/" + baseDeDatos;

        try {
            cn = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexion OK");
        } catch (SQLException ex) {
            System.out.println("Error " + ex.toString());

        }

        return cn;
    }

}
