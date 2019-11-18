/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import enlace.Puente;
import grafico.Login;
import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import estructuras.*;

/**
 *
 * @author Chriss Ramos
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      /*  AVLB arbol = new AVLB();
        arbol.insertar(new NodoAVLB("juan", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("pedro", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("maria", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("roberto", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("teodoro", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("manuel", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("diego", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("alejandro", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("margarita", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("luis", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("hernan", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("jaime", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("ana", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("francisco", "txt", "asdsad", "12/12/12"));
        arbol.insertar(new NodoAVLB("andrea", "txt", "asdsad", "12/12/12"));
        
        
        
        arbol.inorden();
        arbol.graficar("arbol.jpg");*/
        // TODO code application logic here
        
        try    {
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
          }   catch (Exception e)    {
            e.printStackTrace();
          }
        
            Login v = new Login();
            v.setTitle("EDD DRIVE");
            Puente.contador = 7;
            Puente.porcentaje = 0;
            Puente.cuantos = 0;
            v.setVisible(true);
        
        }
        
        
    
    
}
