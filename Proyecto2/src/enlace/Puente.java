/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enlace;

import estructuras.Hash;
import estructuras.ListaEnlazada;
import estructuras.NodoLista;
import grafico.Administrador;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Chriss Ramos
 */
public class Puente {
    public static Hash[] tablaH = new Hash[7];
    
    public static Administrador a = new Administrador();
    public static int contador ;
    public static int porcentaje;
    
    //agregar en esta clase los metodos
    public static void agregar(String user, String pass){
        //aqui se agrega a la hash  codificar el nombre de usuario 
        //obtener valor entero de usuario
       JOptionPane.showMessageDialog(null, "se agregara: " + user + ","+ pass);
       int suma = 0;
       int tamanio = user.length();
        for (int i = 0; i < tamanio; i++) {
            char character = user.charAt(i);
            int ascii = (int) character;
            suma  = suma + ascii;
        }
        System.out.println("contador: " + contador);
        int posicionH = suma % contador;
        System.out.println("posicionH: " + posicionH);
        //verificar colision
        if(tablaH[posicionH]== null ){ // posicion vacia, insertar directamente
            Hash h = new Hash();
            NodoLista nodo = new NodoLista();
            nodo.setNombreUsuario(user);
            nodo.setPassUsuario(pass);
            //fecha
            Date d = new Date();
            String fecha =d.toString();
            System.out.println("Fecha: " + fecha);
            nodo.setTimeStamp(fecha);
            
            // insertando en la lista de ese indice de la hash
            ListaEnlazada l = new ListaEnlazada();
            l.add(nodo);
            
            
        }else{ // si hay colision /, buscar indice y obtener lista e insertar siguiente nodo
            
        }
         
    }
    public int tamanioHash(){
        int tamanio = 0;
        
        return tamanio;
    }
}
