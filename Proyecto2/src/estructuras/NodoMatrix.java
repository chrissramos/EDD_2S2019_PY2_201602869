/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author Chriss Ramos
 */
public class NodoMatrix {
    String nombreCarpeta;
    AVLB arbol;
    NodoMatrix arriba;
    NodoMatrix abajo;
    NodoMatrix derecha;
    NodoMatrix izquierda;    
    int grupo;
    static int correlativo = 0;
    public NodoMatrix() {
        
    }
    
    public NodoMatrix(String nombreCarpeta, AVLB arbol){
        this.nombreCarpeta = nombreCarpeta;
        this.arbol = arbol;
        grupo = correlativo++;
        this.arriba = null;
        this.abajo = null;
        this.derecha = null;
        this.izquierda = null;
    }
    
}
