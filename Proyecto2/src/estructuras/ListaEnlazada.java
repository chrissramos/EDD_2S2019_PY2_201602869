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
public class ListaEnlazada {
    NodoLista inicio;
    NodoLista ultimo;
    int tamanio;
    
    public void ListaEnlazada(){
        this.inicio = null;
        this.ultimo = null;
        this.tamanio = 0;
                
    }
    
    public boolean vacia(){
        return inicio == null;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void add(NodoLista nodo){
        if(vacia()){
            inicio = nodo;
            
        }else{
            NodoLista aux = inicio;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
            
        }
        tamanio++;
    }
    
    
}
