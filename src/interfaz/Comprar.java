/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import clases.Ganancia;
import clases.Helper;
import clases.Producto;
import clases.ProductoEstudiantil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Comprar extends javax.swing.JDialog {

    /**
     * Creates new form Comprar
     */
    public Comprar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ruta = "src/datos/productos.txt";
        ruta1 = "src/datos/productos2.txt";
        ruta2 = "src/datos/ganancias.txt";
        rutaco = "src/datos/productoscomprados.txt";

        try {
            productos = Helper.traerDatos(ruta);
            productosac = Helper.traerDatos(ruta1);
            ganancia = Helper.traerDatos(ruta2);
            productoscomprados = Helper.traerDatos(rutaco);
            salida = new ObjectOutputStream(new FileOutputStream(ruta));
            salida1 = new ObjectOutputStream(new FileOutputStream(ruta1));
            salida2 = new ObjectOutputStream(new FileOutputStream(ruta2));
            salidaco = new ObjectOutputStream(new FileOutputStream(rutaco));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Helper.volcado(salida, productos);
        Helper.llenarTabla(tblLista, ruta);
        Helper.volcado(salida1, productosac);
        Helper.llenarTabla(tblCompra, ruta1);
        Helper.volcado(salida2, ganancia);
        cmdEliminar.setEnabled(false);
        cmdBorrar.setEnabled(false);
        cmdAgregar.setEnabled(false);

    }

    String ruta, ruta1, ruta2, rutaco;
    ObjectOutputStream salida, salida1, salida2, salidaco;
    ArrayList<ProductoEstudiantil> productos;
    ArrayList<ProductoEstudiantil> productosac = new ArrayList();
    int aux = 0;
    ArrayList<Ganancia> ganancia;
    ArrayList<ProductoEstudiantil> productoscomprados;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmdComprar = new javax.swing.JButton();
        cmdSalir = new javax.swing.JButton();
        cmdAgregar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidades = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cmdEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        cmdBuscar = new javax.swing.JButton();
        cmdGananciasActuales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Compra");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 300));

        cmdComprar.setBackground(new java.awt.Color(153, 255, 153));
        cmdComprar.setText("Comprar");
        cmdComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdComprarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 190, 100, 30));

        cmdSalir.setBackground(new java.awt.Color(255, 51, 51));
        cmdSalir.setText("Salir");
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });
        jPanel1.add(cmdSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 110, 40));

        cmdAgregar.setBackground(new java.awt.Color(153, 255, 153));
        cmdAgregar.setText("Agregar al carrito");
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, 40));

        cmdBorrar.setBackground(new java.awt.Color(255, 51, 51));
        cmdBorrar.setText("Borrar");
        cmdBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, 100, 30));

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nombre", "Marca", "Precio", "Cantidad", "Codigo ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCompra);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 420, 310));

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nombre", "Marca", "Precio", "Cantidades disponibles", "Codigo ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLista.setFocusable(false);
        tblLista.setGridColor(new java.awt.Color(51, 51, 51));
        tblLista.setOpaque(false);
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLista);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 420, 310));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setEditable(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 72, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Marca");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        txtMarca.setEditable(false);
        jPanel3.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 70, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Precio");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        txtPrecio.setEditable(false);
        jPanel3.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 90, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Cantidades");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtCantidades.setEditable(false);
        jPanel3.add(txtCantidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 90, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Codigo ID");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        txtCodigo.setEditable(false);
        jPanel3.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 90, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 570, 120));

        cmdEliminar.setBackground(new java.awt.Color(255, 51, 51));
        cmdEliminar.setText("Eliminar");
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 120, 40));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Buscar productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Codigo");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));
        jPanel4.add(txtCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, -1));

        cmdBuscar.setBackground(new java.awt.Color(153, 204, 255));
        cmdBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(cmdBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 50, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 140, 160));

        cmdGananciasActuales.setText("Mostrar ganancias actuales");
        cmdGananciasActuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGananciasActualesActionPerformed(evt);
            }
        });
        jPanel1.add(cmdGananciasActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 220, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1187, 596));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked
        int i = tblLista.getSelectedRow();
        ProductoEstudiantil p;
        ArrayList<ProductoEstudiantil> productos = Helper.traerDatos(ruta);
        p = productos.get(i);

        cmdAgregar.setEnabled(true);

        txtMarca.setText(p.getMarca());
        txtNombre.setText(p.getNombre());
        txtPrecio.setText("" + p.getPrecio());
        txtCantidades.setText("" + p.getCantidades());
        txtCodigo.setText(p.getCodigo());
        cmdAgregar.setEnabled(true);
        cmdEliminar.setEnabled(true);
        cmdBorrar.setEnabled(true);


    }//GEN-LAST:event_tblListaMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        int i, op;
        op = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar a este producto?", "Eliminar", JOptionPane.YES_NO_OPTION);
        ArrayList<ProductoEstudiantil> productos = Helper.traerDatos(ruta);
        ArrayList<ProductoEstudiantil> productos2 = Helper.traerDatos(ruta1);
        ProductoEstudiantil p, pc;
        if (op == JOptionPane.YES_OPTION) {
            i = tblCompra.getSelectedRow();
            pc = productos2.get(i);
            p = productos.get(i);
            for (int j = 0; j < productos.size(); j++) {
                p = productos.get(j);
                if (p.getCodigo().equals(pc.getCodigo())) {
                    aux = p.getCantidades() + pc.getCantidades();
                    p.setCantidades(aux);
                }
            }
            productos2.remove(i);
            try {
                salida = new ObjectOutputStream(new FileOutputStream(ruta));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                salida1 = new ObjectOutputStream(new FileOutputStream(ruta1));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
            }

            Helper.volcado(salida, productos);
            Helper.llenarTabla(tblLista, ruta);
            Helper.volcado(salida1, productos2);
            Helper.llenarTabla(tblCompra, ruta1);
            cmdEliminar.setEnabled(false);
            cmdBorrar.setEnabled(false);

        }

    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdSalirActionPerformed

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        int i, op;
        op = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar a este producto?", "Eliminar", JOptionPane.YES_NO_OPTION);

        ArrayList<Producto> productos = Helper.traerDatos(ruta);
        if (op == JOptionPane.YES_OPTION) {

            i = tblLista.getSelectedRow();
            productos.remove(i);
            try {
                salida = new ObjectOutputStream(new FileOutputStream(ruta));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            Helper.volcado(salida, productos);
            Helper.llenarTabla(tblLista, ruta);
        }
        txtMarca.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidades.setText("");
        txtCodigo.setText("");
        cmdEliminar.setEnabled(false);
        cmdBorrar.setEnabled(false);

    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        String codigo;
        productos = Helper.traerDatos(ruta);
        if (txtCodigo1.getText().isEmpty()) {
            Helper.mensaje(this, "Digite un codigo", 3);
        } else {
            codigo = txtCodigo1.getText();
            for (int i = 0; i < productos.size(); i++) {

            }
            ProductoEstudiantil p;
            if (Helper.buscarProductoCodigo(codigo, ruta)) {
                p = Helper.traerProductoCodigo(codigo, ruta);
                txtNombre.setText(p.getNombre());
                txtMarca.setText(p.getMarca());
                txtPrecio.setText("" + p.getPrecio());
                txtCantidades.setText("" + p.getCantidades());
                txtCodigo.setText(p.getCodigo());
                aux = 1;

            } else {
                aux = 0;
                JOptionPane.showMessageDialog(this, "No existe ningún producto con este código", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            }
            cmdAgregar.setEnabled(false);
            cmdEliminar.setEnabled(false);
            cmdBorrar.setEnabled(false);

        }
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void cmdComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdComprarActionPerformed
        int compra = 1, aux = 0, cant, prec;
        ProductoEstudiantil p;
        Ganancia g;
        ProductoEstudiantil pc, au;
        int precio, cantidades;
        String marca, nombre, codigo;
        ArrayList<ProductoEstudiantil> productos = Helper.traerDatos(ruta1);
        for (int i = 0; i < productos.size(); i++) {
            p = productos.get(i);
            cant = p.getCantidades();
            prec = p.getPrecio();
            compra = cant * prec;
            aux = aux + compra;
        }
        for (int i = 0; i < productos.size(); i++) {
            au = productos.get(i);
            nombre = au.getNombre();
            codigo = au.getCodigo();
            precio = au.getPrecio();
            cantidades = au.getCantidades();
            marca = au.getMarca();
            pc = new ProductoEstudiantil(precio, marca, nombre, cantidades, codigo);
            try {
                pc.escribir(salidaco);
            } catch (IOException ex) {
                Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
            }
            Helper.volcado(salidaco, productos);

        }

        JOptionPane.showMessageDialog(this, "Su compra total es: " + aux + " pesos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        try {
            g = new Ganancia(aux);
            g.escribir(salida2);
        } catch (IOException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < productosac.size(); i++) {
            productosac.remove(i);
        }
        try {
            salida1 = new ObjectOutputStream(new FileOutputStream(ruta1));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }

        Helper.llenarTabla(tblCompra, ruta1);
        cmdEliminar.setEnabled(false);
        cmdBorrar.setEnabled(false);
    }//GEN-LAST:event_cmdComprarActionPerformed

    private void cmdGananciasActualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGananciasActualesActionPerformed

        Ganancia g = null;
        int aux = 0, comp;
        long t;
        ganancia = Helper.traerDatos(ruta2);
        for (int i = 0; i < ganancia.size(); i++) {
            g = ganancia.get(i);
            comp = g.getCompra();
            aux = aux + comp;

        }

        JOptionPane.showMessageDialog(this, "El total es: " + aux);
        cmdEliminar.setEnabled(false);
        cmdBorrar.setEnabled(false);
    }//GEN-LAST:event_cmdGananciasActualesActionPerformed

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
           Producto pc;
        String marca, nombre, codigo;
        int precio, cantidad;
        int sw, res;
        boolean aux2=true;

        int i;
        ProductoEstudiantil p;
        ArrayList<ProductoEstudiantil> productos = Helper.traerDatos(ruta);

    
        if (txtMarca.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty() || txtPrecio.getText().isEmpty()) {
            Helper.mensaje(this, "Seleccione un producto a agregar", aux);
        } else {
            
            do{
                sw=1;
                
                try{
            
            i = tblLista.getSelectedRow();
            p = productos.get(i);
            int cant = p.getCantidades(), aux = 0;
            marca = txtMarca.getText();
            nombre = txtNombre.getText();
            precio = Integer.parseInt(txtPrecio.getText());
            if (cant == 0) {
                Helper.mensaje(this, "No puede agregar este producto, las cantidades diponibles son 0 ", 3);
            } else {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite por favor la cantidad a comprar"));
                if (cantidad == 0) {
                    Helper.mensaje(this, "Agregue una cantidad valida", 3);
                } else {
                    codigo = txtCodigo.getText();
                    productosac = Helper.traerDatos(ruta1);
                    aux = cant - cantidad;
                    p.setCantidades(aux);

                    if (cantidad > cant) {
                        Helper.mensaje(this, "No puede agregar este producto, la cantidad a agregar excede las cantidades disponibles ", 3);
                    } else {
                        try {
                            pc = new ProductoEstudiantil(precio, marca, nombre, cantidad, codigo);
                            pc.escribir(salida1);
                        } catch (IOException ex) {
                            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            salida = new ObjectOutputStream(new FileOutputStream(ruta));
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Helper.volcado(salida, productos);
                        Helper.llenarTabla(tblLista, ruta);
                        Helper.llenarTabla(tblCompra, ruta1);
                        
                   
                        
                    
                        txtMarca.setText("");
                        txtNombre.setText("");
                        txtPrecio.setText("");
                        txtCantidades.setText("");
                        txtCodigo.setText("");
                     
                    }
                }
            }
        
                 } catch (NumberFormatException e) {
                   
                    res = JOptionPane.showConfirmDialog(this, "¿Desea Abandonar?", "Salr", JOptionPane.YES_NO_OPTION);
                    if (res == 0) {
                        sw = 1;
                       
                        aux2=false;
                    } else {
                        sw = 0;
                    }
            } 
            }while (sw == 0);
            }
    }//GEN-LAST:event_cmdAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Comprar dialog = new Comprar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdComprar;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdGananciasActuales;
    private javax.swing.JButton cmdSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtCantidades;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
