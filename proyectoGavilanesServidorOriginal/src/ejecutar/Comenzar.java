/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecutar;

import controlador.ControladorAcceso;
import modelo.ModeloAcceso;
import vista.VistaAcceso;

/**
 *
 * @author José Manuel ESTE ES EL SISTEMA DE LA MAQUINA SERVIDOR
 */
public class Comenzar {

    public static void main(String[] args) {
        VistaAcceso v = new VistaAcceso();
        ModeloAcceso m = new ModeloAcceso();
        ControladorAcceso c = new ControladorAcceso(v, m);
        v.setVisible(true);
    }

}
