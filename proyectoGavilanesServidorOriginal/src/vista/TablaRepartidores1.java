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
 * @author José Manuel
 */
public class TablaRepartidores1 extends javax.swing.JFrame {

    /**
     * Creates new form TablaRepartidores1
     */
  
 
    
    VistaAgregarRepartidores vistaR;
    public TablaRepartidores1() {
        initComponents();
          recuperarRegistros();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRepartidores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LISTA DE REPARTIDORES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LISTA DE REPARTIDORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("TABLA DE REPARTIDORES"));

        jTableRepartidores = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTableRepartidores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "NOMBRE REPARTIDOR", "APELIDO PATERNO", "APELLIDO MATERNO"
            }
        ));
        jTableRepartidores.getTableHeader().setReorderingAllowed(false);
        jTableRepartidores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRepartidoresMouseClicked(evt);
            }
        });
        jTableRepartidores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableRepartidoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRepartidores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 580, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableRepartidoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRepartidoresMouseClicked
        int seleccionar = jTableRepartidores.rowAtPoint(evt.getPoint());
        vistaR.id_repartidor.setText(String.valueOf(jTableRepartidores.getValueAt(seleccionar, 0)));
        vistaR.txtNombreRepartidor.setText(String.valueOf(jTableRepartidores.getValueAt(seleccionar, 1)));
        vistaR.txtApellidoPaterno.setText(String.valueOf(jTableRepartidores.getValueAt(seleccionar, 2)));
        vistaR.txtApellidoMaterno.setText(String.valueOf(jTableRepartidores.getValueAt(seleccionar, 3)));

    }//GEN-LAST:event_jTableRepartidoresMouseClicked

    private void jTableRepartidoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRepartidoresKeyPressed
    ConexionBD objCBD = new ConexionBD();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {;
            this.setVisible(false);
            objCBD.cerrarConexion();
        }      
    }//GEN-LAST:event_jTableRepartidoresKeyPressed

    private void recuperarRegistros() {
  ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("NOMBRE REPARTIDOR");
        modelo.addColumn("APELLIDO PATERNO");
        modelo.addColumn("APELLIDO MATERNO");
      

        jTableRepartidores.setModel(modelo);

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
            jTableRepartidores.setModel(modelo);
            objCBD.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);

      }finally {

            objCBD.cerrarConexion();
        }
    }
    
    
    
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
            java.util.logging.Logger.getLogger(TablaRepartidores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaRepartidores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaRepartidores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaRepartidores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaRepartidores1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRepartidores;
    // End of variables declaration//GEN-END:variables
}