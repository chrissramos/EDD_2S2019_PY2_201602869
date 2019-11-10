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
public class Hash {
    
    int indice;
    ListaEnlazada lista;
    int tamanio;

    public Hash(int indice, ListaEnlazada lista, int tamanio) {
        this.indice = indice;
        this.lista = lista;
        this.tamanio = tamanio;
    }

    public Hash() {
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public ListaEnlazada getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada lista) {
        this.lista = lista;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

  
    
}
