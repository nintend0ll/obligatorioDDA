/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Exceptions.ClienteException;
import Exceptions.PedidoException;
import Exceptions.ServicioException;
import Logica.Categoria;
import Logica.Cliente;
import Logica.Dispositivo;
import Logica.Item;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorFachada {
     private VistaPantallaClientes vista;
    private ControladorLoginCliente ctrlLogin;
    private ControladorPedidosCliente ctrlPedidos;
    private ControladorServicioCliente ctrlServicio;
    private Dispositivo dispositivoActivo;
    private String categoria; // categoria seleccionada al momento para controladorServicio (actualizar)
    
    public ControladorFachada(VistaPantallaClientes vista) {
        this.vista = vista;
        this.dispositivoActivo = new Dispositivo();
        
        // Se pasa la referencia del dispositivo a los controladores que lo necesitan
        this.ctrlLogin = new ControladorLoginCliente(vista, dispositivoActivo);
        this.ctrlPedidos = new ControladorPedidosCliente(vista, dispositivoActivo, this);
        this.ctrlServicio = new ControladorServicioCliente(vista, dispositivoActivo, this);
    }

      // TODO: Mejorar login, hace demasiadas cosas
    public void login(String user, String pwd){
        ctrlLogin.login(user, pwd);
        // Recién acá existe el Servicio asignado al Dispositivo (luego del login)
        if (dispositivoActivo.getServicio() != null) {
            dispositivoActivo.getServicio().agregarObservador(ctrlServicio);
        }
    }
    
    // Categorias
    
    public void cargarCategorias(){
        ctrlPedidos.cargarCategorias();
    }
    
    // Items
    public void cargarItemsxCategoria(String categoria){
        this.categoria = categoria;
        ctrlPedidos.cargarItemsxCategoria(categoria);
    }
    
    // Pedidos
    public void agregarPedido(Item item, String comentario) {
        ctrlPedidos.agregarPedido(item, comentario);
    }
    
    public void mostrarPedidos(){
       if(dispositivoActivo.getServicio() == null){
           vista.cargarTabla(null);
       }
       else{
           vista.cargarTabla(dispositivoActivo.getServicio().getPedidos());
       }
    }
    

    // Total Pedidos
    public void mostrarTotal(){
        ctrlPedidos.mostrarTotal();
    }
    
    public void eliminarPedido(int pos){
        ctrlPedidos.eliminarPedido(pos);
    }
    
    public void confirmarPedidos(){
        ctrlServicio.confirmarPedidos();
    }

    public void finalizarServicio(){
        ctrlServicio.finalizarServicio();
    }
    
    public String getCategoriaSeleccionada(){
        return categoria;
    }

}
