/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import conexion.ConexionBD;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Garci
 */
public class VistaDetalleOrdenLlamadas extends javax.swing.JInternalFrame {
 
    public VistaDetalleOrdenLlamadas() {

        initComponents();

        visualizarRegistros();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentasLlamadas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        txtRepa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCalendar = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTA DE VENTAS GENERALES DEL DIA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("VENTAS PRESENCIALES"));

        tableVentasLlamadas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableVentasLlamadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "ID ORDEN", "ID PRODUCTO", "NOMBRE PRODUCTO", "CANTIDAD", "PRECIO", "FECHA", "REPARTIDOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVentasLlamadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableVentasLlamadas);
        if (tableVentasLlamadas.getColumnModel().getColumnCount() > 0) {
            tableVentasLlamadas.getColumnModel().getColumn(0).setResizable(false);
            tableVentasLlamadas.getColumnModel().getColumn(1).setResizable(false);
            tableVentasLlamadas.getColumnModel().getColumn(2).setResizable(false);
            tableVentasLlamadas.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("CONSULTA DE LAS VENTAS POR LLAMADAS");

        jLabel3.setText("BUSCAR EL REPARTIDOR:");

        jLabel4.setText("TOTAL: $$");

        txtRepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepaActionPerformed(evt);
            }
        });
        txtRepa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepaKeyReleased(evt);
            }
        });

        jLabel5.setText("SELECCIONE LA FECHA:");

        jCalendar.setDateFormatString("yyyy-MM-dd");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/searchDate0.jpg"))); // NOI18N
        jButton1.setText("BUSCAR FECHA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        btnPdf.setText("GUARDAR PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRepa))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnPdf)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel3)
                            .addComponent(txtRepa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnPdf))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventasPorRepa.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel2)
                .addContainerGap(644, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRepaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepaKeyReleased

        String buscar = txtRepa.getText();
        BusquedaFiltrada(buscar);
    }//GEN-LAST:event_txtRepaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        java.util.Date desde = new java.util.Date();
        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
        desde = jCalendar.getDate();
        String p_fecha_Desde = sdf_desde.format(desde);

        fecha(p_fecha_Desde);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
       
        if (tableVentasLlamadas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No Hay Horario Por Imprimir", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
           generarPdf();
        }
        
        
    }//GEN-LAST:event_btnPdfActionPerformed

    private void txtRepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepaActionPerformed
    private void visualizarRegistros() {
        ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("ID ORDEN");
        modelo.addColumn("ID PRODUCTO");
        modelo.addColumn("NOMBRE PRODUCTO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        modelo.addColumn("FECHA");
        modelo.addColumn("REPARTIDOR");

        tableVentasLlamadas.setModel(modelo);
        String[] datos = new String[8];
       
        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_consultarOLlamada2()}");
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
            tableVentasLlamadas.setModel(modelo);
            objCBD.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);

       }finally {

            objCBD.cerrarConexion();
        }
        totalVenta();
    }

    private void totalVenta() {
        double suma;
        double tt = 0;
        int total = tableVentasLlamadas.getRowCount();
        total -= 1;

        for (int x = 0; x <= total; x++) {
            suma = Double.parseDouble(String.valueOf(tableVentasLlamadas.getValueAt(x, 5)));
            tt = tt + suma;

        }

        double t = tt;
        txtTotalVenta.setText(String.valueOf(t));

    }

    private void BusquedaFiltrada(String texto) {
        ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("ID ORDEN");
        modelo.addColumn("ID PRODUCTO");
        modelo.addColumn("NOMBRE PRODUCTO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        modelo.addColumn("FECHA");
        modelo.addColumn("REPARTIDOR");
        tableVentasLlamadas.setModel(modelo);
        String[] datos = new String[8];
       
        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_consultarRepas2(?)}");
        instruccionBD.add(texto);
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
            tableVentasLlamadas.setModel(modelo);
            objCBD.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
      }finally {

            objCBD.cerrarConexion();
        }
        totalVenta();

    }

    public DefaultTableModel fecha(String fechaUno) {
 ConexionBD objCBD = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDENTIFICADOR");
        modelo.addColumn("ID ORDEN");
        modelo.addColumn("ID PRODUCTO");
        modelo.addColumn("NOMBRE PRODUCTO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        modelo.addColumn("FECHA");
        modelo.addColumn("REPARTIDOR");

        tableVentasLlamadas.setModel(modelo);
        String[] datos = new String[8];
       
        objCBD.realizarConexion();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{call sp_consultarFechas2(?)}");
        instruccionBD.add(fechaUno);
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
            tableVentasLlamadas.setModel(modelo);
            objCBD.cerrarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
      }finally {

            objCBD.cerrarConexion();
        }
        totalVenta();

        return modelo;

    }

    private int i;
    String ruta;

    private static final com.itextpdf.text.Font chapterFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 10, Font.BOLD, BaseColor.BLUE);//LA LIBRERIA DE PUNETE ESPECIFICO                                                                              
    private static final com.itextpdf.text.Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.ITALIC, BaseColor.BLUE);//AQUI TODO EL TEXTO QUEDA EN ROJO 

    public void generarPdf() {

        try {

            Rectangle pageSize = new Rectangle(200f, 200f);
            Document docu = new Document(pageSize);

            Document documento = new Document(PageSize.A6);

            String opcion = JOptionPane.showInputDialog(null, "Nombre del archivo a crear");

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "De acuerdo :) ");
            } else {

                 ruta = System.getProperty("user.home") + ("/Desktop/PDF-GAVILANES/BITACORA DE VENTAS/" + opcion + ".pdf"); //COLOCAR  RUTA
                File path = new File(ruta);
                if (!path.exists()) {

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta));
                    JOptionPane.showMessageDialog(null, "Reporte de Ventas Creado");
                } else {

                    String nom = opcion + (++i);
                    JOptionPane.showMessageDialog(null, "Ya  existe el docuemento, se agrega indice");
                    ruta = System.getProperty("user.home") + ("/Desktop/PDF-GAVILANES/BITACORA DE VENTAS/" + nom + ".pdf");
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta));

                }

               
                documento.open();
                //documento.add(new Paragraph(" LOS GAVILANES ", paragraphFont));

                //documento.add(new Paragraph("------HORARIOS DE LOS EMPLEADOS------", paragraphFont));
                Paragraph tituloN = new Paragraph();
                tituloN.setAlignment(Paragraph.ALIGN_CENTER);
                tituloN.setFont(FontFactory.getFont("Time New Roman", 19, Font.BOLD, BaseColor.BLACK));
                tituloN.add("REPORTE DE VENTAS");
                documento.add(tituloN);
                //tituloN.open();

                int filas2 = tableVentasLlamadas.getRowCount();
                Paragraph saltoLinea = new Paragraph();

                saltoLinea.add("\n");
                //documento.add(saltoLinea);
                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(120);
                //table.set(new float[]{10,10,20,20,10,10});
                table.addCell(new Paragraph("ORDEN", FontFactory.getFont("arial", 5, Font.BOLD, BaseColor.RED)));
                table.addCell(new Paragraph("ID PRODUCTO", FontFactory.getFont("arial", 5, Font.BOLD, BaseColor.RED)));
                table.addCell(new Paragraph("NOMBRE", FontFactory.getFont("arial", 5, Font.BOLD, BaseColor.RED)));
                table.addCell(new Paragraph("CANTIDAD", FontFactory.getFont("arial", 5, Font.BOLD, BaseColor.RED)));
                table.addCell(new Paragraph("PRECIO", FontFactory.getFont("arial", 5, Font.BOLD, BaseColor.RED)));
                table.addCell(new Paragraph("FECHA", FontFactory.getFont("arial", 5, Font.BOLD, BaseColor.RED)));
                table.addCell(new Paragraph("REPARTIDOR", FontFactory.getFont("arial", 5, Font.BOLD, BaseColor.RED)));
                for (int i = 0; i < filas2; i++) {
                    table.addCell(new Paragraph(tableVentasLlamadas.getValueAt(i, 1).toString(), FontFactory.getFont("arial", 4, Font.BOLD, BaseColor.BLACK)));
                    table.addCell(new Paragraph(tableVentasLlamadas.getValueAt(i, 2).toString(), FontFactory.getFont("arial", 4, Font.BOLD, BaseColor.BLACK)));
                    table.addCell(new Paragraph(tableVentasLlamadas.getValueAt(i, 3).toString(), FontFactory.getFont("arial", 4, Font.BOLD, BaseColor.BLACK)));
                    table.addCell(new Paragraph(tableVentasLlamadas.getValueAt(i, 4).toString(), FontFactory.getFont("arial", 4, Font.BOLD, BaseColor.BLACK)));
                    table.addCell(new Paragraph(tableVentasLlamadas.getValueAt(i, 5).toString(), FontFactory.getFont("arial", 4, Font.BOLD, BaseColor.BLACK)));
                    table.addCell(new Paragraph(tableVentasLlamadas.getValueAt(i, 6).toString(), FontFactory.getFont("arial", 4, Font.BOLD, BaseColor.BLACK)));
                    table.addCell(new Paragraph(tableVentasLlamadas.getValueAt(i, 7).toString(), FontFactory.getFont("arial", 4, Font.BOLD, BaseColor.BLACK)));

                }
                // com.itextpdf.text.Image = com.itextpdf.text.Image.getInstance("/src/imagenes");
                //Image imagen = Image.getInstance("src/imagenes/horario-del-contrato-de-formacion.jpg");
                //imagen.(CENTER_ALIGNMENT);
                //imagen.scalePercent(40);
                // imagen.setAlignment(Integer.parseInt(CENTER_ALIGNMENT).toString());
                // documento.add(imagen);

                documento.add(saltoLinea);
                /*documento.add(new Paragraph("ID    ID EMPLEADO    NOMBRE   GÉNERO   ENTRADA   SALIDA ", FontFactory.getFont("arial", 7, Font.BOLD, BaseColor.BLACK)));
            int filas = tableHorario.getRowCount();
            for (int i = 0; i < filas; i++) {
                documento.add(new Paragraph(tableHorario.getValueAt(i, 0).toString() + "     "
                        + tableHorario.getValueAt(i, 1).toString() + "         "
                        + tableHorario.getValueAt(i, 2).toString() + "         "
                        + tableHorario.getValueAt(i, 3).toString() + "         "
                        + tableHorario.getValueAt(i, 4).toString() + "         "
                        + tableHorario.getValueAt(i, 5).toString(), FontFactory.getFont("arial", 7, Font.BOLD, BaseColor.BLACK)));
            }*/

                documento.add(table);
                documento.close();
                path = new File(ruta);
                Desktop.getDesktop().open(path);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(VistaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableVentasLlamadas;
    private javax.swing.JTextField txtRepa;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
