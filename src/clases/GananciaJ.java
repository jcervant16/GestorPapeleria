/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author ESTUDIANTE
 */
public class GananciaJ extends Ganancia {

    private int gasto;

    public GananciaJ(int compra, int gasto) {
        super(compra);
        this.gasto = gasto;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }
    public int total (){
        int r;
        r = this.getCompra()-this.getGasto();
        return r;
    }

}
