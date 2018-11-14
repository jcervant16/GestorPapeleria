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
public class ProductoEstudiantil extends Producto {
    private String marca; 
    private String nombre;
    private int cantidades;
    private String codigo;
  
    public ProductoEstudiantil(int precio,String marca,String nombre, int cantidades,String codigo){
     super(precio);
       this.marca = marca;
       this.nombre = nombre;
       this.cantidades = cantidades;
       this.codigo = codigo;
       
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidades() {
        return cantidades;
    }

    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
