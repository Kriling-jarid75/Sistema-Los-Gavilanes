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
public class ModeloAcceso {
    private String usuario;
    private String psw;
    private int cargo;
   
   public void setPsw(String psw){
       this.psw = psw;
   }
   public void setUsuario(String usuario){
       this.usuario = usuario;
   }
   public int getCargo(){
       return cargo;
   }
   
   public void validarUsuario(){
         ConexionBD objCBD = new ConexionBD();
       ArrayList instruccionBD = new ArrayList();
       instruccionBD.add("{CALL sp_Acceder(?,?)}");
       instruccionBD.add(usuario);
       instruccionBD.add(psw);
       
     
       objCBD.ejecutarConsulta(instruccionBD);
       ResultSet cdr = objCBD.getCdr();
       
           try {
               while(cdr.next()){
                  if(usuario.equals(cdr.getString(4))&& psw.equals(cdr.getString(5))){
                    cargo=cdr.getInt(3);
                    
                  } 
               }
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "La consulta no se ha podido ejecutar","ERROR",JOptionPane.ERROR_MESSAGE);
          }finally {

            objCBD.cerrarConexion();
        }
       }  
       
}
