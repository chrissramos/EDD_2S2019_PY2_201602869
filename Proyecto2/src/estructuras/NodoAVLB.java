/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Chriss Ramos
 */
public class NodoAVLB {
    NodoAVLB izquierdo;
    NodoAVLB derecho;
    int altura;
    private static int correlativo=1;
    private final int id;    
    String nombreA;
    String extenseion;
    String contenido;
    String timestamp;
    
    public NodoAVLB(String nombreA, String extenseion, String contenido, String timestamp) {
        this.id = correlativo++;
        this.nombreA = nombreA;
        this.extenseion = extenseion;
        this.contenido = contenido;
        this.timestamp = timestamp;
    }
    
    public void graficar(){
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("src/reportes/avl.dot");
            escritor = new PrintWriter(fichero);
            //ver aqui
            escritor.print(getCodigoGraphviz());
            //
        
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo avl.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo avl.dot");
           } 
        }
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tjpg -o "+"src/reportes/graficaAVL.jpg"+" src/reportes/avl.dot");
          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varios
          //árboles sucesivamente.
          Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }
    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
               "rankdir=TB;\n" +
               "node [shape = record, style=filled, fillcolor=seashell2];\n"+
                getCodigoInterno()+
                "}\n";
    }
    
    private String getCodigoInterno() {
        String etiqueta;
        if(izquierdo==null && derecho==null){
            etiqueta="nodo"+id+" [ label =\""+this.nombreA+"\"];\n";
        }else{
            etiqueta="nodo"+id+" [ label =\"<C0>|"+this.nombreA+"|<C1>\"];\n";
        }
        if(izquierdo!=null){
            etiqueta=etiqueta + izquierdo.getCodigoInterno() +
               "nodo"+id+":C0->nodo"+izquierdo.id+"\n";
        }
        if(derecho!=null){
            etiqueta=etiqueta + derecho.getCodigoInterno() +
               "nodo"+id+":C1->nodo"+derecho.id+"\n";                    
        }
        return etiqueta;
    }
    
}
