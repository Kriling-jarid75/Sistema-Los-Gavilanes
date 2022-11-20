/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBD;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ModeloPrincipal {
    private int cargo;

    public ModeloPrincipal() {
        
    }
   
   public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public ModeloPrincipal(int cargo) {
       this.cargo = cargo; 
    }
    
    public ResultSet obtenerPermisos(int cargo){
         ConexionBD objCBD = new ConexionBD();
        ArrayList instruccionBD = new ArrayList();
        instruccionBD.add("{CALL sp_Cargos(?)}");
        instruccionBD.add(cargo);
        objCBD.ejecutarConsulta(instruccionBD);
        ResultSet cdr = objCBD.getCdr();
        objCBD.cerrarConexion();
        
        return cdr;
        
        
    } 
}
