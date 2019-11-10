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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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
        
        //ver tamanio de hash si llega al 75 por ciento, aumentar
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
            porcentaje = resultado;
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
         
        graficarHash();
    }
    public int tamanioHash(){
        int tamanio = 0;
        
        return tamanio;
    }
    
    public static boolean getPrimo(int numero){
        int contador2 = 2;
        boolean primo=true;
        while ((primo) && (contador2!=numero)){
          if (numero % contador2 == 0)
            primo = false;
          contador2++;
        }
        return primo;
        
    }
    
    public static void graficarHash(){
        try {
            String ruta = "C:\\Users\\Chriss Ramos\\Desktop\\Entradasp2\\Dots\\Hash.dot";
            //String img = "C:\\Users\\Chriss Ramos\\Desktop\\Entradasp2\\Dots\\Hash.png";
            
            File file = new File(ruta);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("digraph G {");
            pw.println("node[shape=rectangle];\n");
            pw.println("rankdir = RL;\n");
            
            for (int i = 0; i < contador ; i++) {
                pw.println(i+"[label = \"" +i + ") \"] \n");
            }
            pw.println("}");
            pw.close();
            bw.close();
            
            //String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            //String cmd = dotPath + " -Tjpg " + ruta + " -o "+ img;
            //String aber = "dot -Tpng Hash.dot -o Hash.png";
            //System.out.println(cmd);
            ///Runtime.getRuntime().exec("cd C:\\Users\\Chriss Ramos\\Desktop\\Entradasp2\\Dots");
            //Runtime.getRuntime().exec(aber);
            //Runtime.getRuntime().exec(cmd);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
