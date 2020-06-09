/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Usuarios;
import vista.frmUsuarios;


/**
 *
 * @author vicec
 */
public class CtrlUsuarios implements ActionListener{
    
    private Usuarios usuarios;
    private Consultas consultas;
    private frmUsuarios formulario;

    public CtrlUsuarios(Usuarios usuarios, Consultas consultas, frmUsuarios formulario) {
        
        this.usuarios = usuarios;
        this.consultas = consultas;
        this.formulario = formulario;
        
        this.formulario = new frmUsuarios();
        this.formulario.cmdGuardar.addActionListener(this);
        this.formulario.cmdEliminar.addActionListener(this);
        this.formulario.cmdModificar.addActionListener(this);
        this.formulario.dmdBuscar.addActionListener(this);
    }
    
    
    public void Iniciar(){
      
        formulario.setTitle("Cuentas de Usuario");
        formulario.setVisible(true);
        Limpiar();
        
    }
    
    public void Limpiar(){
        formulario.txtBuscar.setText(null);
        formulario.txtuser_accout.setText(null);
        formulario.txtuser_id.setText(null);
        formulario.txtuser_pass.setText(null);
        formulario.txtuser_type.setText(null);
    }
    

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        System.out.println("Guardado");
        
        if(ev.getSource()==formulario.cmdGuardar){
            usuarios.setUser_id(Integer.parseInt(formulario.txtuser_id.getText()));
            usuarios.setUser_account(formulario.txtuser_accout.getText());
            usuarios.setUser_pass(formulario.txtuser_pass.getText());
            usuarios.setUser_type(Integer.parseInt(formulario.txtuser_type.getText()));
            
            
            if(consultas.Insertar(usuarios)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        }
        
    }
    
    
    
    
    
}
