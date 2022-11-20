package conexion;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//ESTE SISTEMA ES EL ORIGINAL 
public class ConexionBD {

    private String nombreBD;
    private String usuario;
    private String password;
    private String url;
    private ResultSet cdr;
    PreparedStatement sentencia;
    private Connection conn;

    
    
    public ConexionBD() {

        nombreBD = "gavilanes2021";
        usuario = "root";//usuario = "DBgavilanes_USER";
        password = "losGavilanes";//123456 o losGavilanes y cambiar el puerto 3306
        url = "jdbc:mysql://localhost:3306/" + nombreBD + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//?useSSL=false
        //
        //
        //?useSSL=false/mysys?autoReconnect=true 
        //?autoReconnect=true&amp;useSSL=false
        realizarConexion();

    }

    public ResultSet getCdr() {
        return cdr;
    }

    public void realizarConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No encontro la clase dirver" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "No se puede crear la instancia" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Acceso denegado" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar con la base de datos" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {

        ConexionBD objCBD = new ConexionBD();
        objCBD.realizarConexion();
        objCBD.cerrarConexion();

    }

    public void ejecutarABC(ArrayList instruccionBD) {
        try {
            sentencia = conn.prepareCall(instruccionBD.get(0).toString());
            for (int i = 1; i < instruccionBD.size(); i++) {
                sentencia.setString(i, instruccionBD.get(i).toString());
            }
            sentencia.executeUpdate();
        } catch (SQLException ex) {

      //JOptionPane.showMessageDialog(null, "Error no se puedo ejecutar la consulta " + ex, "Error ", JOptionPane.ERROR_MESSAGE);

        }

    }

    public ResultSet ejecutarConsulta(ArrayList instruccionBD) {
        try {
            sentencia = conn.prepareCall(instruccionBD.get(0).toString());
            for (int i = 1; i < instruccionBD.size(); i++) {
                sentencia.setString(i, instruccionBD.get(i).toString());
            }
            cdr = sentencia.executeQuery();

        } catch (SQLException ex) {
         //JOptionPane.showMessageDialog(null, "Error no se puedo ejecutar la consulta" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } /*finally {

            try {
                if (cdr != null) {
                    cdr.close();
                    System.out.println("La conexion ya esta cerrada");

                }
                if (sentencia != null) {
                    sentencia.close();
                    System.out.println("La conexion ya esta cerrada");

                }
                if (conn != null) {
                    conn.close();
                    System.out.println("La conexion ya esta cerrada");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            return cdr;
        
    }

    public void cerrarConexion() {

        try {
            if (cdr != null) {
                cdr.close();
                

            }
            /*if (sentencia != null) {
                sentencia.close();
               

            }
            if (conn != null) {
                conn.close();
              
            }*/

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo finalizar la conexion" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                if (cdr != null) {
                    cdr.close();
                   

                }
                if (sentencia != null) {
                    sentencia.close();
                   

                }
                if (conn != null) {
                    conn.close();
                    

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
