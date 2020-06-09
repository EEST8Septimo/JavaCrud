/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Datos;
import modelo.Usuarios;
import vista.frmTabla;

/**
 *
 * @author vicec
 */
public class Eventos implements ActionListener {

    private frmTabla frmTabla;

    public Eventos() {

        frmTabla = new frmTabla();
        frmTabla.btnCarga.addActionListener(this);

    }
    

    public void Iniciar() {

        frmTabla.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmTabla.btnCarga) {
            Datos datos = new Datos();

            DefaultTableModel modelo = new DefaultTableModel(datos.getDatos(),
                    datos.getTitulos());
            frmTabla.tabla.setModel(modelo);
            
            System.out.println("escucho");
            
        }

    }

}
