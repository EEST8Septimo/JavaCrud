/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CtrlUsuarios;
import controlador.Eventos;
import modelo.Conexion;
import java.sql.*;
import modelo.Consultas;
import modelo.Datos;
import modelo.Usuarios;

/**
 *
 * @author vicec
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
         Usuarios u = new Usuarios();
        Consultas c = new Consultas();
        frmUsuarios formulario = new frmUsuarios();
        CtrlUsuarios control = new CtrlUsuarios(u, c, formulario);
        control.Iniciar();
        //formulario.setVisible(true);
    

        
        
    }

}
