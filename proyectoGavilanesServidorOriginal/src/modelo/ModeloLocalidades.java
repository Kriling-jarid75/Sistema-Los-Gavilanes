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
public class ModeloLocalidades {

    private String id_locali;
    private String nombreLocali;

    public String getId_locali() {
        return id_locali;
    }

    public void setId_locali(String id_locali) {
        this.id_locali = id_locali;
    }

    public String getNombreLocali() {
        return nombreLocali;
    }

    public void setNombreLocali(String nombreLocali) {
        this.nombreLocali = nombreLocali;
    }

    public void insertarLocalidad() {
        ConexionBD objCBD = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{CALL sp_RegistrarLocalidad(?)}");
        instruccionBD.add(nombreLocali);
        objCBD.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
        objCBD.cerrarConexion();

    }

    public void editarDatosLocalidad() {
        ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add(0, "{call sp_EditarLocalidad(?,?)}");
        instruccionBD.add(id_locali);
        instruccionBD.add(nombreLocali);
        obj.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
        obj.cerrarConexion();
    }

}
