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
public class AVLB {
    private NodoAVLB raiz;
    
    public AVLB() {
        raiz=null;
    }
    
    public void graficar(String path){
        raiz.graficar(path);
    }
    
    public void insertar(NodoAVLB nodo){
        raiz = insertar(nodo, raiz);
    }
    
    private NodoAVLB insertar(NodoAVLB nodo, NodoAVLB raiz){
        if(raiz == null){
            raiz = nodo;
        }else if(nodo.nombreA.compareTo(raiz.nombreA)< 0){
            raiz.izquierdo = insertar(nodo, raiz.izquierdo);
            if(altura(raiz.derecho)-altura(raiz.izquierdo)==-2){
                if(nodo.nombreA.compareTo(raiz.izquierdo.nombreA)<0){
                    raiz = izquierdaIzquierda(raiz);
                }else{
                    raiz = izquierdaDerecha(raiz);
                }
                
            }
        }else if(nodo.nombreA.compareTo(raiz.nombreA)> 0){
            raiz.derecho = insertar(nodo, raiz.derecho);
            if(altura(raiz.derecho)-altura(raiz.izquierdo)==2){
                if(nodo.nombreA.compareTo(raiz.derecho.nombreA)>0){
                   raiz = derechaDerecha(raiz);
                }else{
                    raiz = derechaIzquierda(raiz);
                }
            }
        }else{
            System.out.println("no se permiten valores duplicados");
        }
        raiz.altura = mayor(altura(raiz.izquierdo), altura(raiz.derecho))+1;
        return raiz;
    }
    
    private int altura(NodoAVLB nodo){
        if(nodo == null){
            return -1;
        }else{
            return nodo.altura;
        }
    }
    
    
    private int mayor(int n1, int n2){
        if(n1 > n2)
            return n1;
        return n2;
    }
    
    //rotaciones
    private NodoAVLB izquierdaIzquierda(NodoAVLB n1){
        NodoAVLB n2 = n1.izquierdo;
        n1.izquierdo = n2.derecho;
        n2.derecho = n1;
        n1.altura = mayor(altura(n1.izquierdo), altura(n1.derecho))+1;
        n2.altura = mayor(altura(n2.izquierdo), n1.altura)+1;
        return n2; 
    }
    private NodoAVLB derechaDerecha(NodoAVLB n1){
        NodoAVLB n2 = n1.derecho;
        n1.derecho = n2.izquierdo;
        n2.izquierdo = n1;
        n1.altura = mayor(altura(n1.izquierdo), altura(n1.derecho))+1;
        n2.altura = mayor(altura(n2.derecho), n1.altura)+1;
        return n2;
    }
    private NodoAVLB izquierdaDerecha(NodoAVLB n1){
        n1.izquierdo = derechaDerecha(n1.izquierdo);
        return izquierdaIzquierda(n1);
        
    }
    private NodoAVLB derechaIzquierda(NodoAVLB n1){
        n1.derecho = izquierdaIzquierda(n1.derecho);
        return derechaDerecha(n1);
    }
    public void inorden(){
        System.out.println("Recorrido inorden del árbol binario de búsqueda:");
        inorden(raiz);
        System.out.println();
    }
    
    private void inorden(NodoAVLB a){
        if(a==null)
            return;
        inorden(a.izquierdo);
        System.out.print(a.nombreA+",");
        inorden(a.derecho);
    }

}
