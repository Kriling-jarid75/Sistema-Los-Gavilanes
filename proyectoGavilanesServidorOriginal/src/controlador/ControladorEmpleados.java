
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.ConexionBD;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloEmpleados;
import vista.ListaEmpleados;
import vista.VistaEmpleado;

/**
 *
 * @author José Manuel
 */
public class ControladorEmpleados implements InternalFrameListener, ActionListener {

    ConexionBD objCBD = new ConexionBD();
    VistaEmpleado vista;
    ModeloEmpleados modelo;
    boolean m;
    String n, v;
    String fecha_nac;

    String ruta1, ruta2;
    String gr1, gr2;

    public ControladorEmpleados(VistaEmpleado v, ModeloEmpleados m) {

        this.vista = v;
        this.modelo = m;
        this.vista.addInternalFrameListener(this);
        vista.btnRegistrar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnModificar.addActionListener(this);

        vista.btnCambiar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnFoto1.addActionListener(this);
        vista.btnFoto2.addActionListener(this);
        vista.btnCrearExpediente.addActionListener(this);

    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        llenarComboCargos();
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnRegistrar)) {

            guardarDatos();

        } else if (e.getSource().equals(vista.btnModificar)) {

            consultarDatos();

        } else if (e.getSource().equals(vista.btnCambiar)) {

            cambiarDAtos();

        } else if (e.getSource().equals(vista.btnCancelar)) {
            cancelarDatos();

        } else if (e.getSource().equals(vista.btnEliminar)) {

            if (vista.tableEmpleado.getSelectedRow() >= 0) {
                btnEliminar();
            } else {
                JOptionPane.showMessageDialog(null, "No Ha Seleccionado Una Fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource().equals(vista.btnFoto1)) {
            subir1();
        } else if (e.getSource().equals(vista.btnFoto2)) {
            subir2();
        } else if (e.getSource().equals(vista.btnCrearExpediente)) {

            reporte();
        }
    }

    private void visualizarRegistros() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PATERNO");
        modelo.addColumn("MATERNO ");
        modelo.addColumn("FECHA DE NACIMIENTO ");
        modelo.addColumn("EDAD");
        modelo.addColumn("HORARIO SABADO ");
        modelo.addColumn("HORARIO DOMINGO ");
        modelo.addColumn("GENERO");

        vista.tableEmpleado.setModel(modelo);
        String[] datos = new String[9];

        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_consultar()}");
        ResultSet cdr = objCBD.ejecutarConsulta(instruccionBD);
        try {
            while (cdr.next()) {
                datos[0] = cdr.getString(1);
                datos[1] = cdr.getString(2);
                datos[2] = cdr.getString(3);
                datos[3] = cdr.getString(4);
                datos[4] = cdr.getString(5);
                datos[5] = cdr.getString(6);
                datos[6] = cdr.getString(7) + "-" + cdr.getString(8);
                datos[7] = cdr.getString(9) + "-" + cdr.getString(10);
                datos[8] = cdr.getString(11);
                modelo.addRow(datos);

            }
            vista.tableEmpleado.setModel(modelo);
            objCBD.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);

        } finally {

            objCBD.cerrarConexion();
        }

    }

    private void llenarComboCargos() {
        modelo.recuperaCargos();
        for (int i = 0; i < modelo.getCargo().size(); i++) {
            vista.cmbCargo.addItem(modelo.getCargo().get(i).toString());
        }
        objCBD.cerrarConexion();
    }

    private void guardarDatos() {
        String fecha2;
//        boolean empleadoExiste = false;
//
//        for (int i = 0; i < vista.tableEmpleado.getRowCount(); i++) {
//            if (vista.tableEmpleado.getValueAt(i, 2).equals(vista.txtApellidoPat.getText())
//                    || vista.tableEmpleado.getValueAt(i, 3).equals(vista.txtApellidoMaterno.getText())) {
//
//                empleadoExiste = true;
//            }
//        }
//        if (empleadoExiste) {
//            JOptionPane.showMessageDialog(null, "El Empleado Ya Ha Sido Registrado");
//        } else 

        if (validarCamposVacios() == true) {
            JOptionPane.showMessageDialog(null, "No Se Han Llenado Todos los Campos", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            fecha_nac = sdf.format(vista.dateFecha.getDate());

            fecha2 = fecha_nac;
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setApellido_paterno(vista.txtApellidoPat.getText());
            modelo.setApellido_materno(vista.txtApellidoMaterno.getText());
            modelo.setFecha_nac(fecha2);
            modelo.setEdad(vista.txtEdad.getText());
            modelo.setHoraEntrada(String.valueOf(vista.cmboHoraEntrada.getSelectedItem()));
            modelo.setHoraSalida(String.valueOf(vista.cmboHoraSalida.getSelectedItem()));
            modelo.setHoraEntradaDomingo(String.valueOf(vista.cmboHoraEntradaDomingo.getSelectedItem()));
            modelo.setHoraSalidaDomingo(String.valueOf(vista.cmboHoraSalidaDomingo.getSelectedItem()));
            modelo.setGenero(String.valueOf(vista.comboSingle.getSelectedIndex()));
            modelo.setCar(String.valueOf(vista.cmbCargo.getSelectedIndex()));
            modelo.setUsu(vista.txtUsuario.getText());
            modelo.setPass(vista.txtPassword.getText());

            modelo.insertarRegistro();

            visualizarRegistros();
            objCBD.cerrarConexion();

        }

    }

    private void consultarDatos() {

        ListaEmpleados abrir = new ListaEmpleados();
        abrir.setVisible(true);

    }

    private void cancelarDatos() {
        limpiar();
    }

    private void limpiar() {
        vista.txtNombre.setText(null);
        vista.txtApellidoPat.setText(null);
        vista.txtApellidoMaterno.setText(null);
        vista.txtEdad.setText(null);
        vista.cmboHoraEntrada.setSelectedItem("-Seleccione-");
        vista.cmboHoraSalida.setSelectedItem("-Seleccione-");
        vista.cmboHoraEntradaDomingo.setSelectedItem("-Seleccione-");
        vista.cmboHoraEntradaDomingo.setSelectedItem("-Seleccione-");
        vista.comboSingle.setSelectedItem("Selecciona");
        vista.cmbCargo.setSelectedItem("-Seleccione-");
        vista.txtUsuario.setText(null);
        vista.txtPassword.setText(null);
        vista.lblFoto1.setIcon(null);
        vista.lblFoto2.setIcon(null);

    }

    private boolean validarCamposVacios() {

        m = vista.txtNombre.getText().isEmpty()
                || vista.txtApellidoPat.getText().isEmpty()
                || vista.txtApellidoMaterno.getText().isEmpty()
                || vista.txtEdad.getText().isEmpty()
                || vista.cmboHoraEntrada.getSelectedItem().equals("-Seleccione-")
                || vista.cmboHoraSalida.getSelectedItem().equals("-Seleccione-")
                || vista.cmboHoraEntradaDomingo.getSelectedItem().equals("-Seleccione-")
                || vista.cmboHoraEntradaDomingo.getSelectedItem().equals("-Seleccione-")
                || vista.comboSingle.getSelectedItem().equals("--Seleciona--")
                || vista.cmbCargo.getSelectedItem().equals("--Seleciona--")
                || vista.txtUsuario.getText().isEmpty()
                || vista.txtPassword.getText().isEmpty()
                || vista.dateFecha.getDate() == null;

        return m;

    }

    public void llamarTable() {
        visualizarRegistros();
    }

    private void cambiarDAtos() {

        if (validarCamposVacios() == true) {
            JOptionPane.showMessageDialog(null, "No Hay Nada Por Actualizar, Primero Haga Una Consulta!! :( ", "ADEVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int r = JOptionPane.showConfirmDialog(null, "¿Estás Seguro Que Quieres Actualizar Este Registro?",
                    "Actualizar", JOptionPane.YES_NO_OPTION);

            if (r == 0) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                fecha_nac = sdf.format(vista.dateFecha.getDate());

                modelo.setId_empleados(vista.txt_id_empleados.getText());
                modelo.setNombre(vista.txtNombre.getText());
                modelo.setApellido_paterno(vista.txtApellidoPat.getText());
                modelo.setApellido_materno(vista.txtApellidoMaterno.getText());
                modelo.setFecha_nac(fecha_nac);
                modelo.setEdad(vista.txtEdad.getText());
                modelo.setHoraEntrada(String.valueOf(vista.cmboHoraEntrada.getSelectedItem()));
                modelo.setHoraSalida(String.valueOf(vista.cmboHoraSalida.getSelectedItem()));
                modelo.setHoraEntradaDomingo(String.valueOf(vista.cmboHoraEntradaDomingo.getSelectedItem()));
                modelo.setHoraSalidaDomingo(String.valueOf(vista.cmboHoraSalidaDomingo.getSelectedItem()));
                modelo.setGenero(String.valueOf(vista.comboSingle.getSelectedIndex()));
                modelo.setCar(String.valueOf(vista.cmbCargo.getSelectedIndex()));
                modelo.setUsu(vista.txtUsuario.getText());
                modelo.setPass(vista.txtPassword.getText());
                modelo.editarDatos();
                limpiar();
                visualizarRegistros();
                objCBD.cerrarConexion();

            }
        }

    }

    private void btnEliminar() {
        ConexionBD objCBD = new ConexionBD();
        DefaultTableModel dtm = (DefaultTableModel) vista.tableEmpleado.getModel(); //TableProducto es el nombre de mi tabla ;)

        int fila = vista.tableEmpleado.getSelectedRow();

        String valor = vista.tableEmpleado.getValueAt(fila, 1).toString();

        int r = JOptionPane.showConfirmDialog(null, "¿Estás Seguro Que Quieres Eliminar Este Registro?",
                "Eliminar", JOptionPane.YES_NO_OPTION);

        if (r == 0) {

            ArrayList instruccionBD = new ArrayList();
            instruccionBD.add("{CALL sp_dele_emp(?)}");
            instruccionBD.add(valor);

            objCBD.ejecutarABC(instruccionBD);
            JOptionPane.showMessageDialog(null, "Registro Eliminado Satisfactoriamente");
            dtm.removeRow(vista.tableEmpleado.getSelectedRow());
            objCBD.cerrarConexion();
        }

    }

    private void subir1() {
        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            ruta1 = String.valueOf(file);
            ImageIcon imgThisImg = new ImageIcon(ruta1);
            Icon icono = new ImageIcon(imgThisImg.getImage().getScaledInstance(vista.lblFoto1.getWidth(), vista.lblFoto1.getHeight(), Image.SCALE_DEFAULT));
            vista.lblFoto1.setIcon(icono);
            gr1 = ruta1;
        }
    }

    private void subir2() {
        JFileChooser archivo = new JFileChooser();
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            ruta2 = String.valueOf(file);
            ImageIcon imgThisImg2 = new ImageIcon(ruta2);
            Icon icono2 = new ImageIcon(imgThisImg2.getImage().getScaledInstance(vista.lblFoto2.getWidth(), vista.lblFoto2.getHeight(), Image.SCALE_DEFAULT));
            vista.lblFoto2.setIcon(icono2);
            gr2 = ruta2;
        }
    }

    private int i;
    String ruta;

    private static final com.itextpdf.text.Font chapterFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, Font.BOLD, BaseColor.BLUE);
    private static final com.itextpdf.text.Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.ITALIC, BaseColor.BLUE);

    private void reporte() {

        if (vista.txtNombre.getText().isEmpty()
                || vista.txtApellidoPat.getText().isEmpty()
                || vista.txtApellidoMaterno.getText().isEmpty()
                || vista.dateFecha.getDate() == null
                || vista.txtEdad.getText().isEmpty()
                || vista.cmboHoraEntrada.getSelectedItem().equals("-Seleccione-")
                || vista.cmboHoraSalida.getSelectedItem().equals("-Seleccione-")
                || vista.cmboHoraEntradaDomingo.getSelectedItem().equals("-Seleccione-")
                || vista.cmboHoraEntradaDomingo.getSelectedItem().equals("-Seleccione-")
                || vista.comboSingle.getSelectedItem().equals("Seleciona")
                || vista.cmbCargo.getSelectedItem().equals("Seleciona")
                || vista.lblFoto1.getIcon() == null
                || vista.lblFoto2.getIcon() == null) {
            JOptionPane.showMessageDialog(null, "Debes De Llenar Todos Los Campos y No Olvides Escoger Las Fotos", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                Document documento = new Document(PageSize.A6);
                ruta = System.getProperty("user.home") + ("/Desktop/PDF-GAVILANES/EMPLEADOS/" + vista.txtNombre.getText() + " " + vista.txtApellidoPat.getText() + ".pdf");
                File path = new File(ruta);
                if (!path.exists()) {

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta));
                    JOptionPane.showMessageDialog(null, "Reporte de empleado creado");
                } else {
                    String nom = vista.txtNombre.getText() + " " + vista.txtApellidoPat.getText() + (++i);
                    JOptionPane.showMessageDialog(null, "Ya  existe uno, entonces se agrega indice");
                    ruta = System.getProperty("user.home") + ("/Desktop/PDF-GAVILANES/EMPLEADOS/" + nom + ".pdf");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta));

                }
                documento.open();
                documento.add(new Paragraph("             Expediente Electrónico    ", paragraphFont));
                documento.add(new Paragraph("LOS GAVILANES", paragraphFont));
                documento.add(new Paragraph("Fecha: " + new java.util.Date(), FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.BLACK)));

                documento.add(new Paragraph("---------------Datos Del Empleado---------------", paragraphFont));
                documento.add(new Paragraph("Nombre: " + vista.txtNombre.getText(), FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.BLACK)));
                documento.add(new Paragraph("Apellido Paterno: " + vista.txtApellidoPat.getText(), FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.BLACK)));
                documento.add(new Paragraph("Apellido Materno: " + vista.txtApellidoMaterno.getText(), FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.BLACK)));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                fecha_nac = sdf.format(vista.dateFecha.getDate());
                documento.add(new Paragraph("Fecha de nacimiento: " + fecha_nac, FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.BLACK)));
                documento.add(new Paragraph("Edad: " + vista.txtEdad.getText(), FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.BLACK)));
                documento.add(new Paragraph("Género: " + vista.comboSingle.getSelectedItem(), FontFactory.getFont("arial", 9, Font.BOLD, BaseColor.BLACK)));
                documento.add(new Paragraph("--------------Documentos Del Empleado--------------", paragraphFont));
                com.itextpdf.text.Image imagen = com.itextpdf.text.Image.getInstance(gr1);
                imagen.scaleToFit(90, 90);
                imagen.setAlignment(Chunk.ALIGN_CENTER);
                documento.add(imagen);
                com.itextpdf.text.Image imagen2 = com.itextpdf.text.Image.getInstance(gr2);
                imagen2.scaleToFit(90, 90);
                imagen.setAlignment(Chunk.ALIGN_CENTER);

                documento.add(imagen2);
                documento.close();
                path = new File(ruta);
                Desktop.getDesktop().open(path);
                limpiar();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(VistaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(VistaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VistaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
