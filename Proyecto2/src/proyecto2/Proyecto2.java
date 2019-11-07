/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import enlace.Puente;
import grafico.Login;

/**
 *
 * @author Chriss Ramos
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login v = new Login();
        v.setTitle("EDD DRIVE");
        Puente.contador = 7;
        Puente.porcentaje = 0;
        Puente.cuantos = 0;
        v.setVisible(true);
    }
    
}
