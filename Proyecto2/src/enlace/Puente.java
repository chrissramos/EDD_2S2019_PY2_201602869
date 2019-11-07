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
    public static int contador ; // posiciones totales de la hash
    public static float porcentaje; // porcentaje de ocupado
    public static int cuantos; // cuantos registrios tiene la hash
    
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
            h.setTamanio(1);
            // insertando en la lista de ese indice de la hash
            ListaEnlazada l = new ListaEnlazada();
            l.add(nodo);
            h.setLista(l);
            //agregando objeto hash a tabla hash
            tablaH[posicionH] = h;
            //hacer el porcentaje
            cuantos++;
            float resultado = (cuantos * 100)/contador;
            System.out.println("porcentaje: " + resultado);
        }else{ // si hay colision /, buscar indice y obtener lista e insertar siguiente nodo
            //obtener objeto y lista de esa posicion de la hash
            Hash h = new Hash();
            h = tablaH[posicionH];
            System.out.println("info: " + h.getTamanio());
            //creando nodo a insertar
            NodoLista nodo = new NodoLista();
            nodo.setNombreUsuario(user);
            nodo.setPassUsuario(pass);
            //fecha
            Date d = new Date();
            String fecha =d.toString();
            System.out.println("Fecha: " + fecha);
            nodo.setTimeStamp(fecha);
            h.getLista().add(nodo);
            cuantos++;
            float resultado = (cuantos * 100)/contador;
            System.out.println("porcentaje: " + resultado);
            //obtener lista ya creada con anterioridad e insertar 
            //ListaEnlazada l2 = new ListaEnlazada(); 
            //l2 = h.getLista();
            //l2.add(nodo);
            //System.out.println("tamanio en lista de ese indice: " + l2.getTamanio());
                  
        }
         
    }
    public int tamanioHash(){
        int tamanio = 0;
        
        return tamanio;
    }
}
