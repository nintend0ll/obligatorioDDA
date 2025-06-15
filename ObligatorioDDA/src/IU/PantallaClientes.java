package IU;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Controladores.ControladorFachada;
import Controladores.VistaPantallaClientes;
import Logica.Categoria;
import Logica.Item;
import Logica.Pedido;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agust
 */
public class PantallaClientes extends javax.swing.JFrame implements VistaPantallaClientes {
    private ControladorFachada controlador;
    /**
     * Creates new form PantallaClientes
     */
    public PantallaClientes(String titulo) {
        initComponents();
        setVisible(true);
        setTitle(titulo);  
        controlador = new ControladorFachada(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsCategorias = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnConfirmarPedido = new javax.swing.JButton();
        btnFinalizarServicio = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsItems = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAgregarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lblMsj = new javax.swing.JTextArea();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lbl.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Categorías");

        lsCategorias.setBackground(new java.awt.Color(204, 204, 255));
        lsCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lsCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lsCategorias);

        tablaPedidos.setBackground(new java.awt.Color(204, 204, 255));
        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Comentario", "Estado", "Unidad", "Gestor", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaPedidos);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pedidos del servicio");

        btnConfirmarPedido.setBackground(new java.awt.Color(153, 153, 255));
        btnConfirmarPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnConfirmarPedido.setText("Confirmar Pedidos");
        btnConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidoActionPerformed(evt);
            }
        });

        btnFinalizarServicio.setBackground(new java.awt.Color(153, 153, 255));
        btnFinalizarServicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinalizarServicio.setText("Finalizar Servicio");
        btnFinalizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarServicioActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Items");

        lsItems.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane3.setViewportView(lsItems);

        txtComentario.setBackground(new java.awt.Color(204, 204, 255));
        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane4.setViewportView(txtComentario);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Comentario");

        lblMontoTotal.setBackground(new java.awt.Color(153, 153, 255));
        lblMontoTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMontoTotal.setText("Monto total: $");
        lblMontoTotal.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mensajes del sistema");

        btnAgregarPedido.setBackground(new java.awt.Color(153, 153, 255));
        btnAgregarPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarPedido.setText("Agregar Pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setBackground(new java.awt.Color(153, 153, 255));
        btnEliminarPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarPedido.setText("Eliminar Pedido");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel11.setText("Menú");

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUser.setText("Número Cliente:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Password:");

        txtUser.setBackground(new java.awt.Color(153, 153, 255));

        btnLogin.setBackground(new java.awt.Color(153, 153, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtPwd.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/login.png"))); // NOI18N

        lblMsj.setBackground(new java.awt.Color(255, 255, 204));
        lblMsj.setColumns(20);
        lblMsj.setForeground(new java.awt.Color(0, 0, 0));
        lblMsj.setRows(5);
        jScrollPane5.setViewportView(lblMsj);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(95, 95, 95)
                                            .addComponent(jLabel3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(29, 29, 29))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(btnConfirmarPedido)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnFinalizarServicio))))))
                                    .addGap(84, 84, 84)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(314, 314, 314)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(106, 106, 106)
                                            .addComponent(jLabel1)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblUser)
                                                    .addComponent(jLabel12))
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtUser)
                                                    .addComponent(txtPwd)))
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnAgregarPedido)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnEliminarPedido)))))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUser)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarPedido)
                            .addComponent(btnAgregarPedido))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFinalizarServicio)
                            .addComponent(btnConfirmarPedido))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lsCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lsCategoriasValueChanged
        // TODO add your handling code here:
        itemsCategoriaSeleccionada();
    }//GEN-LAST:event_lsCategoriasValueChanged

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        // TODO add your handling code here:
        agregarPedido();
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    private void btnConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoActionPerformed
        // TODO add your handling code here:
        confirmarPedidos();
    }//GEN-LAST:event_btnConfirmarPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        // TODO add your handling code here:
        eliminarPedido();
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnFinalizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarServicioActionPerformed
        // TODO add your handling code here:
        controlador.finalizarServicio();
    }//GEN-LAST:event_btnFinalizarServicioActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnFinalizarServicio;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JTextArea lblMsj;
    private javax.swing.JLabel lblUser;
    private javax.swing.JList<String> lsCategorias;
    private javax.swing.JList lsItems;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    
    
    private void login() {
        controlador.login(txtUser.getText(), new String(txtPwd.getPassword()));
        limpiarCampos();
    }

    @Override
    public void mostrarMensajes(String message) {
        lblMsj.setText(message);
    }
    
    private void limpiarCampos(){
        txtUser.setText("");
        txtPwd.setText("");
        lblMontoTotal.setText("Monto total: $");
    }
    
    // This should call the controlador in the future
    private void cargarCategorías(){
        controlador.cargarCategorias();
    }
    
    @Override
    public void mostraCategorias(ArrayList<Categoria> categorias) {
        // Is it better as objects or as strings? to be decided
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Categoria cat : categorias) {
            modelo.addElement(cat.getNombre()); 
        }
        lsCategorias.setModel(modelo);   
    }
    
    
    private void itemsCategoriaSeleccionada(){
        controlador.cargarItemsxCategoria(lsCategorias.getSelectedValue());
    }

    @Override
    public void mostrarItemsxCategoria(ArrayList<Item> items) {
        lsItems.setListData(items.toArray());
    }
    
    
    @Override
    public void mostrarClienteLogueado(String nombreCompleto){
        setTitle("Realizar pedidos - Cliente: " + nombreCompleto);
    }
    
    
    public void agregarPedido(){
        controlador.agregarPedido((Item) lsItems.getSelectedValue(), txtComentario.getText());
        
    }

    @Override
    public void cargarTabla(ArrayList<Pedido> pedidos) {
       
       DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();
       modelo.setRowCount(0); 
       
       if(pedidos != null){
            for (Pedido p : pedidos) {
                modelo.addRow(new Object[] {
                    p.getItem().getNombre(),
                    p.getComentario(),
                    p.getEstado().getEstado(),      
                    p.getUnidadProcesadora() == null ? "-": p.getUnidadProcesadora().getNombre(),
                    p.getGestor() == null ? "-": p.getGestor().getNombreCompleto(),     
                    "$" + p.getItem().getPrecioUnitario()
                });
             }
       }
    }

        @Override
    public void mostrarTotal(float total) {
        lblMontoTotal.setText("Monto total: $" + total);
    }
    
    public void eliminarPedido(){
        controlador.eliminarPedido(tablaPedidos.getSelectedRow());
    }
    
    public void confirmarPedidos(){
        controlador.confirmarPedidos();
    }

    @Override
    public void confirmarLectura() {
        JOptionPane.showMessageDialog(this, "¡Pago realizado!", "Come back soon", JOptionPane.INFORMATION_MESSAGE);
    }
}

     
