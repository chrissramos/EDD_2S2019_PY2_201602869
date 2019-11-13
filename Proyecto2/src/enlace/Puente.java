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
       //JOptionPane.showMessageDialog(null, "se agregara: " + user + ","+ pass);
       String[] data = new String[2];
       data[0] = user;
           
       if(cuantos>0 &&repetido(user) ){
           JOptionPane.showMessageDialog(null, "Usuario repetido: " + user);
           data[1]= "Usuario repetido";
           a.modeloI.addRow(data);
           
       }else{
       data[1]= pass;
       a.modeloC.addRow(data);
       int suma = 0;
       int tamanio = user.length();
        for (int i = 0; i < tamanio; i++) {
            char character = user.charAt(i);
            int ascii = (int) character;
            suma  = suma + ascii;
        }
        //ver tamanio de hash si llega al 75 por ciento, aumentar
        //JOptionPane.showMessageDialog(null, "porcentaje actual: "+ porcentaje);
        if((int)porcentaje > 75){
            System.out.println("porcentaje mayor");
            int limite = contador + 100;
            for (int i = contador+1; i < limite; i++) {
              if(getPrimo(i) == true){
                  contador = i;
                  break;
              }                  
            }
            JOptionPane.showMessageDialog(null, "Nuevo tamanio: " + contador);
            Hash[] aux = tablaH;
            
            tablaH = new Hash[contador];
            for (int i = 0; i < aux.length; i++) {
                tablaH[i] = aux[i];
            }
        }
        
       //System.out.println("contador: " + contador);
        int posicionH = suma % contador;
        //System.out.println("posicionH: " + posicionH);
        
        
        //verificar colision
        if(tablaH[posicionH]== null ){ // posicion vacia, insertar directamente
            Hash h = new Hash();
            NodoLista nodo = new NodoLista();
            nodo.setNombreUsuario(user);
            nodo.setPassUsuario(pass);
            //fecha
            Date d = new Date();
            String fecha =d.toString();
            //System.out.println("Fecha: " + fecha);
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
            //System.out.println("info: " + h.getTamanio());
            //creando nodo a insertar
            NodoLista nodo = new NodoLista();
            nodo.setNombreUsuario(user);
            nodo.setPassUsuario(pass);
            
            //fecha
            Date d = new Date();
            String fecha =d.toString();
            //System.out.println("Fecha: " + fecha);
            nodo.setTimeStamp(fecha);
            h.getLista().add(nodo);
            cuantos++;
            float resultado = (cuantos * 100)/contador;
            porcentaje = resultado;
            System.out.println("porcentaje: " + resultado);
            //obtener lista ya creada con anterioridad e insertar 
            //ListaEnlazada l2 = new ListaEnlazada(); 
            //l2 = h.getLista();
            //l2.add(nodo);
            //System.out.println("tamanio en lista de ese indice: " + l2.getTamanio());
                  
        }
       }
       
         
        //graficarHash();
    }
    
    public static boolean repetido(String user){
        //true que si es repetido
        boolean bandera = true;
        
        for (int i = 0; i < contador; i++) {
            if(tablaH[i]!=null){ // si hay valor
                Hash h = tablaH[i];
                ListaEnlazada l = h.getLista();
                NodoLista aux = l.inicio;
                while(aux!=null){
                    String usuarioActual = aux.getNombreUsuario();
                    if(usuarioActual.equals(user)){
                        System.out.println("Usuario Repetido:" + user + " en indice: " + i);
                        bandera = true;
                    }else{
                        bandera = false;
                    }
                    aux = aux.getSiguiente();
                }
            }
            
            
        }
        System.out.println("retornando: " + bandera);
        return bandera;
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
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("src/reportes/graficaHash.dot");
            escritor = new PrintWriter(fichero);
            //ver aqui
            escritor.print(getCodigoGraphvizHash());
            //
        
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo graficaHash.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo graficaHash.dot");
           } 
        }
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tjpg -o "+"src/reportes/graficaHash.jpg"+" src/reportes/graficaHash.dot");
          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varios
          //árboles sucesivamente.
          //Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }
    private static String getCodigoGraphvizHash() {
        return "digraph grafica{\n" +
               "rankdir=LR;\n" +
               "node [shape = record, style=filled, fillcolor=seashell2];\n"+
                getCodigoInternoH()+
                "}\n";
    }
    public static String getCodigoInternoH(){
        String etiqueta = "";
        for (int i = 0; i <contador; i++) {
            if(tablaH[i]!=null){ // si hay valor
                Hash h = tablaH[i];
                String conta = "nodo"+i;
                ListaEnlazada l = h.getLista();
                NodoLista aux = l.inicio;
                etiqueta+= i+"[label = \"" +i + ") \"]; \n";
                etiqueta+= i+"->" + aux.getNombreUsuario() + ";\n" ;
                //etiqueta += aux.getNombreUsuario();
                while(aux!=null){
                    //if(aux.getSiguiente()!=null){
                      // etiqueta+= "->"+ aux.getSiguiente().getNombreUsuario() + ";\n ";
                   // }
                    
                    String contenido;
                    //etiqueta+= aux.getNombreUsuario();
                    etiqueta+= " "+aux.getNombreUsuario()+"[label = \"" +aux.getNombreUsuario() + " \"] \n";
                    if(aux.getSiguiente()!=null){
                        etiqueta+=aux.getNombreUsuario() +"->" + aux.getSiguiente().getNombreUsuario() + ";\n";
                    }
                    //etiqueta+=i+"->"+aux.getNombreUsuario();
                    aux = aux.getSiguiente();  
                }
            }
            else{
                etiqueta+= i+"[label = \"" +i + ") \"] \n";
            }
        }
        return etiqueta;
    }
    
    
    
}
