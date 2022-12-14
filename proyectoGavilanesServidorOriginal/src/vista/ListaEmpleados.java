/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.ConexionBD;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Garci
 */
public class ListaEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form ListaEmpleados
     */
    
 
    VistaEmpleado vistaE;

    public ListaEmpleados() {
        initComponents();
        visualizarRegistros();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LISTA DE EMPLEADOS");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LISTA DE EMPLEADOS");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("CONSULTA DE EMPLEADOS"));

        jTableEmpleados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "NOMBRE", "PATERNO", "MATERNO", "FECHA DE NACIMIENTO", "EDAD ", "ENTRADA SABADO", "SALIDA SABADO", "ENTRADA DOMINGO", "SALIDA DOMINGO", "GENERO", "CARGO", "USUARIO", "PASS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmpleados.getTableHeader().setReorderingAllowed(false);
        jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
        });
        jTableEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableEmpleadosKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTableEmpleados);
        if (jTableEmpleados.getColumnModel().getColumnCount() > 0) {
            jTableEmpleados.getColumnModel().getColumn(0).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(1).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(2).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(3).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(4).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(5).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(6).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(7).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(8).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel10.setText("BUSQUEDA:");

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosMouseClicked
        // TODO add your handling code here:
        //int fila = jTableProductos.getSelectedRow();
        int seleccionar = jTableEmpleados.rowAtPoint(evt.getPoint());
        vistaE.txt_id_empleados.setText(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 0)));
        vistaE.txtNombre.setText(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 1)));
        vistaE.txtApellidoPat.setText(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 2)));
        vistaE.txtApellidoMaterno.setText(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 3)));
        vistaE.dateFecha.setDateFormatString(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 4)));
        vistaE.txtEdad.setText(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 5)));
        vistaE.cmboHoraEntrada.setSelectedItem(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 6)));
        vistaE.cmboHoraSalida.setSelectedItem(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 7)));
        vistaE.cmboHoraEntradaDomingo.setSelectedItem(String.valueOf(jTableEmpleados.getValueAt(seleccionar,8)));
        vistaE.cmboHoraSalidaDomingo.setSelectedItem(String.valueOf(jTableEmpleados.getValueAt(seleccionar,9)));
        vistaE.comboSingle.setSelectedItem(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 10)));
        vistaE.cmbCargo.setSelectedIndex(Integer.parseInt((String) jTableEmpleados.getValueAt(seleccionar, 11)));
        vistaE.txtUsuario.setText(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 12)));
        vistaE.txtPassword.setText(String.valueOf(jTableEmpleados.getValueAt(seleccionar, 13)));


    }//GEN-LAST:event_jTableEmpleadosMouseClicked

    private void jTableEmpleadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableEmpleadosKeyPressed
        // TODO add your handling code here:
         ConexionBD objCBD = new ConexionBD();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {;
            this.setVisible(false);
             objCBD.cerrarConexion();
        }
    }//GEN-LAST:event_jTableEmpleadosKeyPressed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased

        String buscar = txtBusqueda.getText().toUpperCase();

        BusquedaFiltrada(buscar);
    }//GEN-LAST:event_txtBusquedaKeyReleased

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
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jTableEmpleados;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    private void visualizarRegistros() {
   ConexionBD objCBD = new ConexionBD();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PATERNO");
        modelo.addColumn("MATERNO");
        modelo.addColumn("FECHA DE NACIMIENTO ");
        modelo.addColumn("EDAD");
        modelo.addColumn("ENTRADA SABADO");
        modelo.addColumn("SALIDA SABADO");
        modelo.addColumn("ENTRADA DOMINGO");
        modelo.addColumn("SALIDA DOMINGO");
        modelo.addColumn("GENERO");
        modelo.addColumn("CARGO");
        modelo.addColumn("USUARIO");
        modelo.addColumn("PASS");

        jTableEmpleados.setModel(modelo);
        String[] datos = new String[14];

       
        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_ConsultarEmpleados()}");
        ResultSet cdr = objCBD.ejecutarConsulta(instruccionBD);
        try {
            while (cdr.next()) {
                datos[0] = cdr.getString("id_empleado");
                datos[1] = cdr.getString("nombre_empleado");
                datos[2] = cdr.getString("aPaterno");
                datos[3] = cdr.getString("aMaterno");
                datos[4] = cdr.getString("fecha_nacimiento");
                datos[5] = cdr.getString("edad_empleado");
                datos[6] = cdr.getString("hora_entrada_sabado");
                datos[7] = cdr.getString("hora_salida_sabado");
                datos[8] = cdr.getString("hora_entrada_domingo");
                datos[9] = cdr.getString("hora_salida_domingo");
                datos[10] = cdr.getString("genero_empleado");
                datos[11] = cdr.getString(3);
                datos[12] = cdr.getString(4);
                datos[13] = cdr.getString(5);
                modelo.addRow(datos);

            }
            jTableEmpleados.setModel(modelo);
            objCBD.cerrarConexion();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);

       }finally {

            objCBD.cerrarConexion();
        }
    }

    private void BusquedaFiltrada(String buscar) {
    ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PATERNO");
        modelo.addColumn("MATERNO");
        modelo.addColumn("FECHA DE NACIMIENTO ");
        modelo.addColumn("EDAD");
        modelo.addColumn("ENTRADA SABADO");
        modelo.addColumn("SALIDA SABADO");
        modelo.addColumn("ENTRADA DOMINGO");
        modelo.addColumn("SALIDA DOMINGO");
        modelo.addColumn("GENERO");
        modelo.addColumn("CARGO");
        modelo.addColumn("USUARIO");
        modelo.addColumn("PASS");
        jTableEmpleados.setModel(modelo);
        String[] datos = new String[14];

      
        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_ConsultarEmpleadosZ(?)}");
         instruccionBD.add(buscar);
        ResultSet cdr = objCBD.ejecutarConsulta(instruccionBD);
        try {
            while (cdr.next()) {
                datos[0] = cdr.getString("id_empleado");
                datos[1] = cdr.getString("nombre_empleado");
                datos[2] = cdr.getString("aPaterno");
                datos[3] = cdr.getString("aMaterno");
                datos[4] = cdr.getString("fecha_nacimiento");
                datos[5] = cdr.getString("edad_empleado");
                datos[6] = cdr.getString("hora_entrada_sabado");
                datos[7] = cdr.getString("hora_salida_sabado");
                datos[8] = cdr.getString("hora_entrada_domingo");
                datos[9] = cdr.getString("hora_salida_domingo");
                datos[10] = cdr.getString("genero_empleado");
                datos[11] = cdr.getString(3);
                datos[12] = cdr.getString(4);
                datos[13] = cdr.getString(5);
                modelo.addRow(datos);
            }
            jTableEmpleados.setModel(modelo);
            objCBD.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }finally {

            objCBD.cerrarConexion();
        }

    }

}
