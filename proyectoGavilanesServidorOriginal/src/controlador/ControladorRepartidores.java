/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloRepartidores;
import vista.ListaProductos;
import vista.ListaRepartidores2;
import vista.TablaRepartidores1;
import vista.VistaAgregarRepartidores;

/**
 *
 * @author José Manuel
 */
public class ControladorRepartidores implements ActionListener {

    VistaAgregarRepartidores vista;
    ModeloRepartidores modelo;

    boolean d;

    public ControladorRepartidores(VistaAgregarRepartidores vista, ModeloRepartidores modelo) {

        this.modelo = modelo;
        this.vista = vista;

        vista.btnAgregarRepa.addActionListener(this);
        vista.btnActualizarRepa.addActionListener(this);
        vista.btnConsultarRepa.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnBorrarRegistro.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.btnAgregarRepa)) {
            registrarRepartidores();

        } else if (e.getSource().equals(vista.btnConsultarRepa)) {

            cargarVistaListaRepartidor();

        } else if (e.getSource().equals(vista.btnActualizarRepa)) {
            cambiarDAtos();
        } else if (e.getSource().equals(vista.btnBorrarRegistro)) {
            if (vista.jTableRepartidores.getSelectedRow() >= 0) {
                eliminarRepartidor();
            } else {
                JOptionPane.showMessageDialog(null, "No Ha Seleccionado Una Fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource().equals(vista.btnCancelar)) {
            limpiar();
        }

    }

    private void registrarRepartidores() {
//        boolean repartidorExiste = false;
//        for (int i = 0; i < vista.jTableRepartidores.getRowCount(); i++) {
//            if (vista.jTableRepartidores.getValueAt(i, 2).equals(vista.txtApellidoPaterno.getText())
//                    || vista.jTableRepartidores.getValueAt(i, 3).equals(vista.txtApellidoMaterno.getText())) {
//                repartidorExiste = true;
//            }
//        }
//        if (repartidorExiste) {
//            JOptionPane.showMessageDialog(null, "Ya Fue Registrado");
//        } else 
        if (validarCamposVacios() == true) {
            JOptionPane.showMessageDialog(null, "No Se Han Llenado Todos Los Campos", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {

            modelo.setNombreRepartidor(vista.txtNombreRepartidor.getText());
            modelo.setApellidoPaterno(vista.txtApellidoPaterno.getText());
            modelo.setApellidoMaterno(vista.txtApellidoMaterno.getText());

            modelo.insertarRegistro();
            limpiar();
            recuperarRegistros();

        }

    }

    private void limpiar() {
        vista.txtNombreRepartidor.setText(null);
        vista.txtApellidoPaterno.setText(null);
        vista.txtApellidoMaterno.setText(null);

    }

    private void recuperarRegistros() {
        ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("NOMBRE REPARTIDOR");
        modelo.addColumn("APELLIDO PATERNO");
        modelo.addColumn("APELLIDO MATERNO");

        vista.jTableRepartidores.setModel(modelo);

        String[] datos = new String[4];

        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_ConsultarRepartidores()}");
        ResultSet cdr = objCBD.ejecutarConsulta(instruccionBD);
        try {
            while (cdr.next()) {
                datos[0] = cdr.getString(1);
                datos[1] = cdr.getString(2);
                datos[2] = cdr.getString(3);
                datos[3] = cdr.getString(4);

                modelo.addRow(datos);
            }
            vista.jTableRepartidores.setModel(modelo);
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

            int r = JOptionPane.showConfirmDialog(null, "¿Estás Seguro De Que Quieres Actualizar Este Repartidor?",
                    "Actualizar", JOptionPane.YES_NO_OPTION);

            if (r == 0) {
                modelo.setId_repartidor(vista.id_repartidor.getText());
                modelo.setNombreRepartidor(vista.txtNombreRepartidor.getText());
                modelo.setApellidoPaterno(vista.txtApellidoPaterno.getText());
                modelo.setApellidoMaterno(vista.txtApellidoMaterno.getText());

                modelo.editarDatosRepartidor();
                limpiar();
                recuperarRegistros();
            }
        }

    }

    private void eliminarRepartidor() {
 ConexionBD objCBD = new ConexionBD();
        DefaultTableModel dtm = (DefaultTableModel) vista.jTableRepartidores.getModel();
        int fila = vista.jTableRepartidores.getSelectedRow();
        String valor = vista.jTableRepartidores.getValueAt(fila, 1).toString();
        int r = JOptionPane.showConfirmDialog(null, "¿Estás Seguro De Que Quieres Eliminar Este Repartidor?",
                "Eliminar", JOptionPane.YES_NO_OPTION);
        if (r == 0) {
            ArrayList instruccionBD = new ArrayList();
            instruccionBD.add("{CALL sp_EliminarRepartidor(?)}");
            instruccionBD.add(valor);
           
            objCBD.ejecutarABC(instruccionBD);
            JOptionPane.showMessageDialog(null, "Repartidor Eliminado Satisfactoriamente");
            dtm.removeRow(vista.jTableRepartidores.getSelectedRow());
            objCBD.cerrarConexion();
        }
    }

    private void cargarVistaListaRepartidor() {
        TablaRepartidores1 open = new TablaRepartidores1();
        open.setVisible(true);

    }

    public void validarRegistro() {
        DefaultTableModel modelo2 = new DefaultTableModel();
        vista.jTableRepartidores.setModel(modelo2);
        for (int i = 0; i < vista.jTableRepartidores.getRowCount(); i++) {
            if (vista.jTableRepartidores.getValueAt(i, 1).equals(vista.txtNombreRepartidor.getText())) {

            }
            JOptionPane.showMessageDialog(null, "Ya Fue Registrado");
            modelo2.removeRow(i);

        }
    }

    private boolean validarCamposVacios() {

        d = vista.txtNombreRepartidor.getText().isEmpty()
                || vista.txtApellidoPaterno.getText().isEmpty()
                || vista.txtApellidoMaterno.getText().isEmpty();

        return d;

    }

}
