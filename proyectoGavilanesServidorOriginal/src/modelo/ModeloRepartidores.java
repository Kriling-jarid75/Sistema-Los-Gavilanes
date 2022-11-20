/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author José Manuel
 */
public class ModeloRepartidores {

    private String id_repartidor;
    private String nombreRepartidor;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public String getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(String id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void insertarRegistro() {
        ConexionBD objCBD = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{CALL sp_RegistrarRepartidor(?,?,?)}");
        instruccionBD.add(nombreRepartidor);
        instruccionBD.add(apellidoPaterno);
        instruccionBD.add(apellidoMaterno);
        objCBD.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
        objCBD.cerrarConexion();

    }

    public void consultarDatos(String n) {
        ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add(0, "{call sp_ConsultarRepartidores(?)}");
        instruccionBD.add(n);
        obj.ejecutarConsulta(instruccionBD);
        ResultSet cdr = obj.getCdr();
        try {
            while (cdr.next()) {
                id_repartidor = cdr.getString("id_repartidor");
                nombreRepartidor = cdr.getString("nombre_repartidor");
                apellidoPaterno = cdr.getString("apellido_paterno");
                apellidoMaterno = cdr.getString("apellido_materno");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Se Pudo Realizar La Consulta " + ex,
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            obj.cerrarConexion();
        }

    }

    public void editarDatosRepartidor() {
        ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add(0, "{call sp_EditarRepartidor(?,?,?,?)}");
        instruccionBD.add(id_repartidor);
        instruccionBD.add(nombreRepartidor);
        instruccionBD.add(apellidoPaterno);
        instruccionBD.add(apellidoMaterno);
        obj.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
        obj.cerrarConexion();
        
    }

}
