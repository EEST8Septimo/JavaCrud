/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vicec
 */
public class Consultas extends Conexion {

    public boolean Insertar(Usuarios u) {
        boolean insertar;
        Connection cn = getConexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user VALUES (?,?,?,?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, u.getUser_id());
            ps.setString(2, u.getUser_account());
            ps.setString(3, u.getUser_pass());
            ps.setInt(4, u.getUser_type());
            ps.execute();
            insertar = true;
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error insert" + ex.toString());

            insertar = false;
        }

        return insertar;
    }

    public boolean Actualizar(Usuarios u) {
        boolean actualizar;
        Connection cn = getConexion();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET (user_accout=?, user_pass=?, user_type=?"
                + "WHERE user_id=?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, u.getUser_id());
            ps.setString(2, u.getUser_account());
            ps.setString(3, u.getUser_pass());
            ps.setInt(4, u.getUser_type());
            ps.execute();
            actualizar = true;
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error update " + ex.toString());
            actualizar = false;
        }

        return actualizar;
    }

    public boolean Eliminar(Usuarios u) {
        boolean eliminar;
        Connection cn = getConexion();
        PreparedStatement ps = null;
        String sql = "DELETE FROM user WHERE user_id=?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, u.getUser_id());
            ps.execute();
            eliminar = true;
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error update " + ex.toString());
            eliminar = false;
        }

        return eliminar;
    }

    public boolean Buscar(Usuarios u) {
        boolean buscar;
        ResultSet rs = null;
        Connection cn = getConexion();
        PreparedStatement ps = null;
        String sql = "DELETE * FROM user WHERE user_id=?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, u.getUser_id());
            rs = ps.executeQuery();

            if (rs.next()) {
                u.setUser_id(rs.getInt(1));
                u.setUser_account(rs.getString(2));
                u.setUser_pass(rs.getString(3));
                u.setUser_type(rs.getInt(4));
                return buscar = true;
            }
            return buscar= false;

       
        } catch (SQLException ex) {
            System.out.println("Error update " + ex.toString());
            buscar = false;
        }

        return buscar;
    }

}
