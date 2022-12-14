/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.ConexionBD;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static vista.ActualizarCliente.txtTelefono;
import static vista.FormularioClientes3.cmbLocalidad2;
import static vista.FormularioClientes3.txtCalleDos1;
import static vista.FormularioClientes3.txtCalleTres;
import static vista.FormularioClientes3.txtCalleUno;
import static vista.FormularioClientes3.txtNombre1;
import static vista.FormularioClientes3.txtReferencias2;
import static vista.FormularioClientes3.txtTelefono;
import static vista.ListaClientesLlamada.TablaClientes3;

//import static vista.VistaOrdenesPorLLamadas.txtNombre;

/**
 *
 * @author Garci
 */
public class FormularioClientes2 extends javax.swing.JFrame {

    ListaClientesLlamada listaN;

    boolean m;
    String valor;
    ConexionBD conec = new ConexionBD();

    /**
     * Creates new form FormualrioClinetes
     */
    public FormularioClientes2() {
        initComponents();
        this.setLocationRelativeTo(null);
        ConexionBD objCBD = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_LlenarCBOrdenLocalidades()}");

        objCBD.ejecutarConsulta(instruccionBD);
        ResultSet cdr = objCBD.getCdr();
        try {
            while (cdr.next()) {
                this.cmbLocalidad2.addItem(cdr.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La consulta no se ha podido ejecutar. Razón SQL: " + ex, "EXCEPCIÓN SQL", JOptionPane.ERROR_MESSAGE);
        } finally {

            objCBD.cerrarConexion();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblCalleFinal = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        txtReferencias2 = new javax.swing.JTextField();
        txtCalleTres = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        lblCallePrincipal = new javax.swing.JLabel();
        txtCalleUno = new javax.swing.JTextField();
        lblEntreCalle = new javax.swing.JLabel();
        txtCalleDos1 = new javax.swing.JTextField();
        cmbLocalidad2 = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        lblReferencia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRO DE CLIENTES");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("FORMULARIO DEL CLIENTE"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCalleFinal.setText("Y CALLE:");
        jPanel2.add(lblCalleFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        lblLocalidad.setText("LOCALIDAD:");
        jPanel2.add(lblLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        txtReferencias2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReferencias2KeyTyped(evt);
            }
        });
        jPanel2.add(txtReferencias2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 150, -1));

        txtCalleTres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleTresKeyTyped(evt);
            }
        });
        jPanel2.add(txtCalleTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 150, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 150, 20));

        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 150, -1));

        lblCallePrincipal.setText("CALLE PRINCIPAL:");
        jPanel2.add(lblCallePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 20));

        txtCalleUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleUnoKeyTyped(evt);
            }
        });
        jPanel2.add(txtCalleUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, -1));

        lblEntreCalle.setText("ENTRE CALLE:");
        jPanel2.add(lblEntreCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        txtCalleDos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleDos1KeyTyped(evt);
            }
        });
        jPanel2.add(txtCalleDos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 150, -1));

        cmbLocalidad2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        jPanel2.add(cmbLocalidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 150, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit4.jpg"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 170, 50));

        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addUser1.jpg"))); // NOI18N
        btnRegistrarCliente.setText("REGISTRAR CLIENTE");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, 50));

        labelNombre.setText("NOMBRE DEL CLIENTE:");
        jPanel2.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        lblReferencia.setText("REFERENCIA DEL HOGAR:");
        jPanel2.add(lblReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel9.setText("NÚEMRO DE TELEFONO:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("REGISTRO DE CLIENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtReferencias2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReferencias2KeyTyped

    }//GEN-LAST:event_txtReferencias2KeyTyped

    private void txtCalleTresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleTresKeyTyped

    }//GEN-LAST:event_txtCalleTresKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {

            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros por favor!!");
            txtTelefono.setCursor(null);

        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255
                || txtTelefono.getText().length() > 10) {

            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo debe de ingresar 10 numeros ");
            txtTelefono.setCursor(null);

        }

    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped

    }//GEN-LAST:event_txtNombre1KeyTyped

    private void txtCalleUnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleUnoKeyTyped

    }//GEN-LAST:event_txtCalleUnoKeyTyped

    private void txtCalleDos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleDos1KeyTyped

    }//GEN-LAST:event_txtCalleDos1KeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
//        registrarCliente();

        salirVentana();

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed

//        valor = (String) cmbLocalidad2.getSelectedItem();
//
//
//        if (valor.equalsIgnoreCase("Selecciona")) {
//
//            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
//
//        } else 
        if (validarCamposVacios() == true) {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        } else {
            registrarCliente();
        }


    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioClientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioClientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioClientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioClientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioClientes2().setVisible(true);
            }
        });
    }

    public void registrarCliente() {
        ConexionBD objCBD = new ConexionBD();
        if (validarCamposVacios() == true) {

            JOptionPane.showMessageDialog(null, "No Se Han Llenado Todos los Campos", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            boolean clienteExiste2 = false;
            for (int i = 0; i < listaN.TablaClientes3.getRowCount(); i++) {
                if (listaN.TablaClientes3.getValueAt(i, 1).equals(txtNombre1.getText())) {
                    clienteExiste2 = true;
                }
            }
            if (clienteExiste2) {
                JOptionPane.showMessageDialog(null, "Ya existe");
                ListaClientesLlamada lc1 = new ListaClientesLlamada();
                lc1.setVisible(true);
                this.setVisible(false);

            }

            objCBD.realizarConexion();
            ArrayList instruccionBD = new ArrayList();

            instruccionBD.add("{call sp_insertarCliente(?,?,?,?,?,?,?)}");
            instruccionBD.add(txtNombre1.getText());
            instruccionBD.add(cmbLocalidad2.getSelectedItem());
            instruccionBD.add(txtCalleUno.getText());
            instruccionBD.add(txtCalleDos1.getText());
            instruccionBD.add(txtCalleTres.getText());
            instruccionBD.add(txtReferencias2.getText());
            instruccionBD.add(txtTelefono.getText());
            objCBD.ejecutarABC(instruccionBD);

            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            limpiarCamposDeRegistro();
            ListaClientesLlamada lc = new ListaClientesLlamada();
            lc.setVisible(true);
            this.setVisible(false);
            //visualizarRegistrosClientes();
            // limpiarCamposDeRegistro();
            objCBD.cerrarConexion();
        }

    }

    private void limpiarCamposDeRegistro() {

        txtNombre1.setText(null);
       cmbLocalidad2.setSelectedItem("Selecciona");
        txtCalleUno.setText(null);
        txtCalleDos1.setText(null);
        txtCalleTres.setText(null);
        
        txtTelefono.setText(null);

    }

    private boolean validarCamposVacios() {

        m = txtNombre1.getText().isEmpty()
                || cmbLocalidad2.getSelectedItem().equals("Selecciona")
                || txtCalleUno.getText().isEmpty()
                || txtCalleDos1.getText().isEmpty()
                || txtCalleTres.getText().isEmpty()
                || txtReferencias2.getText().isEmpty();

        return m;

    }

    /*public void visualizarRegistrosClientes(){
         DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("LOCALIDAD");
        modelo.addColumn("CALLE 1");
        modelo.addColumn("CALLE 2 ");
        modelo.addColumn("CALLE 3");
        modelo.addColumn("REFERENCIA");
        modelo.addColumn("NUMERO TEL");

        lista2.TablaClientes2.setModel(modelo);
        String[] datos = new String[8];
        ConexionBD objCBD = new ConexionBD();
        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_consultarClientesTabla()}");
        ResultSet cdr = objCBD.ejecutarConsulta(instruccionBD);
        try {
            while (cdr.next()) {
                datos[0] = cdr.getString(1);
                datos[1] = cdr.getString(2);
                datos[2] = cdr.getString(3);
                datos[3] = cdr.getString(4);
                datos[4] = cdr.getString(5);
                datos[5] = cdr.getString(6);
                datos[6] = cdr.getString(7);
                datos[7] = cdr.getString(8);

                modelo.addRow(datos);

            }
            lista2.TablaClientes2.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);

        }*/
    private void salirVentana() {
        this.setVisible(false);
        conec.cerrarConexion();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegistrarCliente;
    public javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox<String> cmbLocalidad2;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel labelNombre;
    public javax.swing.JLabel lblCalleFinal;
    public javax.swing.JLabel lblCallePrincipal;
    public javax.swing.JLabel lblEntreCalle;
    public javax.swing.JLabel lblLocalidad;
    public javax.swing.JLabel lblReferencia;
    public static javax.swing.JTextField txtCalleDos1;
    public static javax.swing.JTextField txtCalleTres;
    public static javax.swing.JTextField txtCalleUno;
    public static javax.swing.JTextField txtNombre1;
    public static javax.swing.JTextField txtReferencias2;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
