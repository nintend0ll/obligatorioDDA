/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Exceptions.PedidoException;
import Exceptions.ServicioException;
import Logica.Categoria;
import Logica.Dispositivo;
import Logica.Fachada;
import Logica.Item;

import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class ControladorPedidosCliente {
    private Fachada fachada = Fachada.getInstancia();
    private VistaPantallaClientes vista;
    private Dispositivo dispositivoActivo;
    private ControladorFachada controladorFachada;
    
    public ControladorPedidosCliente(VistaPantallaClientes vista, Dispositivo dispositivoActivo, ControladorFachada ctrl){
        this.vista = vista;
        this.dispositivoActivo = dispositivoActivo;
        this.controladorFachada = ctrl;
        cargarCategorias();
    }

  public void cargarCategorias(){
        ArrayList<Categoria> categorias = fachada.getCategorias(); 
        if(categorias == null || categorias.isEmpty()){
            vista.mostrarMensajes("Error al cargar categorías");
        }
        else{
            vista.mostraCategorias(categorias);
        }
    }
    
    // Items
    public void cargarItemsxCategoria(String categoria){
        ArrayList<Item> items = fachada.getItemsPorCategoriaConStock(categoria);
        vista.mostrarItemsxCategoria(items);
    }
    
    // Pedidos
    public void agregarPedido(Item item, String comentario) {
       try{
            if(dispositivoActivo.getCliente() == null){
                vista.mostrarMensajes("Error: debes identificarte antes de realizar pedidos.");
            }
            else{
                dispositivoActivo.getServicio().agregarPedido(item, comentario);
                mostrarPedidos();
                mostrarTotal();
                vista.mostrarMensajes("¡Pedido agregado con éxito!");
            }
       }
       catch(ServicioException e){
           vista.mostrarMensajes(e.getMessage());
       }
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
        float total = dispositivoActivo.getServicio().calcularMontoTotal();
        vista.mostrarTotal(total);
    }
    
    public void eliminarPedido(int pos){
        if(dispositivoActivo.getCliente() == null){
            vista.mostrarMensajes("Error: Debe identificarse antes de eliminar pedidos.");
        }
        else{
            try{
                dispositivoActivo.getServicio().eliminarPedido(pos);
                cargarItemsxCategoria(controladorFachada.getCategoriaSeleccionada());
                mostrarTotal();
                mostrarPedidos();
            }
            catch(ServicioException | PedidoException e){
                vista.mostrarMensajes(e.getMessage());
            }
        }
    }

}