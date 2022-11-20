
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ejecutar.Comenzar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloAcceso;
import modelo.ModeloEmpleados;
import modelo.ModeloLocalidades;

import modelo.ModeloPrincipal;
import modelo.ModeloProductos;
import modelo.ModeloRepartidores;
import vista.VistaAcceso;
import vista.VistaAgregarRepartidores;
import vista.VistaEmpleado;
import vista.VistaLocalidades;

//import vista.VistaPrincipal;
import vista.VistaPrincipal;
import vista.VistaProductos;

/**
 *
 * @author José Manuel
 */
public class ControladorPrincipal implements ActionListener {

    VistaPrincipal vista;
    ModeloPrincipal modelo;
    private Component[] menu;
    private Component[] menuItem;

    public ControladorPrincipal(VistaPrincipal vista, ModeloPrincipal modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.mniSalir.addActionListener(this);
        vista.mniProductos.addActionListener(this);
        vista.mniEmpelados.addActionListener(this);
        vista.mniRepartidores.addActionListener(this);
        vista.mnuLocalidad.addActionListener(this);
        vista.mniLocalidades.addActionListener(this);
        otorgarPermisos();
        menu = vista.barraMenu.getComponents();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource().equals(vista.mniProductos)) {
            abrirVistaProductos();

        } else if (e.getSource().equals(vista.mniEmpelados)) {
            abrirVistaEmpleados();
            
        }else if (e.getSource().equals(vista.mniRepartidores)) {
            abrirVistaRepartidores();
            
        }else if (e.getSource().equals(vista.mniLocalidades)) {
            abrirVistaLocalidades();
        }
    }
    private void desactivarMenu() {
        for (int indice = 1; indice < menu.length; indice++) {
            menuItem = vista.barraMenu.getMenu(indice).getMenuComponents();
            for (int i = 0; i < menuItem.length; i++) {
                vista.barraMenu.getMenu(indice).getItem(i).setEnabled(false);
            }
            vista.barraMenu.getMenu(indice).setEnabled(false);
            vista.barraMenu.getMenu(indice).setVisible(false);
        }

    }
    private void otorgarPermisos() {
        ResultSet cdr;

        cdr = modelo.obtenerPermisos(modelo.getCargo());
        if (modelo.getCargo() == 1) {

            vista.mnuOrdenes.setVisible(false);
           // vista.mniOrdenesLLamada.setVisible(false);
            vista.mniOrdenesPresenciales.setVisible(false);
            vista.mnuConsultas.setVisible(false);
           
            vista.mniVentasCall.setVisible(false);
            vista.mnuVentaDelDia.setVisible(false);
         
            /* vista.mnuAcercaDe.setVisible(false);
             vista.mniAcerca.setVisible(false);*/
                    

        } else if (modelo.getCargo() == 2) {

            vista.mnuProductos.setVisible(false);
            vista.mniProductos.setVisible(false);

            vista.mnuEmpleados.setVisible(false);
            vista.mniEmpelados.setVisible(false);

            vista.mnuVentas.setVisible(false);
         

            vista.mnuHorarios.setVisible(false);
            vista.mniConsultarHorarios.setVisible(false);
            
            vista.mnuRepartidor.setVisible(false);
            vista.mniRepartidores.setVisible(false);
            
            vista.mniLocalidades.setVisible(false);
            vista.mnuLocalidad.setVisible(false);
            
           /* vista.mnuAcercaDe.setVisible(false);
             vista.mniAcerca.setVisible(false);
*/
        }
    }
    private void abrirVistaProductos() {

        VistaProductos v = new VistaProductos();
        ModeloProductos m = new ModeloProductos();
        ControladorProductos c = new ControladorProductos(v, m);
        vista.dpEscritorio.add(v);
        v.setVisible(true);
    }
    private void abrirVistaEmpleados() {

        VistaEmpleado v = new VistaEmpleado();
        ModeloEmpleados m = new ModeloEmpleados();
        ControladorEmpleados c = new ControladorEmpleados(v, m);
        vista.dpEscritorio.add(v);
        v.setVisible(true);

    }

    private void abrirVistaRepartidores() {
        
         VistaAgregarRepartidores v = new VistaAgregarRepartidores();
        ModeloRepartidores m = new ModeloRepartidores();
        ControladorRepartidores c = new ControladorRepartidores(v, m);
        vista.dpEscritorio.add(v);
        v.setVisible(true);
        
        
        
    }
    
    
    
    private void abrirVistaLocalidades() {
        
         VistaLocalidades  v = new VistaLocalidades();
        ModeloLocalidades m = new ModeloLocalidades();
        ControladorLocalidades c = new ControladorLocalidades(v, m);
        vista.dpEscritorio.add(v);
        v.setVisible(true);
        
        
        
    }
    
    
    
}
