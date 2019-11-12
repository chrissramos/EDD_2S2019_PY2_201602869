/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import javafx.scene.input.KeyCode;

/**
 *
 * @author Chriss Ramos
 */
public class AVL {
    public NodoAVL root;
    
    int altura(NodoAVL n){
        if(n == null){
            return 0;
            
        }
        return n.altura;
    }
    
    int max(int a, int b){
        return (a>b)? a:b;
    }
    
    NodoAVL rightRotate(NodoAVL y){
        NodoAVL x = y.izquierda;
        NodoAVL t2 = x.derecha;
        
        x.derecha = y;
        y.izquierda = t2;
        
        y.altura = max(altura(y.izquierda), altura(y.derecha)) +1;
        x.altura = max(altura(x.izquierda), altura(x.derecha)) +1;
        
        return x;
    }
    
    NodoAVL leftRotate(NodoAVL x) { 
        NodoAVL y = x.derecha; 
        NodoAVL T2 = y.izquierda; 
  
        // Perform rotation 
        y.izquierda = x; 
        x.derecha = T2; 
  
        //  Update heights 
        x.altura = max(altura(x.izquierda), altura(x.derecha)) + 1; 
        y.altura = max(altura(y.izquierda), altura(y.derecha)) + 1; 
  
        // Return new root 
        return y; 
    }
    
    int getBalance(NodoAVL n){
        if(n == null){
            return 0;
        }
        return altura(n.izquierda)- altura(n.derecha);
    }
    
    
    
    public NodoAVL insert(NodoAVL nodo, String nombre, String extension, String contenido, String timestamp ){
        if(nodo == null){
            return(new NodoAVL(nombre, extension, contenido, timestamp, null, null, 0));
        }
        if(nombre.compareTo(nodo.nombreA) >0){//menor
            nodo.izquierda = insert(nodo.izquierda, nombre, extension, contenido, timestamp);
            
        }
        else if(nombre.compareTo(nodo.nombreA) <0){
            nodo.derecha = insert(nodo.derecha, nombre, extension, contenido, timestamp);
        }
        else{
            return nodo;
        }
        
        nodo.altura = 1+max(altura(nodo.izquierda), altura(nodo.derecha));
        
        int balance = getBalance(nodo);
        
        if(balance >1 && nombre.compareTo(nodo.izquierda.nombreA) > 0){
            return rightRotate(nodo);
        }
        
        if(balance < -1 && nombre.compareTo(nodo.derecha.nombreA) < 0){
            return leftRotate(nodo);
        }
        
        if(balance >1 && nombre.compareTo(nodo.izquierda.nombreA) < 0 ){
            nodo.izquierda = leftRotate(nodo.izquierda);
            return rightRotate(nodo);
        }
        if(balance <-1 &&nombre.compareTo(nodo.derecha.nombreA) > 0 ){
            nodo.derecha = rightRotate(nodo.derecha);
            return leftRotate(nodo);
        }
        
        return nodo;
    }
    
    public void preOrder(NodoAVL node) { 
        if (node != null) { 
            System.out.print(node.nombreA + " ");
            
            preOrder(node.izquierda); 
            preOrder(node.derecha); 
        } 
    }
    
    public void inOrder(NodoAVL node) { 
        if (node != null) { 
            System.out.print(node.nombreA + " ");
            
            preOrder(node.izquierda); 
            preOrder(node.derecha); 
        } 
    }
    
}
