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
import modelo.ModeloLocalidades;
import modelo.ModeloRepartidores;
import vista.TablaLocalidades;
import vista.TablaRepartidores1;
import vista.VistaAgregarRepartidores;
import vista.VistaLocalidades;

/**
 *
 * @author José Manuel
 */
public class ControladorLocalidades implements ActionListener {

    VistaLocalidades vista;
    ModeloLocalidades modelo;

    boolean m;

    public ControladorLocalidades(VistaLocalidades vista, ModeloLocalidades modelo) {

        this.modelo = modelo;
        this.vista = vista;

        vista.btnAgregarLocali.addActionListener(this);
        vista.btnActualizarLocali.addActionListener(this);
        vista.btnConsultarLocali.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnBorrarRegistro.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.btnAgregarLocali)) {
            registrarRepartidores();

        } else if (e.getSource().equals(vista.btnConsultarLocali)) {
            cargarVistaLocalidades();
        } else if (e.getSource().equals(vista.btnActualizarLocali)) {
            cambiarDAtos();
        } else if (e.getSource().equals(vista.btnBorrarRegistro)) {
            if (vista.jTableLocalidades.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No existen datos registrados", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (vista.jTableLocalidades.getSelectedRow() >= 0) {

                eliminarLocalidad();
            } else {
                JOptionPane.showMessageDialog(null, "No Ha Seleccionado Una Fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource().equals(vista.btnCancelar)) {
            limpiar();
        }

    }

    private void registrarRepartidores() {
        boolean localidadExiste = false;
        for (int i = 0; i < vista.jTableLocalidades.getRowCount(); i++) {
            if (vista.jTableLocalidades.getValueAt(i, 1).equals(vista.txtNombreLocali.getText())) {
                localidadExiste = true;
            }
        }
        if (localidadExiste) {
            JOptionPane.showMessageDialog(null, "Ya Fue Registrado");
        } else if (!vista.txtNombreLocali.getText().isEmpty()) {

            modelo.setNombreLocali(vista.txtNombreLocali.getText());

            modelo.insertarLocalidad();
            limpiar();
            recuperarRegistros();
        } else {
            JOptionPane.showMessageDialog(null, "No Se Han Llenado Todos Los Campos", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void cambiarDAtos() {
        if (validarCamposVacios()) {
            JOptionPane.showMessageDialog(null, "No Hay Nada Por Actualizar, Primero Haga Una Consulta!! :( ", "ADEVERTENCIA", JOptionPane.INFORMATION_MESSAGE);

        } else {
            int r = JOptionPane.showConfirmDialog(null, "¿Estás seguro de Actualizar la Localidiad?",
                    "Actualizar", JOptionPane.YES_NO_OPTION);

            if (r == 0) {
                modelo.setId_locali(vista.id_locali.getText());
                modelo.setNombreLocali(vista.txtNombreLocali.getText());

                modelo.editarDatosLocalidad();
                limpiar();
                recuperarRegistros();
            }
        }

    }

    private void eliminarLocalidad() {
        ConexionBD objCBD = new ConexionBD();
        DefaultTableModel dtm = (DefaultTableModel) vista.jTableLocalidades.getModel();
        int fila = vista.jTableLocalidades.getSelectedRow();
        String valor = vista.jTableLocalidades.getValueAt(fila, 1).toString();
        int r = JOptionPane.showConfirmDialog(null, "¿Estás seguro de Eliminar Esta Localidad?",
                "Eliminar", JOptionPane.YES_NO_OPTION);
        if (r == 0) {
            ArrayList instruccionBD = new ArrayList();
            instruccionBD.add("{CALL sp_EliminarLocalidad(?)}");
            instruccionBD.add(valor);

            objCBD.ejecutarABC(instruccionBD);
            JOptionPane.showMessageDialog(null, "Localidad Eliminada");
            dtm.removeRow(vista.jTableLocalidades.getSelectedRow());
            objCBD.cerrarConexion();
        }
    }

    private void cargarVistaLocalidades() {
        TablaLocalidades open = new TablaLocalidades();
        open.setVisible(true);
    }

    private void limpiar() {
        vista.txtNombreLocali.setText(null);
    }

    private void recuperarRegistros() {
        ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID LOCALIDAD ");
        modelo.addColumn("NOMBRE LOCALIDAD");

        vista.jTableLocalidades.setModel(modelo);

        String[] datos = new String[2];

        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_ConsultarLocalidades()}");
        ResultSet cdr = objCBD.ejecutarConsulta(instruccionBD);
        try {
            while (cdr.next()) {
                datos[0] = cdr.getString(1);
                datos[1] = cdr.getString(2);

                modelo.addRow(datos);
            }
            vista.jTableLocalidades.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);

        } finally {

            objCBD.cerrarConexion();
        }
    }

    private boolean validarCamposVacios() {

        m = vista.txtNombreLocali.getText().isEmpty();

        return m;

    }
}
