/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enlace;

import estructuras.Hash;
import grafico.Administrador;
import javax.swing.JOptionPane;

/**
 *
 * @author Chriss Ramos
 */
public class Puente {
    public static Hash[] tablaH = new Hash[7];
    public static Administrador a = new Administrador();
    int contador = 0;
    //agregar en esta clase los metodos
    public static void agregar(String user, String pass){
        JOptionPane.showMessageDialog(null, "se agregara: " + user + ","+ pass);
         
    }
}
