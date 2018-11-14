/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author ESTUDIANTE
 */
public class Ganancia implements java.io.Serializable {

    private int compra;
 

    public Ganancia(int compra) {
        this.compra = compra;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public void escribir(ObjectOutputStream salida) throws IOException {
        salida.writeObject(this);

    }
}
