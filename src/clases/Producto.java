/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author ESTUDIANTE
 */
public class Producto implements java.io.Serializable {

    private int precio;

    public Producto(int precio) {
        this.precio = precio;

    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void escribir(ObjectOutputStream salida) throws IOException {
        salida.writeObject(this);
    }

}
