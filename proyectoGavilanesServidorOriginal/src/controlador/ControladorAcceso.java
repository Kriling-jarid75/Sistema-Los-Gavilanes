/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import modelo.ModeloAcceso;
import modelo.ModeloPrincipal;
import vista.VistaAcceso;
import vista.VistaPrincipal;

import conexion.ConexionBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Manuel
 */
public class ControladorAcceso implements ActionListener, KeyListener{
    VistaAcceso vista;
    ModeloAcceso modelo;
    int a=0;
 
    ConexionBD conec = new  ConexionBD();
    
    
    public ControladorAcceso(VistaAcceso v, ModeloAcceso m) {
     this.vista = v;
     this.modelo = m;
     
     
     vista.btnIngresar.addActionListener(this);
     vista.btnCancelar.addActionListener(this);
     vista.btnIngresar.addKeyListener(this);
     vista.txtUsuario.addKeyListener(this);
     vista.pwfPassword.addKeyListener(this);
    // vista.btnCancelar.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(a<3){
            if(e.getSource().equals(vista.btnIngresar)){
                try {
                    iniciarSesion();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAcceso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource().equals(vista.btnCancelar)){
                limpiar();
            }
        }else{
         try { 
             cerrar();
         } catch (SQLException ex) {
             Logger.getLogger(ControladorAcceso.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    }

    private void iniciarSesion() throws SQLException {
        modelo.setUsuario(vista.txtUsuario.getText());
        modelo.setPsw(vista.pwfPassword.getText());
        modelo.validarUsuario();
        String usu=vista.txtUsuario.getText();
        if(modelo.getCargo() != 0){
            JOptionPane.showMessageDialog(null,"¡¡Bienvenido "+usu+ "!!");
            VistaPrincipal v =new VistaPrincipal();
            ModeloPrincipal m = new ModeloPrincipal(modelo.getCargo());
            ControladorPrincipal c = new ControladorPrincipal(v,m);
            v.setVisible(true);
            vista.setVisible(true);
            cerrar();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "Datos Inexistentes",JOptionPane.ERROR_MESSAGE);
//            blocdenotas("Usuario o Contraseña incorrectos");
            limpiar();
          
        }
       
    }

    private void limpiar() {
       vista.txtUsuario.setText(null);
       vista.pwfPassword.setText(null);
    }

   
    private void cerrar() throws SQLException {
       vista.setVisible(false);
         conec.cerrarConexion();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_ENTER){
        modelo.setUsuario(vista.txtUsuario.getText());
        modelo.setPsw(vista.pwfPassword.getText());
        modelo.validarUsuario();
        String usu=vista.txtUsuario.getText();
        if(modelo.getCargo() != 0){
            try {
                JOptionPane.showMessageDialog(null,"¡¡Bienvenido "+usu+ "!!");
                VistaPrincipal v =new VistaPrincipal();
                ModeloPrincipal m = new ModeloPrincipal(modelo.getCargo());
                ControladorPrincipal c = new ControladorPrincipal(v,m);
                v.setVisible(true);
                vista.setVisible(true);
                cerrar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAcceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "Datos Inexistentes",JOptionPane.ERROR_MESSAGE);
            limpiar();
        }
          
        
       } 
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
}
