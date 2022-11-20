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
 * @author Garci
 */
public class ModeloEmpleados {

    private String id_empleados;
    private String nombre;
    private String Apellido_paterno;
    private String Apellido_materno;
    private String edad;
    private String genero;
    private String fecha_nac;
    private String horaEntrada;
    private String horaSalida;

    private String horaEntradaDomingo;
    private String horaSalidaDomingo;

    private String car;
    private String usu;
    private String pass;

    public String getId_empleados() {
        return id_empleados;
    }

    public void setId_empleados(String id_empleados) {
        this.id_empleados = id_empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return Apellido_paterno;
    }

    public void setApellido_paterno(String Apellido_paterno) {
        this.Apellido_paterno = Apellido_paterno;
    }

    public String getApellido_materno() {
        return Apellido_materno;
    }

    public void setApellido_materno(String Apellido_materno) {
        this.Apellido_materno = Apellido_materno;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    ArrayList cargo = new ArrayList();

    public ArrayList getCargo() {
        return cargo;
    }

    public String getHoraEntradaDomingo() {
        return horaEntradaDomingo;
    }

    public void setHoraEntradaDomingo(String horaEntradaDomingo) {
        this.horaEntradaDomingo = horaEntradaDomingo;
    }

    public String getHoraSalidaDomingo() {
        return horaSalidaDomingo;
    }

    public void setHoraSalidaDomingo(String horaSalidaDomingo) {
        this.horaSalidaDomingo = horaSalidaDomingo;
    }

    public void insertarRegistro() {
        ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();

        instruccionBD.add(0, "{call sp_InsertarEmp(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        instruccionBD.add(nombre);
        instruccionBD.add(Apellido_paterno);
        instruccionBD.add(Apellido_materno);
        instruccionBD.add(fecha_nac);
        instruccionBD.add(edad);
        instruccionBD.add(horaEntrada);
        instruccionBD.add(horaSalida);
        instruccionBD.add(horaEntradaDomingo);
        instruccionBD.add(horaSalidaDomingo);
        instruccionBD.add(genero);
        instruccionBD.add(car);
        instruccionBD.add(usu);
        instruccionBD.add(pass);

        obj.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro Fue Éxitoso");

        obj.cerrarConexion();

    }

    public void recuperaCargos() {
        ConexionBD objCBD = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{CALL sp_do()}");

        objCBD.ejecutarConsulta(instruccionBD);
        ResultSet cdr = objCBD.getCdr();
        try {
            while (cdr.next()) {
                cargo.add(cdr.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La consulta no se ha podido ejecutar. Razón SQL: " + ex, "EXCEPCIÓN SQL", JOptionPane.ERROR_MESSAGE);
        } finally {

            objCBD.cerrarConexion();
        }
    }

    public void consultarDatos(String n) {
          ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add(0, "{call sp_ConsultarEmpleados(?)}");
        instruccionBD.add(n);
      
        obj.ejecutarConsulta(instruccionBD);
        ResultSet cdr = obj.getCdr();
        try {
            while (cdr.next()) {
                id_empleados = cdr.getString("id_empleado");
                nombre = cdr.getString(7);
                Apellido_paterno = cdr.getString(8);
                Apellido_materno = cdr.getString(9);
                fecha_nac = cdr.getString(10);
                edad = cdr.getString(11);
                horaEntrada = cdr.getString(12);
                horaSalida = cdr.getString(13);
                horaEntradaDomingo = cdr.getString(14);
                horaSalidaDomingo = cdr.getString(15);
                genero = cdr.getString(16);
                car = cdr.getString(3);
                usu = cdr.getString(4);
                pass = cdr.getString(5);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Se Pudo Realizar La Consulta " + ex,
                    "Error", JOptionPane.ERROR_MESSAGE);
       }finally {

            obj.cerrarConexion();
        }

    }

    public void editarDatos() {
        ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add(0, "{call sp_EditarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        instruccionBD.add(id_empleados);
        instruccionBD.add(nombre);
        instruccionBD.add(Apellido_paterno);
        instruccionBD.add(Apellido_materno);
        instruccionBD.add(fecha_nac);
        instruccionBD.add(edad);
        instruccionBD.add(horaEntrada);
        instruccionBD.add(horaSalida);
        instruccionBD.add(horaEntradaDomingo);
        instruccionBD.add(horaSalidaDomingo);
        instruccionBD.add(genero);
        instruccionBD.add(car);
        instruccionBD.add(usu);
        instruccionBD.add(pass);
        obj.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro Actualizado Satisfactoriamente");
        obj.cerrarConexion();
    }

    public void eliminarRegistro() {
          ConexionBD objCBD = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{CALL sp_EliminarProducto(?)}");
        instruccionBD.add(nombre);
        objCBD.ejecutarABC(instruccionBD);
        objCBD.cerrarConexion();
        

    }

}
