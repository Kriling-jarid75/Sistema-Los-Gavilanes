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
public class ModeloProductos {

    private String id_productos;
    private String nombre;
    private String descripcion;
    private String cantidad;
    private String precioCompra;
    private String precioVenta;

    public String getId_productos() {
        return id_productos;
    }

    public void setId_productos(String id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void insertarRegistro() {
        ConexionBD objCBD = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{CALL sp_RegistrarProducto(?,?,?,?,?)}");
        instruccionBD.add(nombre);
        instruccionBD.add(descripcion);
        instruccionBD.add(cantidad);
        instruccionBD.add(precioCompra);
        instruccionBD.add(precioVenta);
        objCBD.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro del Producto Exitoso");
        objCBD.cerrarConexion();

    }

    public void consultarDatos(String n) {
        ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add(0, "{call sp_ConsultarProductosN(?)}");
        instruccionBD.add(n);

        obj.ejecutarConsulta(instruccionBD);
        ResultSet cdr = obj.getCdr();
        try {
            while (cdr.next()) {
                id_productos = cdr.getString("id_producto");
                nombre = cdr.getString("nombre_producto");
                descripcion = cdr.getString("descripcion");
                cantidad = cdr.getString("cantidad");
                precioCompra = cdr.getString("precio_compra");
                precioVenta = cdr.getString("precio_venta");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Se Pudo Realizar La Consulta " + ex,
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            obj.cerrarConexion();
        }

    }

    public void editarDatos() {
         ConexionBD obj = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add(0, "{call sp_EditarProducto(?,?,?,?,?,?)}");
        instruccionBD.add(id_productos);
        instruccionBD.add(nombre);
        instruccionBD.add(descripcion);
        instruccionBD.add(cantidad);
        instruccionBD.add(precioCompra);
        instruccionBD.add(precioVenta);
        obj.ejecutarABC(instruccionBD);
        JOptionPane.showMessageDialog(null, "Registro del Producto Actualizado");
        obj.cerrarConexion();
    }
}
