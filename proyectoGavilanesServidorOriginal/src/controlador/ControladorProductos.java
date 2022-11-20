/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.*;

import modelo.ModeloProductos;

import vista.VistaProductos;

/**
 *
 * @author José Manuel
 */
public class ControladorProductos implements ActionListener {

    ModeloProductos modelo;
    VistaProductos vista;
    String producto;
    private ModeloProductos mp;

    String m = "";
    String ruta1, ruta2;
    String gr1, gr2;
    String n;
    boolean d;

    public ControladorProductos(VistaProductos vista, ModeloProductos modelo) {
        this.modelo = modelo;
        this.vista = vista;

        vista.btnRegistrar.addActionListener(this);

        vista.btnModificar.addActionListener(this);
        vista.btnCambiar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnRegistrar)) {
            registrarProductos();

        } else if (e.getSource().equals(vista.btnModificar)) {
            cargarVistaListaP();
        } else if (e.getSource().equals(vista.btnCambiar)) {
            cambiarDAtos();
        } else if (e.getSource().equals(vista.btnEliminar)) {
            if (vista.jTableProductos.getSelectedRow() >= 0) {
                eliminarProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No Ha Seleccionado Una Fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource().equals(vista.btnLimpiar)) {
            limpiar();
        }
    }

    private void registrarProductos() {
////        boolean productoExiste = false;
////        for (int i = 0; i < vista.jTableProductos.getRowCount(); i++) {
////            if (vista.jTableProductos.getValueAt(i, 1).equals(vista.txtNombre.getText())) {
////                productoExiste = true;
////            }
////        }
////        if (productoExiste) {
////            JOptionPane.showMessageDialog(null, "Ya Fue Registrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
////        } else 

        if (validarCamposVacios()) {
            JOptionPane.showMessageDialog(null, "No Se Han Llenado Todos Los Campos");
        } else {
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setDescripcion(vista.txtDescripcion.getText());
            modelo.setCantidad(vista.txtCantidad.getText());
            modelo.setPrecioCompra(vista.txtPrecioCompra.getText());
            modelo.setPrecioVenta(vista.txtPrecioVenta.getText());
            modelo.insertarRegistro();
            limpiar();
            recuperarRegistros();
        }

    }

    public boolean validarCamposVacios() {
        d = vista.txtNombre.getText().isEmpty()
                || vista.txtDescripcion.getText().isEmpty()
                || vista.txtCantidad.getText().isEmpty()
                || vista.txtPrecioCompra.getText().isEmpty()
                || vista.txtPrecioVenta.getText().isEmpty();

        return d;
    }

    private void limpiar() {
        vista.txtNombre.setText(null);
        vista.txtDescripcion.setText(null);
        vista.txtCantidad.setText(null);
        vista.txtPrecioCompra.setText(null);
        vista.txtPrecioVenta.setText(null);

    }

    private void recuperarRegistros() {
        ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO VENTA");

        vista.jTableProductos.setModel(modelo);

        String[] datos = new String[6];

        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_ConsultarProductosTable()}");
        ResultSet cdr = objCBD.ejecutarConsulta(instruccionBD);
        try {
            while (cdr.next()) {
                datos[0] = cdr.getString(1);
                datos[1] = cdr.getString(2);
                datos[2] = cdr.getString(3);
                datos[3] = cdr.getString(4);
                datos[4] = cdr.getString(5);
                datos[5] = cdr.getString(6);
                modelo.addRow(datos);
            }
            vista.jTableProductos.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);

        } finally {

            objCBD.cerrarConexion();
        }
    }

    private void cambiarDAtos() {

        if (validarCamposVacios()) {
            JOptionPane.showMessageDialog(null, "No Hay Nada Por Actualizar, Primero Haga Una Consulta!! :( ", "ADEVERTENCIA", JOptionPane.INFORMATION_MESSAGE);

        } else {
            int r = JOptionPane.showConfirmDialog(null, "¿Estás seguro de Actualizar Este Producto?",
                    "Actualizar", JOptionPane.YES_NO_OPTION);

            if (r == 0) {
                modelo.setId_productos(vista.txtID_productos.getText());
                modelo.setNombre(vista.txtNombre.getText());
                modelo.setDescripcion(vista.txtDescripcion.getText());
                modelo.setCantidad(vista.txtCantidad.getText());
                modelo.setPrecioCompra(vista.txtPrecioCompra.getText());
                modelo.setPrecioVenta(vista.txtPrecioVenta.getText());
                modelo.editarDatos();
                limpiar();
                recuperarRegistros();
            }
        }

    }

    private void eliminarProducto() {
  ConexionBD objCBD = new ConexionBD();
        DefaultTableModel dtm = (DefaultTableModel) vista.jTableProductos.getModel();
        int fila = vista.jTableProductos.getSelectedRow();
        String valor = vista.jTableProductos.getValueAt(fila, 1).toString();

        int r = JOptionPane.showConfirmDialog(null, "¿Estás seguro de Eliminar Este Producto?",
                "Eliminar", JOptionPane.YES_NO_OPTION);
        if (r == 0) {
            ArrayList instruccionBD = new ArrayList();
            instruccionBD.add("{CALL sp_del_pro(?)}");
            instruccionBD.add(valor);
          
            objCBD.ejecutarABC(instruccionBD);
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
            dtm.removeRow(vista.jTableProductos.getSelectedRow());
            objCBD.cerrarConexion();
        }

    }

    private void cargarVistaListaP() {
        ListaProductos abrir = new ListaProductos();
        abrir.setVisible(true);

    }

    public void validarRegistro() {
        DefaultTableModel modelo2 = new DefaultTableModel();
        vista.jTableProductos.setModel(modelo2);
        for (int i = 0; i < vista.jTableProductos.getRowCount(); i++) {
            if (vista.jTableProductos.getValueAt(i, 1).equals(vista.txtNombre.getText())) {

            }
            JOptionPane.showMessageDialog(null, "Ya fue registrado");
            modelo2.removeRow(i);

        }
    }

}
