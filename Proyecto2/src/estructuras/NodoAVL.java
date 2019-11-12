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
public class NodoAVL {
    String nombreA;
    String extenseion;
    String contenido;
    String timestamp;
    int altura;
    
    
    NodoAVL derecha;
    NodoAVL izquierda;

    public NodoAVL(String nombreA, String extenseion, String contenido, String timestamp, NodoAVL derecha, NodoAVL izquierda, int altura) {
        this.nombreA = nombreA;
        this.extenseion = extenseion;
        this.contenido = contenido;
        this.timestamp = timestamp;
        this.derecha = derecha;
        this.izquierda = izquierda;
        this.altura = altura;
    }
    
    public NodoAVL(){}

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getExtenseion() {
        return extenseion;
    }

    public void setExtenseion(String extenseion) {
        this.extenseion = extenseion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public NodoAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL derecha) {
        this.derecha = derecha;
    }

    public NodoAVL getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}
