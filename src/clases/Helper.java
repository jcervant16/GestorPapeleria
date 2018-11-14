/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ESTUDIANTE
 */
public class Helper {

    public static void limpiadoTabla(JTable tabla1) {
        int nf, nc;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                tabla1.setValueAt("", i, j);
            }
        }
    }

    public static void limpiarTablaCompra(JTable tabla1) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla1.getModel();
        limpiadoTabla(tabla1);
        tm.setRowCount(0);
        tm.setColumnCount(6);

    }

    public static void llenarTabla(JTable tabla, String ruta) {
        DefaultTableModel tm;
        int nf;
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = productos.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(productos.get(i).getPrecio(), i, 3);
            tabla.setValueAt(productos.get(i).getMarca(), i, 2);
            tabla.setValueAt(productos.get(i).getNombre(), i, 1);
            tabla.setValueAt(productos.get(i).getCantidades(), i, 4);
            tabla.setValueAt(productos.get(i).getCodigo(), i, 5);

        }
    }

    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);

        }
    }

    public static void llenarTabla(JTable tabla, ArrayList<ProductoEstudiantil> productos) {
        DefaultTableModel tm;
        int nf;
        tm = (DefaultTableModel) tabla.getModel();
        limpiadoTabla(tabla);
        nf = productos.size();
        tm.setRowCount(nf);
        for (int i = 0; i < nf; i++) {
            tabla.setValueAt(i + 1, i, 0);
            tabla.setValueAt(productos.get(i).getPrecio(), i, 3);
            tabla.setValueAt(productos.get(i).getMarca(), i, 2);
            tabla.setValueAt(productos.get(i).getNombre(), i, 1);
            tabla.setValueAt(productos.get(i).getCantidades(), i, 4);
            tabla.setValueAt(productos.get(i).getCodigo(), i, 5);

        }
    }

    public static ArrayList traerDatos(String ruta) {
        FileInputStream archivo;
        ObjectInputStream entrada;
        ArrayList personas = new ArrayList();
        Object p;

        try {
            archivo = new FileInputStream(ruta);
            entrada = new ObjectInputStream(archivo);
            while ((p = entrada.readObject()) != null) {
                personas.add(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return personas;
    }

    public static void volcado(ObjectOutputStream salida, ArrayList productos) {
        for (int i = 0; i < productos.size(); i++) {
            try {
                salida.writeObject(productos.get(i));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public static void listadoPorNombre(JTable tabla, String ruta, String nombre) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        ArrayList<ProductoEstudiantil> productosfiltrados = new ArrayList();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                productosfiltrados.add(productos.get(i));
            }

        }
        llenarTabla(tabla, productosfiltrados);

    }

    public static void listadoPorMarca(JTable tabla, String ruta, String marca) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        ArrayList<ProductoEstudiantil> productosfiltrados = new ArrayList();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getMarca().equals(marca)) {
                productosfiltrados.add(productos.get(i));
            }

        }
        llenarTabla(tabla, productosfiltrados);

    }

    public static boolean buscarProductoCodigo(String codigo, String ruta) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public static ProductoEstudiantil traerProductoCodigo(String codigo, String ruta) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                return productos.get(i);
            }

        }
        return null;
    }

    public static ArrayList<ProductoEstudiantil> modificarProducto(String ruta, int precio, String marca, String nombre, int cantidades, String codigo) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productos.get(i).setNombre(nombre);
                productos.get(i).setMarca(marca);
                productos.get(i).setPrecio(precio);
                productos.get(i).setCantidades(cantidades);

                return productos;
            }

        }
        return null;
    }

    public static void mensaje(Component ventana, String mensaje, int tipo) {
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(ventana, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;

        }
    }

    public static void llenarComboMarca(JComboBox combo, String ruta) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) combo.getModel();
        dcbm.removeAllElements();
        ProductoEstudiantil p;
        for (int i = 0; i < productos.size(); i++) {
            p = productos.get(i);
            dcbm.addElement(p.getMarca());
        }
    }

    public static void llenarComboNombre(JComboBox combo, String ruta) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) combo.getModel();
        dcbm.removeAllElements();
        ProductoEstudiantil p;
        for (int i = 0; i < productos.size(); i++) {
            p = productos.get(i);
            dcbm.addElement(p.getNombre());
        }
    }

    public static int cantidadPorMarca(String ruta, String marca) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        int aux = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getMarca().equals(marca)) {
                aux = aux+1;
            }

        }
        return aux;

    }
      public static int cantidadPorNombre(String ruta, String nombre) {
        ArrayList<ProductoEstudiantil> productos = traerDatos(ruta);
        int aux = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                aux = aux+1;
            }

        }
        return aux;

    }

}
