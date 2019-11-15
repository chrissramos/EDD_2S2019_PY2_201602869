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
public class Archivo {
    String nombre;
    String contenido;
    String extension;
    String timestamp;

    public Archivo() {
    }

    public Archivo(String nombre, String contenido, String extension, String timestamp) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.extension = extension;
        this.timestamp = timestamp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
}
